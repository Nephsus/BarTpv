package davidcavajimenez.bartpv.activities;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.data.MenuData;
import davidcavajimenez.bartpv.fragments.DiningTableFragment;
import davidcavajimenez.bartpv.fragments.ListDishTableFragment;
import davidcavajimenez.bartpv.fragments.OnFragmentInteractionListener;
import davidcavajimenez.bartpv.interaptors.MenuInteraptor;
import davidcavajimenez.bartpv.listener.OnTaskCompleted;
import davidcavajimenez.bartpv.managers.MenuApiManagerRetrofit;
import davidcavajimenez.bartpv.models.MenuResponse;


public class MainActivity extends ParentActivity implements OnFragmentInteractionListener, OnTaskCompleted<MenuResponse> {

    private   MenuResponse mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getFragmentManager();


        if (fragmentManager.findFragmentById( R.id.fragment_container) == null){
            DiningTableFragment df = DiningTableFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.fragment_container,df).commit();

            this.showDonwloading();

            MenuInteraptor menuInteraptor = new MenuInteraptor( new MenuApiManagerRetrofit() );
            menuInteraptor.getMenu( this );

        }

        if( findViewById(R.id.right_container) != null){

            if (fragmentManager.findFragmentById( R.id.right_container) == null){

                ListDishTableFragment listDishTableFragment =  ListDishTableFragment.newInstance( 0 );   //Cargamos la primera mesa por defecto
                fragmentManager.beginTransaction().add(R.id.right_container,listDishTableFragment).commit();
            }

            if( (fragmentManager.findFragmentById( R.id.fragment_container) instanceof  DiningTableFragment) == false ){
                DiningTableFragment df = DiningTableFragment.newInstance();
                fragmentManager.beginTransaction().replace(R.id.fragment_container,df).commit();

            }


        }

    }





    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onTaskCompleted(MenuResponse result) {
        MenuData.getInstance(this).setMenuResponse( result );
        this.dissmissDonwloading();
    }
}
