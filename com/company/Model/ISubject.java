package com.company.Model;

public interface ISubject
{
    void addObserver(IObserver observer);

    void notify(TemperatureCriticalMessage message);
}
