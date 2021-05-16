package com.company.Model;

import java.util.ArrayList;
import java.util.List;

public class MemoryLogger implements ILogger{
    List<String> logs = new ArrayList<String>();

    @Override
    public void showAllLogs() {
        System.out.println("-------------------- logs --------------------");
        for (String log : logs) {
            System.out.println("[log] - " + log);
        }
        System.out.println("----------------------------------------------");
    }

    @Override
    public void log(String log) {
        logs.add(log);
    }
}
