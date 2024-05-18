package com.ayupov.Bank.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RestController
public class Controller {
    private HibernateUtil hu;

    @GetMapping(value = "/home")
    public String getTestData() {
        return "Hello";
    }

    @PostMapping
    public User login(String email, String password){
        User user = null;
        Session s = hu.getSession();
        try
		{
			String query = "from User user where user.email=email and user.password=password";
			Query<User> q = s.createQuery(query, User.class);
			user = q.getSingleResult();
		}
		catch (Exception e)
		{
			user = null;
		}
        s.close();
        return user;
    }

    @PostMapping
    public User register(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}