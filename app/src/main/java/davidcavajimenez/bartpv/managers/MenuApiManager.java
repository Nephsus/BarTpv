package davidcavajimenez.bartpv.managers;

import davidcavajimenez.bartpv.listener.OnTaskCompleted;
import davidcavajimenez.bartpv.models.Menu;
import davidcavajimenez.bartpv.models.MenuResponse;


public interface MenuApiManager {

    void donwloadMenu(OnTaskCompleted task);
}
