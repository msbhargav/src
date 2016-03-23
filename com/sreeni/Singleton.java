package com.sreeni;

/**
 * Created by smadiraju on 1/29/16.
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    //1. constructor is private so you can't extend
    //2. nobody can instantiate
    //3. singleton object immutable so, no multi-threading problems

    private Singleton(){
        System.out.println( " constructor invoked ");
    }

    public Singleton getInstance() {
        return singleton;
    }
}
