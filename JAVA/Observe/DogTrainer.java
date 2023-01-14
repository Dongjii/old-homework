import java.util.*;
public class DogTrainer implements MyObserver {
    private String name;

    public DogTrainer(String name) {
        this.name = name;

    }

    public String getName() {
        return this.name;
    }

    public void update(MyObservable o, Object arg) {

        System.out.println("Hey, " + name + " was notified that " + (String)arg +  " pooped.");

    }
}