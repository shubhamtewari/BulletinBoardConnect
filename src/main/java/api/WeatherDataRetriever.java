package api;

public interface WeatherDataRetriever<T, S> {
    T setupConn(S data) throws Exception;
    T getWeatherData() throws Exception;
}
