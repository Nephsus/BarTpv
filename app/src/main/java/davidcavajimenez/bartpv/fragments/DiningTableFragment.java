package davidcavajimenez.bartpv.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.activities.MainActivity;
import davidcavajimenez.bartpv.adapters.DiningAdapter;
import davidcavajimenez.bartpv.data.MenuData;
import davidcavajimenez.bartpv.models.Dinings;


public class DiningTableFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    public DiningTableFragment() {
        // Required empty public constructor
    }



    public static DiningTableFragment newInstance( ) {
        DiningTableFragment fragment = new DiningTableFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dining_table, container, false);

        ListView listView = (ListView) root.findViewById(R.id.dining_tables);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((MainActivity)getActivity()).detailDishTable( ListDishTableFragment.newInstance( i ) );

            }
        });

        listView.setAdapter( new DiningAdapter( getActivity(), MenuData.getInstance(getActivity()).getTables(), null));

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
