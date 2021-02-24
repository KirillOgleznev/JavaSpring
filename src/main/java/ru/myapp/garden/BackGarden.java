package ru.myapp.garden;

import lombok.Data;

@Data
public class BackGarden implements Garden{

    private final double length;
    private final double width;

    public BackGarden(double length, double width){
        this.length = length;
        this.width = width;
    }
}
