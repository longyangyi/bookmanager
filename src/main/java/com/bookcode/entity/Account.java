package com.bookcode.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_account")
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50)
    private String userName;
    private float balance;

    public Account() {
        super();
    }
    public Account(String userName, float balance) {
        this.userName = userName;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
}
