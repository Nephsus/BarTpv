package davidcavajimenez.bartpv.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.models.Dinings;
import davidcavajimenez.bartpv.models.Dish;


public class MenuListAdapter  extends BaseAdapter {

    private ArrayList<Dish> mDishes;

    private View.OnClickListener mOnClickListener;

    private Context mContext;

    public MenuListAdapter(Context context, ArrayList<Dish> dishes, View.OnClickListener onClickListener){
        super();
        this.mDishes = dishes;
        mContext = context;
        this.mOnClickListener = onClickListener;
    }



    @Override
    public int getCount() {
        return  this.mDishes.size();
    }

    @Override
    public Dish getItem(int i) {
        return  this.mDishes.get( i );
    }

    @Override
    public long getItemId(int i) {
        return  i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view =  LayoutInflater.from(mContext).inflate(R.layout.dish_row, viewGroup, false);
        }

        TextView dish = (TextView) view.findViewById(R.id.dish_name);



        dish.setText( getItem( i ).getTitle() );



        return view;
    }

}
