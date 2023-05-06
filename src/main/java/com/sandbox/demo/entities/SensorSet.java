package com.sandbox.demo.entities;

import java.time.LocalDateTime;

public class SensorSet {
    Sensor sensor;

    private String sensorName;
    private String sensorTime;
    private String id;

    public SensorSet(String id, String sensorName, Sensor sensor, String sensorTime) {
        this.sensorName = sensorName;
        this.sensor = sensor;
        this.sensorTime = sensorTime;
        this.id = id;
    }

    public SensorSet() {
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorTime() {
        return sensorTime;
    }

    public void setSensorTime(String sensorTime) {
        this.sensorTime = sensorTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}