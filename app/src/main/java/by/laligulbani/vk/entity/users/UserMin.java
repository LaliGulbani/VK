package by.laligulbani.vk.entity.users;


import com.google.gson.annotations.SerializedName;

public class UserMin {
    /**
     * MyUser ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * MyUser first name
     */
    @SerializedName("first_name")
    private String firstName;

    /**
     * MyUser last name
     */
    @SerializedName("last_name")
    private String lastName;

    /**
     * Returns if a profile is deleted or blocked
     */
    @SerializedName("deactivated")
    private String deactivated;

    /**
     * Returns if a profile is hidden.
     */
    @SerializedName("hidden")
    private Integer hidden;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public Integer getHidden() {
        return hidden;
    }

}
