package davidcavajimenez.bartpv.adapters;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.data.MenuData;
import davidcavajimenez.bartpv.models.Dish;


public class DishRecyclerViewAdapter extends RecyclerView.Adapter<DishRecyclerViewAdapter.DishesViewHolder> {

    private LinkedList<Dish> mDishes;
    private View.OnClickListener mOnClickListener;

    public DishRecyclerViewAdapter(LinkedList<Dish> dishes) {
        super();
        mDishes = dishes;
     ;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    @Override
    public DishesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish, parent, false);
        view.setOnClickListener(mOnClickListener);
        return new DishesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DishesViewHolder holder, int position) {
        holder.bindDish(mDishes.get(position));
    }

    @Override
    public int getItemCount() {
        return mDishes.size();
    }

    protected class DishesViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView mTitle;
        private final TextView mDescription;
        private final TextView mPrice;

        private final ImageView mGluten;
        private final ImageView mCrustaceos;
        private final ImageView mHuevos;
        private final ImageView mLacteos;
        private final ImageView mPescado;


        public DishesViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imagedish);
            mTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            mDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            mPrice = (TextView) itemView.findViewById(R.id.txtPrice);

            mGluten  = (ImageView) itemView.findViewById(R.id.imagegluten);
            mCrustaceos = (ImageView) itemView.findViewById(R.id.imagecrustaceos);
            mHuevos = (ImageView) itemView.findViewById(R.id.imagehuevos);
            mLacteos = (ImageView) itemView.findViewById(R.id.imagelacteos);
            mPescado = (ImageView) itemView.findViewById(R.id.imagepescado);


        }

        public void bindDish(Dish dish) {
            byte[] decodedString = Base64.decode(dish.getPhoto(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);
            mImageView.setImageBitmap(decodedByte);

            mTitle.setText( dish.getTitle() );
            mDescription.setText( dish.getDescription() );
            mPrice.setText(MenuData.doubleToPrice( dish.getPrice() ) );

            if(dish.getAllergens()!= null && dish.getAllergens().length > 0){

                for ( Integer i: dish.getAllergens()) {

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
}
