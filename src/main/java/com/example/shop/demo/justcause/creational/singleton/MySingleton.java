package com.example.shop.demo.justcause.creational.singleton;

public class MySingleton {

    private static MySingleton mySingleton;

   private MySingleton(){}

    public static MySingleton getInstance(){
        if (mySingleton == null) {
            synchronized (MySingleton.class) {
                if (mySingleton == null) {
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }

    //Double-Checked Locking: The getInstance() method first checks if mySingleton is null.
    // If it is, it synchronizes on the class object (MySingleton.class). Inside the synchronized block,
    // it checks again if mySingleton is still null (to prevent multiple instantiations in a
    // multithreaded environment) and creates the instance if it is.
}
