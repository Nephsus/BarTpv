package davidcavajimenez.bartpv.fragments;

import android.app.Fragment;
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

        View.OnClickListener prueba = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).detailDishTable();

            }
        };


        listView.setAdapter( new DiningAdapter( getActivity(), getDiningsTables(), prueba));

        return root;
    }

    private ArrayList<Dinings> getDiningsTables() {

         ArrayList<Dinings> tables = new ArrayList<>();

        tables.add( new Dinings(1,"Mesa 1", "Mesa de Comedor") );
        tables.add( new Dinings(2,"Mesa 2", "Mesa de Fumador") );
        tables.add( new Dinings(3,"Mesa 2", "Mesa de Comedor") );
        tables.add( new Dinings(4,"Mesa 2", "Mesa de Terraza") );
        tables.add( new Dinings(5,"Mesa 2", "Mesa de Terraza") );

        return  tables;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
