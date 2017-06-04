package davidcavajimenez.bartpv.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.models.Dinings;



public class DiningAdapter extends BaseAdapter {

    private ArrayList<Dinings> mDinigs;

    private View.OnClickListener mOnClickListener;

    private Context mContext;

    public DiningAdapter(Context context, ArrayList<Dinings> dinings, View.OnClickListener onClickListener){
        super();
        this.mDinigs = dinings;
        mContext = context;
        this.mOnClickListener = onClickListener;
    }



    @Override
    public int getCount() {
        return  this.mDinigs.size();
    }

    @Override
    public Dinings getItem(int i) {
        return  this.mDinigs.get( i );
    }

    @Override
    public long getItemId(int i) {
        return  i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view =  LayoutInflater.from(mContext).inflate(R.layout.dining_row, viewGroup, false);
        }

        TextView itemAlias = (TextView) view.findViewById(R.id.txtViewAlias);
        TextView itemDescription = (TextView)view.findViewById(R.id.txtViewDescription);




        TableRow tr = (TableRow) view.findViewById(R.id.row);

        tr.setClickable(true);

        itemAlias.setOnClickListener(mOnClickListener);
        tr.setOnClickListener(mOnClickListener);

        itemAlias.setText( getItem( i ).getAlias() );
        itemDescription.setText( getItem( i ).getDescription() );

        tr.setTag(getItem( i ));
        itemAlias.setTag( getItem( i ) );

        return view;
    }
}
