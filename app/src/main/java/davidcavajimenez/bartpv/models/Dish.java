
package davidcavajimenez.bartpv.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dish  implements Serializable{


    private String title;

    private String description;

    private Integer[] allergens;

    private Double price;

    private String photo;

    Dish(){
        super();
    }

    public Dish(String title, String description,Integer[] allergens,Double price, String photo) {
        this.title = title;
        this.description = description;
        this.allergens = allergens;
        this.price = price;
        this.photo = photo;
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer[] getAllergens() {
        return allergens;
    }

    public void setAllergens(Integer[] allergens) {
        this.allergens = allergens;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
