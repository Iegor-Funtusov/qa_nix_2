package ua.com.alevel;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {

    private Integer id;
    private String name;
    private Integer user_id;
}
