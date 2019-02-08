package api;

public class Days {
    private String dt_txt;
    private Temperature main;
    private Weather weather[];
    private Clouds clouds;
    private Wind wind;

    public String getDt_txt() {
        return dt_txt;
    }

    public Temperature getMain() {
        return main;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }
}
