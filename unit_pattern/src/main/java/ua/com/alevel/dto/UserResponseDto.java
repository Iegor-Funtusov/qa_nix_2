package ua.com.alevel.dto;

import ua.com.alevel.entity.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class UserResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDay;
    private int age;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.birthDay = user.getBirthDay();
        this.age = generateAge(user);
    }

    private int generateAge(final User user) {
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(user.getBirthDay().getTime());
        LocalDate today = LocalDate.now();
        LocalDate userBirthDay = LocalDate.of(
                birthDay.get(Calendar.YEAR + 1),
                birthDay.get(Calendar.MONTH + 1),
                birthDay.get(Calendar.DAY_OF_MONTH + 1));
        Period period = Period.between(userBirthDay, today);
        return period.getYears();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public int getAge() {
        return age;
    }
}
