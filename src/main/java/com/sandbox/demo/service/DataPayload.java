package com.sandbox.demo.service;

import com.sandbox.demo.entities.SensorSet;

import java.time.LocalDateTime;
import java.util.List;

public class DataPayload {
    private static List<SensorSet> sensorPayload;
    private static String payloadTime, payloadDate;

    public DataPayload() {
    }

    public List<SensorSet> getSensorPayload() {
        return sensorPayload;
    }

    public void setSensorPayload(List<SensorSet> sensorPayload) {
        this.sensorPayload = sensorPayload;
    }

    public String getPayloadTime() {
        return payloadTime;
    }

    public void setPayloadTime(String payloadTime) {
        this.payloadTime = payloadTime;
    }

    public String getPayloadDate() {
        return payloadDate;
    }

    public void setPayloadDate(String payloadDate) {
        this.payloadDate = payloadDate;
    }
}
