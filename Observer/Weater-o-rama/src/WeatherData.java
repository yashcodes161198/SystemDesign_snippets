import Interfaces.Observer;
import Interfaces.Observable;

import java.util.ArrayList;

public class WeatherData implements Observable {
    ArrayList<Observer> observers;
    public float temperature;
    public float pressure;
    public float humidity;
    public WeatherData(){
        observers = new ArrayList<>();
    }
    public void setMeasurements(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }
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
        observers.forEach((observer -> {
            observer.update(temperature, pressure, humidity);
        }));
    }
}
