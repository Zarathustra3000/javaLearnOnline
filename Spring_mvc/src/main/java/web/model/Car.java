package web.model;

public class Car {
    private int id;
    private String model;
    private int number;
    private float price;

    public Car() {
    }

    public Car(String model, int number, float price) {
        this.model = model;
        this.number = number;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}
