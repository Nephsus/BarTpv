package davidcavajimenez.bartpv.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.activities.MainActivity;
import davidcavajimenez.bartpv.adapters.DiningAdapter;
import davidcavajimenez.bartpv.adapters.DishRecyclerViewAdapter;
import davidcavajimenez.bartpv.adapters.MenuListAdapter;
import davidcavajimenez.bartpv.data.MenuData;
import davidcavajimenez.bartpv.models.Dinings;
import davidcavajimenez.bartpv.models.Dish;

import static davidcavajimenez.bartpv.fragments.DetailDishFragment.TABLE_KEY;


public class ListMenuFragment extends Fragment {


    private OnFragmentInteractionListener mListener;


    private Dinings mTable;

    public static ListMenuFragment newInstance( Dinings table ) {
        ListMenuFragment fragment = new ListMenuFragment();
        Bundle args = new Bundle();
        args.putSerializable( TABLE_KEY, table );
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

        mTable = (Dinings) getArguments().getSerializable(TABLE_KEY);

        View root = inflater.inflate(R.layout.fragment_list_menu, container, false);


        ListView lv =  (ListView) root.findViewById(R.id.menu_list_dish);

      final MenuListAdapter diningAdapter = new MenuListAdapter(getActivity(), MenuData.getInstance(getActivity()).getMenuResponse().getMenu().getDishes(), null);

        lv.setAdapter(  diningAdapter );

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ((MainActivity)getActivity()).detailDishTable( DetailDishFragment.newInstance( diningAdapter.getItem( i ) , mTable)  );
               /* FragmentManager fm = getFragmentManager();

                fm.beginTransaction().replace(R.id.fragment_container, DetailDishFragment.newInstance( diningAdapter.getItem( i ) , mTable) )
                        .addToBackStack( null )
                        .commit();*/




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
