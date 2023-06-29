import Interfaces.DisplayElement;
import Interfaces.Observer;
import Interfaces.Subject;

public class CurrentConditionDisplay implements DisplayElement, Observer {
    public float temperature;
    public float pressure;
    public float humidity;
    public Subject weatherData;
    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees, " + humidity + "% humidity and " + pressure + " bar pressure");
    }

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
}
