package davidcavajimenez.bartpv.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.activities.MainActivity;
import davidcavajimenez.bartpv.adapters.DishRecyclerViewAdapter;
import davidcavajimenez.bartpv.data.MenuData;
import davidcavajimenez.bartpv.models.Dish;


public class ListDishTableFragment extends Fragment {
    private static final String IDTABLE = "idTable";

    private OnFragmentInteractionListener mListener;

    private Integer mIdTable;


    public static ListDishTableFragment newInstance(Integer i ) {
        ListDishTableFragment fragment = new ListDishTableFragment();
        Bundle args = new Bundle();
        args.putInt(IDTABLE, i);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mIdTable = getArguments().getInt(IDTABLE);

        View root = inflater.inflate(R.layout.fragment_list_dish, container, false);

        TextView txtTable = (TextView) root.findViewById(R.id.title_table);

         txtTable.setText(  getResources().getString(R.string.table_list_dishes) + " " +MenuData.getInstance(getActivity()).getTables().get(mIdTable).getAlias() );


        //Recuperamos el recyclerView

        RecyclerView recycler = (RecyclerView) root.findViewById(R.id.recyclerdish);

        recycler.setLayoutManager(new LinearLayoutManager( getActivity() ));



        LinkedList<Dish> listDish = new LinkedList <Dish>();

        listDish.addAll(MenuData.getInstance(getActivity()).getListDishofTable().get( mIdTable ) );

        DishRecyclerViewAdapter dishRecyclerViewAdapter = new DishRecyclerViewAdapter( listDish );



        recycler.setAdapter( dishRecyclerViewAdapter );

        FloatingActionButton addButton  = (FloatingActionButton) root.findViewById(R.id.add_dish);
        FloatingActionButton bill  = (FloatingActionButton) root.findViewById(R.id.bill);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ((MainActivity)getActivity()).detailDishTable(ListMenuFragment.newInstance( MenuData.getInstance(getActivity()).getTables().get( mIdTable )) );
              /*  FragmentManager fm = getFragmentManager();

                fm.beginTransaction().replace(R.id.fragment_container, ListMenuFragment.newInstance( MenuData.getInstance(getActivity()).getTables().get( mIdTable )) )
                                     .addToBackStack( null )
                                     .commit();*/

            }
        });

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

                alertDialogBuilder.setTitle("Calculo de la cuenta");
                Double totalImport = 0.0;

                for (Dish dish: MenuData.getInstance(getActivity()).getListDishofTable().get( mIdTable)) {

                    totalImport+=  dish.getPrice();

                }


                alertDialogBuilder
                        .setMessage("La cuenta de la mesa asciende a un total de " + MenuData.doubleToPrice( totalImport ))
                        .setCancelable(true);

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();


            }
        });



        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




}
