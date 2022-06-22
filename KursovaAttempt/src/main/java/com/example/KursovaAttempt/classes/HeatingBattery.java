package com.example.KursovaAttempt.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeatingBattery {
    private Integer waterTemperature;
    private Integer heatConsumption;


    public HeatingBattery(Integer waterTemperature, Integer heatConsumption) {
        this.waterTemperature = waterTemperature;
        this.heatConsumption = heatConsumption;
    }
}
