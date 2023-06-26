package org.example;

public abstract class Samsung implements Phone {
    private String color;
    private String material;
    private String osSystem;
    protected int batteryLife;

    public Samsung(String color, String material,int batteryLife) {
        this.color = color;
        this.material = material;
        this.osSystem = "Android";
        this.batteryLife = batteryLife;
    }
}
