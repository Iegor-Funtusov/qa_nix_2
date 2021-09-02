package ua.com.alevel.entity;

import java.util.Date;

public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public static Builder newUser() {
        return new User().new Builder();
    }

    public class Builder {

        private Builder() { }

        public Builder setId(String id) {
            User.this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setBirthDay(Date birthDay) {
            User.this.birthDay = birthDay;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
