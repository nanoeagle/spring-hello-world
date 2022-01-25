package com.example.springhelloworld.database.hibernate.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractHibernateDao {
    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;
}