package com.coo.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by aa on 2018/11/1.
 */
public class Starter {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:*.xml");

    }
}
