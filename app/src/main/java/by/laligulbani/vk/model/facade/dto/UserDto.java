package by.laligulbani.vk.model.facade.dto;

public class UserDto {

    private final String firstName;
    private final String lastName;
    private final String image;

    public UserDto(String firstName, String lastName, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImage() {
        return image;
    }
}
