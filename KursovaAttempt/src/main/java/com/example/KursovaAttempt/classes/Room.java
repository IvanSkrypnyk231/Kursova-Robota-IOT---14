package com.example.KursovaAttempt.classes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Scope ("prototype")
@Component
public class Room {

    private static Integer freeId = 0;

    private Integer id;
    private Integer temperature;
    private Integer humidity;
    private Integer illumination;
    private HeatingBattery battery;

    public static boolean isValidRoom(Room room) {
        return room != null
                && room.humidity != null && room.humidity >= 0
                && room.temperature != null && room.temperature >= -10
                && room.illumination != null && room.illumination >= 100
                && room.battery != null
                && room.battery.getHeatConsumption() != null && room.battery.getHeatConsumption() >= 0
                && room.battery.getWaterTemperature() != null && room.battery.getWaterTemperature() >= 0;

    }

    public String getSensors(){
        return String.format("t: %d C; humidity: %d%%; Illumination: %d lux", temperature , humidity, illumination);
    }

    public String getBatterySensors(){
        return String.format("water temperature: %d C; heat consumption: %d J", battery.getWaterTemperature(), battery.getHeatConsumption());
    }

    @Override
    public String toString() {
        return "Room( " + id + "){" + getSensors() + "; " + getBatterySensors() + "}";
    }

    public void setAutoId (){
        id = freeId++;
    }

    public Room() {
        this.id = freeId;
    }
}




