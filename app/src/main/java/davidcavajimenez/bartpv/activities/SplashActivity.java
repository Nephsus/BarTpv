package davidcavajimenez.bartpv.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import davidcavajimenez.bartpv.interaptors.MenuInteraptor;
import davidcavajimenez.bartpv.listener.OnTaskCompleted;
import davidcavajimenez.bartpv.managers.MenuApiManagerRetrofit;
import davidcavajimenez.bartpv.managers.MenuService;
import davidcavajimenez.bartpv.models.MenuResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SplashActivity extends ParentActivity implements OnTaskCompleted<MenuResponse> {

    public MenuResponse mMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.showDonwloading();
        MenuInteraptor menuInteraptor = new MenuInteraptor( new MenuApiManagerRetrofit() );

        menuInteraptor.getMenu( this );

    }


    private void nextActivity(){
        this.dissmissDonwloading();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }


    @Override
    public void onTaskCompleted( MenuResponse menuResponse) {
        mMenu = menuResponse;
        nextActivity();
    }



}
