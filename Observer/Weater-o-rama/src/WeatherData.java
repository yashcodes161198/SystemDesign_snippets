import Interfaces.Observer;
import Interfaces.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    ArrayList<Observer> observers;
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        int index = observers.indexOf(o);
        if(index >= 0){
            observers.remove(index);
        }
    }
    public void notifyObservers(){

    }
}
