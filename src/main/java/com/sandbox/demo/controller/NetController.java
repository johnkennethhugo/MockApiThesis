package com.sandbox.demo.controller;


import com.sandbox.demo.entities.Sensor;
import com.sandbox.demo.entities.SensorSet;
import com.sandbox.demo.service.DataPayload;
import com.sandbox.demo.service.SensorOperate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class NetController {

    public static List sensorSets = new ArrayList<SensorSet>();

    // test commit
    @GetMapping("/1")
    public Sensor getReading(){
        Sensor sensor = new Sensor();
        sensor.setterAll();
        return sensor;
    }


    @GetMapping("/all")
    public List<SensorSet> sensorsSet(){
        return SensorOperate.getSet();
    }

    @GetMapping("/complete")
    public List<DataPayload> payloads(){
        return SensorOperate.getPayload(SensorOperate.getSet());
    }

    @PostMapping("/add")
    public void addSensor(@RequestBody String IP){
        SensorOperate.writeNew(IP);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteSensor(@PathVariable("id") String id){
        SensorOperate.deleteIP(id);
    }


}
