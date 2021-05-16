package com.company;

import com.company.Model.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CoolerSystem system = new CoolerSystem(
                new Actuator(),
                new TemperatureSensor(),
                new MemoryLogger(),
                new DB()
        );

        DB db = new DB();
        system.signIn();
    }
}
