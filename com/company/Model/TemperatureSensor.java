package com.company.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TemperatureSensor implements ITemperatureSensor{
    int maxTemperature = 30;
    int minTemperature = 10;
    List<IObserver> observerList = new ArrayList<>();

    @Override
    public int getTemperature() {
        int temp = getRandomTemperature();
        TemperatureCriticalMessage message = new TemperatureCriticalMessage();
        message.temperature = temp;
        if(temp > maxTemperature)
        {
            message.type = MessageType.HIGH_TEMPERATURE;
            notify(message);
        }
        else if(temp < minTemperature)
        {
            message.type = MessageType.LOW_TEMPERATURE;
            notify(message);
        }
        return temp;
    }

    public int getRandomTemperature()
    {
        Random random = new Random();
        return random.ints(0, 50)
                .findFirst().getAsInt();
    }

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void notify(TemperatureCriticalMessage message)
    {
        for (IObserver observer : observerList) {
            observer.update(message);
        }
    }
}
