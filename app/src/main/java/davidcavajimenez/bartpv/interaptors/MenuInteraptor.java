package davidcavajimenez.bartpv.interaptors;


import davidcavajimenez.bartpv.listener.OnTaskCompleted;
import davidcavajimenez.bartpv.managers.MenuApiManager;

public class MenuInteraptor {

    private MenuApiManager mMenuApiManager;

    public MenuInteraptor(MenuApiManager menuApiManager){
         mMenuApiManager = menuApiManager;
     }

     public void getMenu(final OnTaskCompleted task){
         mMenuApiManager.donwloadMenu( task );
     }



}
