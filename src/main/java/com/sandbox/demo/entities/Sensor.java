package com.sandbox.demo.entities;


import java.util.Random;

public class Sensor {
    private double temp;
    private double humi;
    private double stem;
    private double smoi;
    private double ph;

    public Sensor() {
    }

    public Sensor(double temp, double humi, double stem, double smoi, double ph) {
        this.temp = temp;
        this.humi = humi;
        this.stem = stem;
        this.smoi = smoi;
        this.ph = ph;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumi() {
        return humi;
    }

    public void setHumi(double humi) {
        this.humi = humi;
    }

    public double getStem() {
        return stem;
    }

    public void setStem(double stem) {
        this.stem = stem;
    }

    public double getSmoi() {
        return smoi;
    }

    public void setSmoi(double smoi) {
        this.smoi = smoi;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public static double getSensorReading(int min, int max){
        Random random = new Random(new Random().nextLong());
        int randomNum = random.nextInt((max - min) + 1) + min;
        return (randomNum*100)/100;
    }

    public void setterAll(){
        this.setHumi(getSensorReading(98, 100));
        this.setTemp(getSensorReading(34, 36));
        this.setSmoi(getSensorReading(98, 100));
        this.setStem(getSensorReading(34, 36));
        this.setPh(getSensorReading(3, 4));
    }

}
