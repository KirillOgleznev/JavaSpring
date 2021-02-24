package ru.myapp.garden;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;


@Data
public class House {

    private final Garden garden;
    private final String name;

    public House(String name, Garden garden)
    {
        this.garden = garden;
        this.name = name;
    }

    public static House houseFactory(){
        return new House("Test", new BackGarden(1,1));
    }

    public double getSquare()
    {
        return garden.getLength() * garden.getWidth();
    }

    public void turnOn()
    {
        System.out.println("Создание " + this.name);
    }

    public void turnOff()
    {
        System.out.println("Разрушение " + this.name);
    }
}
