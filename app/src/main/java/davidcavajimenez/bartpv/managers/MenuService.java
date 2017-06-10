package davidcavajimenez.bartpv.managers;

import java.util.List;

import davidcavajimenez.bartpv.models.Dinings;
import davidcavajimenez.bartpv.models.Menu;
import davidcavajimenez.bartpv.models.MenuResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface MenuService {

    //http://www.mocky.io/v2/5931b4550f000094055bfb81

    @GET("59398a3a1200003b12a67685")
    Call<MenuResponse> menuListFirst();


    @GET("59398be61200006f12a67689")
    Call<MenuResponse> menuListSeconds();


}
