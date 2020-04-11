package com.greeting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Greeting")
public class Greeting {

    @Id
    private long Id;

    @Column(name = "message")
    private String message;

    public long getId() {
        return Id;
    }

    public void setId(long incrementAndGet) {
        this.Id = incrementAndGet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String format) {
        this.message = format;
    }
}
