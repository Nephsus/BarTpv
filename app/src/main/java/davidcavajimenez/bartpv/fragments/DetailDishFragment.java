package davidcavajimenez.bartpv.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.adapters.DishRecyclerViewAdapter;
import davidcavajimenez.bartpv.data.MenuData;
import davidcavajimenez.bartpv.models.Dinings;
import davidcavajimenez.bartpv.models.Dish;





public class DetailDishFragment  extends Fragment {

    private static final String DESCRIBABLE_KEY = "describable_key";
    public static final String TABLE_KEY = "table_key";
    private OnFragmentInteractionListener mListener;

    private  ImageView mImageView;
    private  TextView mTitle;
    private  TextView mDescription;

    private  ImageView mGluten;
    private  ImageView mCrustaceos;
    private  ImageView mHuevos;
    private  ImageView mLacteos;
    private  ImageView mPescado;



    private  Dinings mTable;
    private  Dish mDish;


    public static DetailDishFragment newInstance(Dish dish, Dinings table ) {
        DetailDishFragment fragment = new DetailDishFragment();
        Bundle args = new Bundle();
        args.putSerializable(DESCRIBABLE_KEY, dish);
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

        mDish = (Dish) getArguments().getSerializable(DESCRIBABLE_KEY);
        mTable = (Dinings) getArguments().getSerializable(TABLE_KEY);


        View root = inflater.inflate(R.layout.fragment_detail_dish, container, false);


        mImageView = (ImageView) root.findViewById(R.id.imagedish);
        mTitle = (TextView) root.findViewById(R.id.txtTitle);
        mDescription = (TextView) root.findViewById(R.id.txtDescription);

        mGluten  = (ImageView) root.findViewById(R.id.imagegluten);
        mCrustaceos = (ImageView) root.findViewById(R.id.imagecrustaceos);
        mHuevos = (ImageView) root.findViewById(R.id.imagehuevos);
        mLacteos = (ImageView) root.findViewById(R.id.imagelacteos);
        mPescado = (ImageView) root.findViewById(R.id.imagepescado);

        bindDish();


        FloatingActionButton addDish = (FloatingActionButton)root.findViewById(R.id.add_dish_to_table);

        addDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuData.getInstance(getActivity()).getListDishofTable().get( mTable.getId() ).add( mDish);
                Toast.makeText(getActivity(),"Se ha añadido el plato a la mesa " + mTable.getAlias(), Toast.LENGTH_SHORT ).show();

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


    public void bindDish() {
        byte[] decodedString = Base64.decode(mDish.getPhoto(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);
        mImageView.setImageBitmap(decodedByte);

        mTitle.setText( mDish.getTitle() );
        mDescription.setText( mDish.getDescription() );


        if(mDish.getAllergens()!= null && mDish.getAllergens().length > 0){

            for ( Integer i: mDish.getAllergens()) {

                switch (i) {

                    case 1:
                        mGluten.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mCrustaceos.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mHuevos.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        mLacteos.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        mPescado.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;

                }

            }


        }


    }


}
