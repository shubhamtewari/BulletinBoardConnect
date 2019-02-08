package api;

public class Temperature {
    private float temp_min;
    private float temp_max;
    private float humidity;

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
