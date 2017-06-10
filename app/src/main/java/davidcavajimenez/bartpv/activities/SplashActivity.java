package davidcavajimenez.bartpv.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.data.MenuData;
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
       // setContentView(R.layout.activity_main);



        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, 3000);

    }


    private void nextActivity(){
       // this.dissmissDonwloading();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }


    @Override
    public void onTaskCompleted( MenuResponse menuResponse) {
        MenuData.getInstance(this).setMenuResponse( menuResponse );
        nextActivity();
    }



}
