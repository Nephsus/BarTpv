package davidcavajimenez.bartpv.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;



public class ParentActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;



    protected void showDonwloading(){
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.setProgressStyle(android.R.attr.spinnerStyle);

        mProgressDialog.setCancelable(false);

        mProgressDialog.show();
    }

    protected void dissmissDonwloading(){
        mProgressDialog.dismiss();
    }

}
