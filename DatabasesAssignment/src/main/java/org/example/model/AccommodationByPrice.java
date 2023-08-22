package org.example.model;

public class AccommodationByPrice {

    private String type;
    private String bed_type;
    private int max_guests;
    private String description;
    private double price;

    @Override
    public String toString() {
        return "AccommodationByPrice{" +
                "type='" + type + '\'' +
                ", bed_type='" + bed_type + '\'' +
                ", max_guests=" + max_guests +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBed_type() {
        return bed_type;
    }

    public void setBed_type(String bed_type) {
        this.bed_type = bed_type;
    }

    public int getMax_guests() {
        return max_guests;
    }

    public void setMax_guests(int max_guests) {
        this.max_guests = max_guests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
