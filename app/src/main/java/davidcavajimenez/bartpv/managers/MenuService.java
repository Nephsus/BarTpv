package davidcavajimenez.bartpv.managers;

import java.util.List;

import davidcavajimenez.bartpv.models.Dinings;
import davidcavajimenez.bartpv.models.Menu;
import davidcavajimenez.bartpv.models.MenuResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface MenuService {

    //http://www.mocky.io/v2/5931b4550f000094055bfb81

    @GET("593d3e831100007b12722a9d`")
    Call<MenuResponse> menuListFirst();


    @GET("59398be61200006f12a67689")
    Call<MenuResponse> menuListSeconds();


}
