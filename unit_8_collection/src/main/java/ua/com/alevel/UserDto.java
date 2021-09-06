package ua.com.alevel;

import java.util.UUID;

public class UserDto {

    private String id;
    private String name;
    private String token;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.token = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}
