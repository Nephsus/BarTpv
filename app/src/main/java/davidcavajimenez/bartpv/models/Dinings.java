package davidcavajimenez.bartpv.models;



public class Dinings {

    private Integer mId;
    private String alias;
    private String Description;


    public Dinings(Integer id, String alias, String description) {
        mId = id;
        this.alias = alias;
        Description = description;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
