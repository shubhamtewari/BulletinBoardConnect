package api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class OpenWeatherMapJSONDataRetriever implements WeatherDataRetriever<String,String> {
    URL url;
    URLConnection urlConnection;
    @Override
    public String setupConn(String data) throws Exception {
        url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip="+data+",in&APPID="+new APIKey().getAPIKEY());
        urlConnection = url.openConnection();
        return getWeatherData();
    }

    @Override
    public String getWeatherData() throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                stringBuilder.append(line);
            }
        return stringBuilder.toString();
    }
}
