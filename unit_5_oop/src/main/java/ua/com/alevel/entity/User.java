package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User extends BaseEntity {

    private String name;
    private int age;

//    @Override
//    public void setId(String id) {
//        super.setId(id);
//    }
}
