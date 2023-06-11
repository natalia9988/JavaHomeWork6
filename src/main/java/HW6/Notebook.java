package HW6;

public class Notebook {
    String brand;
    String model;
    String opSystem;
    String color;

    // Конструктор
    public Notebook(String brand, String model, String opSystem, String color){
        this.brand = brand.toUpperCase();
        this.model = model.toUpperCase();
        this.opSystem = opSystem.toUpperCase();
        this.color = color.toLowerCase();
    }


    // Сэттеры
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setOpSystem(String opSystem) {
        this.opSystem = opSystem;
    }
    public void setColor(String color) {
        this.color = color;
    }

    //Геттеры
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getOpSystem() {
        return opSystem;
    }
    public String getColor() {
        return color;
    }


    //Вывод в консоль
    public void showInfo(){
        System.out.println(String.format("Производитель: %s\nМодель: %s\nОС: %s\nЦвет: %s\n",
                this.brand, this.model, this.opSystem, this.color));
    }

    @Override
    public String toString() {
        return (String.format("Производитель: %s\nМодель: %s\nОС: %s\nЦвет: %s\n"+"\n",
                this.brand, this.model, this.opSystem, this.color));
    }
}







