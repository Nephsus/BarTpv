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

        Call<MenuResponse> response = service.menuListFirst();
       final Call<MenuResponse> responseSecond = service.menuListSeconds();

        response.enqueue(new Callback<MenuResponse>() {


            @Override
            public void onResponse(Call<MenuResponse> call, final Response<MenuResponse> response) {
                Log.v("ee","ff");

                responseSecond.enqueue(new Callback<MenuResponse>() {


                    @Override
                    public void onResponse(Call<MenuResponse> call, final Response<MenuResponse> responseSecond) {
                        Log.v("ee","ff");

                        task.onTaskCompleted( merge(response.body(), responseSecond.body()) );
                    }

                    @Override
                    public void onFailure(Call<MenuResponse> call, Throwable t) {
                        Log.v("MIERDA", "Error");
                        // task.onTaskCompleted( null );
                    }
                });




                //task.onTaskCompleted( response.body() );
            }

            @Override
            public void onFailure(Call<MenuResponse> call, Throwable t) {
                Log.v("MIERDA", "Error");
               // task.onTaskCompleted( null );
            }
        });






    }

    private MenuResponse merge(MenuResponse first, MenuResponse second){

        first.getMenu().getDishes().addAll(second.getMenu().getDishes());

        return first;

    }
}
