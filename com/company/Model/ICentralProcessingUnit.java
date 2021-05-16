package com.company.Model;

public interface ICentralProcessingUnit
{
    boolean turnOnCooler();
    boolean turnOfCooler();
    void signIn() throws InterruptedException;
    int getTemperature();
    void run() throws InterruptedException;
    void log(String log);
    void showAllLogs();
}
