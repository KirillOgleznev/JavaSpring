package ru.myapp.garden;

import lombok.Data;

@Data
public class FrontGarden implements Garden{

    private final double length;
    private final double width;
    private final boolean lawn;

    public FrontGarden(double length, double width, boolean lawn){
        this.length = length;
        this.width = width;
        this.lawn = lawn;
    }
}
