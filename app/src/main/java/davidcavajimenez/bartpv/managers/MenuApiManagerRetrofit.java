package davidcavajimenez.bartpv.managers;

import android.util.Log;

import davidcavajimenez.bartpv.listener.OnTaskCompleted;
import davidcavajimenez.bartpv.models.Menu;
import davidcavajimenez.bartpv.models.MenuResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MenuApiManagerRetrofit implements MenuApiManager {

    @Override
    public void donwloadMenu(final OnTaskCompleted task) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MenuService service = retrofit.create(MenuService.class);

        Call<MenuResponse> response = service.menuList();

        response.enqueue(new Callback<MenuResponse>() {


            @Override
            public void onResponse(Call<MenuResponse> call, Response<MenuResponse> response) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.onTaskCompleted( response.body() );
            }

            @Override
            public void onFailure(Call<MenuResponse> call, Throwable t) {
                Log.v("MIERDA", "Error");
                task.onTaskCompleted( null );
            }
        });

    }
}
