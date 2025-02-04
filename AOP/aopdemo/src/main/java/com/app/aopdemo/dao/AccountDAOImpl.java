package com.app.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + " DOING MY DB WORK: Adding an Account");
    }
}
