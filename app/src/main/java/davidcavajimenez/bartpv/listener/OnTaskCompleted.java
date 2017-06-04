package davidcavajimenez.bartpv.listener;

/**
 * Created by davidcavajimenez on 4/6/17.
 */

public interface OnTaskCompleted<T> {
    void onTaskCompleted( T result);
}
