package com.sfedu;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello World!!! Java application");
        for (int i = 0; i < args.length; i++){
            System.out.print("Param " + i + " = " + args[i]);
        }

        Random random = new Random();
        System.out.println(random.nextInt());
    }
}