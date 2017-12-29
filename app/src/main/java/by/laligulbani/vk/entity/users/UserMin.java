package by.laligulbani.vk.entity.users;


import com.google.gson.annotations.SerializedName;

public class UserMin {
    /**
     * MyUser ID
     */
    @SerializedName("uid")
    private String id;

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

    public String getId() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDeactivated(String deactivated) {
        this.deactivated = deactivated;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }
}
