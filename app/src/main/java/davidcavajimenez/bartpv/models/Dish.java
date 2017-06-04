
package davidcavajimenez.bartpv.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dish {


    public String title;

    public String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
