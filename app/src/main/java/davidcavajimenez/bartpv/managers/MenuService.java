package davidcavajimenez.bartpv.managers;

import java.util.List;

import davidcavajimenez.bartpv.models.Dinings;
import davidcavajimenez.bartpv.models.Menu;
import davidcavajimenez.bartpv.models.MenuResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface MenuService {

    //http://www.mocky.io/v2/5931b4550f000094055bfb81

    @GET("5932acc50f0000d91b5bfc40")
    Call<MenuResponse> menuList();
}
