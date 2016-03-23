package com.sreeni;

/**
 * Created by smadiraju on 1/29/16.
 */
public class PrivateConstructor {

    private static final PrivateConstructor PrivateConstructor = new PrivateConstructor();
    private PrivateConstructor(){
        System.out.println("test");
    }
}

