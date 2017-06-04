package davidcavajimenez.bartpv.activities;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.fragments.DiningTableFragment;
import davidcavajimenez.bartpv.fragments.ListDishTableFragment;
import davidcavajimenez.bartpv.models.MenuResponse;


public class MainActivity extends ParentActivity{

    private   MenuResponse mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();


        if (fragmentManager.findFragmentById( R.id.fragment_container) == null){

            FragmentTransaction ft =  fragmentManager.beginTransaction();
            DiningTableFragment df = DiningTableFragment.newInstance();

            ft.add(R.id.fragment_container,df).commit();

        }
    }



    public void detailDishTable(){

        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new ListDishTableFragment(), "NewFragmentTag");
        ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        ft.commit();

    }




}
