import java.util.*;
public class Dog extends MyObservable {

    private float height;
    private float weight;
    private String name;
    private boolean hasPooped;


    public Dog(float height, float weight, String name) {
        this.height = height;
        this.name = name;
        this.weight = weight;
        this.hasPooped = false;
    }  // end constructor

    public float getHeight() {
        return this.height;
    }

    public float getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

    public void poop() {
        System.out.println("I pooped today!");
        hasPooped = true;
        setChanged();
        notifyObservers(name);
    }
}