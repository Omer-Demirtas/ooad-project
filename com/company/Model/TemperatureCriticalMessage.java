package com.company.Model;

public class TemperatureCriticalMessage
{
    int temperature;
    MessageType type;

    @Override
    public String toString() {
        String message = "Critical Temperature : %s with %dC";
        return String.format(message, type == MessageType.LOW_TEMPERATURE ? "LOW" : "HIGH" , temperature);
    }
}
