package davidcavajimenez.bartpv.activities;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.fragments.ListDishTableFragment;


public class ParentActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;



    protected void showDonwloading(){
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mProgressDialog.setProgressStyle(android.R.attr.spinnerStyle);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        mProgressDialog.setContentView(R.layout.progress_layout);



    }

    protected void dissmissDonwloading(){
        mProgressDialog.dismiss();
    }



    public void detailDishTable(Fragment newFragment){

        if( findViewById(R.id.right_container) == null){

        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_slide_left_enter,
                R.animator.fragment_slide_left_exit,
                R.animator.fragment_slide_right_enter,
                R.animator.fragment_slide_right_exit).replace(R.id.fragment_container, newFragment ).addToBackStack(null).commit();

        }else{

            getFragmentManager().beginTransaction().setCustomAnimations(R.animator.fragment_slide_left_enter,
                    R.animator.fragment_slide_left_exit,
                    R.animator.fragment_slide_right_enter,
                    R.animator.fragment_slide_right_exit).replace(R.id.right_container, newFragment ).addToBackStack(null).commit();


        }


    }

}
