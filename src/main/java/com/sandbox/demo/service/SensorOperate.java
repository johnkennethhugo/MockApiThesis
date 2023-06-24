package com.sandbox.demo.service;

import com.sandbox.demo.entities.Sensor;
import com.sandbox.demo.entities.SensorSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SensorOperate {
    public SensorOperate() {
    }
    static DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss.SS");
    static DateTimeFormatter date = DateTimeFormatter.ofPattern("dd, MMMM yyyy");
    public static final String PATH_NAME = "D:\\000-Documents\\INTELLIJ\\demo\\src\\main\\text.txt";
    public static List<SensorSet> getSet(){
        ArrayList<SensorSet> sensorSets = new ArrayList<SensorSet>();

        ArrayList<String> sensorIPs = new ArrayList<String>();
        sensorIPs.addAll(readAll());

        for (int i = 0; i<sensorIPs.size(); i++){
            Sensor sensor = new Sensor();
            sensor.setterAll();
            SensorSet sensorSet = new SensorSet(
                    sensorIPs.get(i).toString().replaceAll("192.168.1.",""),
                    sensorIPs.get(i).toString(),
                    sensor,time.format(LocalDateTime.now()));

            sensorSets.add(sensorSet);
        }
        return sensorSets;
    }

    public static List<DataPayload> getPayload( List<SensorSet> sensorSets){
        ArrayList<DataPayload> data = new ArrayList<DataPayload>();
        DataPayload dataPayload = new DataPayload();
        dataPayload.setSensorPayload(sensorSets);
        dataPayload.setPayloadTime(time.format(LocalDateTime.now()));
        dataPayload.setPayloadDate(date.format(LocalDateTime.now()));
        data.add(dataPayload);
        return data;
    }
    public static void writeNew(String text){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_NAME, true));
            writer.write(text.replaceAll("=","\n"));
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Set<String> readAll(){
        Set<String> sensorIP = new TreeSet();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH_NAME));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sensorIP.add(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sensorIP;
    }

    public static void deleteIP(String text){
        text = "192.168.1." + text;
        ArrayList<String> tempSet = new ArrayList<String>();
        tempSet.addAll(readAll());
        tempSet.remove(text);

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_NAME));
            for(int i=0; i<tempSet.size();i++){
                writer.write(tempSet.get(i).toString());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
