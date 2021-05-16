package com.company.Model;

public class Actuator implements IActuator{

    @Override
    public boolean turnOnCooler() {
        return true;
    }

    @Override
    public boolean turnOfCooler() {
        return true;
    }
}
