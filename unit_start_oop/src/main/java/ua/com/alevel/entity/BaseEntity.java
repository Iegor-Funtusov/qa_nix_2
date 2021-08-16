package ua.com.alevel.entity;

import java.util.Date;

public abstract class BaseEntity {

    private String id;
    private Date created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
