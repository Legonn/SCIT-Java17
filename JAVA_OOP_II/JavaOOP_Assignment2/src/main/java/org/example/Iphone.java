package org.example;

public abstract class Iphone implements Phone {
    private String color;
    private String material;
    private String osSystem;
    protected int batteryLife;

    public Iphone(String color, String material, int batteryLife) {
        this.color = color;
        this.material = material;
        this.osSystem = "iOS";
        this.batteryLife = batteryLife;
    }
}
