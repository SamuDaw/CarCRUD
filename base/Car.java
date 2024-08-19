package base;

public class Car {
    private String description;
    private int horsePower;
    private float weightInKg;
    private float maxSpeed;

    public Car(){}

    public Car(String description, int horsePower, float weightInKg, float maxSpeed){
        this.description = description;
        this.horsePower = horsePower;
        this.weightInKg = weightInKg;
        this.maxSpeed = maxSpeed;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getHorsePower(){
        return this.horsePower;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    public float getWeightInKg(){
        return this.weightInKg;
    }

    public void setWeightInKg(float weightInKg){
        this.weightInKg = weightInKg;
    }

    public float getMaxSpeed(){
        return this.maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public String toString(){
        return "\n----------\n" + "Description: " + this.description + "\nHorse Power: " + this.horsePower + "\nWeight in Kg: " + this.weightInKg + "\nMax Speed: " + this.maxSpeed;
    }

}
