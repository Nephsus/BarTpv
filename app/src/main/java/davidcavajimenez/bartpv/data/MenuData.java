package davidcavajimenez.bartpv.data;


import android.content.Context;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import davidcavajimenez.bartpv.R;
import davidcavajimenez.bartpv.models.Dinings;
import davidcavajimenez.bartpv.models.Dish;
import davidcavajimenez.bartpv.models.MenuResponse;

public class MenuData {

    private MenuResponse mMenuResponse;



    private final ArrayList<Dinings> tables = new ArrayList<Dinings>();
    private final HashMap<Integer,ArrayList<Dish>> listDishofTable = new HashMap<Integer,ArrayList<Dish>>() ;
    private Context mContext;

    public static final HashMap<Integer, Integer> allergens = new HashMap<Integer, Integer>()
    {{
        put(1, R.drawable.icono_gluten);
        put(2, R.drawable.icono_crustaceos);
        put(3, R.drawable.icono_huevos);
        put(4, R.drawable.icono_lacteos);
        put(5, R.drawable.icono_pescado);

    }};

    private static MenuData ourInstance;

    private MenuData() {
    }

    public static MenuData getInstance( Context context ) {

        if(ourInstance == null) {
            ourInstance = new MenuData();
            ourInstance.mContext = context;
            ourInstance.genetateDummyDiningsTables();
            ourInstance.generateDummyDishData();
        }
        return ourInstance;
    }

    private void generateDummyDishData(){
        ArrayList dummyArray = new ArrayList<Dish>();

        dummyArray.add( new Dish("Macarrones" , "Macarrones boloñesa con carne picada", new Integer[]{1,3}, 5.00 ,mContext.getResources().getString(R.string.macarrones_base64) ) );
        dummyArray.add( new Dish("Albóndigas" , "Albóndigas con tomate", new Integer[]{4}, 7.30 , mContext.getResources().getString(R.string.albondigas_base64)) );
        dummyArray.add( new Dish("Merluza" , "Merluza en salsa verde", new Integer[]{2,5}, 15.20 , mContext.getResources().getString(R.string.merluza_base64)) );

        getListDishofTable().put(0, dummyArray);

        dummyArray = new ArrayList<Dish>();

        dummyArray.add( new Dish("Albóndigas" , "Albóndigas con tomate", new Integer[]{1,3}, 7.30 , mContext.getResources().getString(R.string.albondigas_base64)) );
        dummyArray.add( new Dish("Merluza" , "Merluza en salsa verde", new Integer[]{2,5}, 15.20 , mContext.getResources().getString(R.string.merluza_base64)) );

        getListDishofTable().put(1, dummyArray);

        dummyArray = new ArrayList<Dish>();

        dummyArray.add( new Dish("Albóndigas" , "Albóndigas con tomate", new Integer[]{1,3}, 7.30 , mContext.getResources().getString(R.string.albondigas_base64)) );


        getListDishofTable().put(2, dummyArray);

    }


    private ArrayList<Dinings> genetateDummyDiningsTables() {

        tables.add( new Dinings(0,"Mesa 1", "Mesa de Comedor") );
        tables.add( new Dinings(1,"Mesa 2", "Mesa de Fumador") );
        tables.add( new Dinings(2,"Mesa 3", "Mesa de Terraza") );


        return  tables;
    }



    public MenuResponse getMenuResponse() {
        return mMenuResponse;
    }

    public void setMenuResponse(MenuResponse menuResponse) {
        mMenuResponse = menuResponse;
    }

    public ArrayList<Dinings> getTables() {
        return tables;
    }

    public HashMap<Integer, ArrayList<Dish>> getListDishofTable() {
        return listDishofTable;
    }

    public static  String doubleToPrice(double dbl) {
        Locale locale =new Locale("fr", "FR");

        DecimalFormatSymbols sym = new DecimalFormatSymbols(locale);
        sym.setGroupingSeparator('.');
        sym.setDecimalSeparator(',');
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setDecimalFormatSymbols(sym);
        return decimalFormat.format(dbl);
    }
}
