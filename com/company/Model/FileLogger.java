package com.company.Model;

public class FileLogger implements ILogger{
    @Override
    public void showAllLogs() {
        System.out.println("tüm loglar");
    }

    @Override
    public void log(String log) {
        System.out.println("dosyaya yaz");
    }
}
