import Interfaces.DisplayElement;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        DisplayElement currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);


    }
}