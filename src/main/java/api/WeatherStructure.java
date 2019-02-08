package api;

import java.time.LocalDate;
import java.time.LocalTime;

public class WeatherStructure {

    private Days list[];

    public Days[] getList() {
        return list;
    }

    /**
     * get the temperature object  of the corresponding date provided
     * @param daysList list of days retrieved
     * @param date date provided
     * @return temperature object with dats's temperature
     */
    public Temperature getTemperatureFrom(Days daysList[], LocalDate date) {
        Temperature currentTemp = new Temperature();
        //System.out.println(date.toString());
        boolean flag = true;
        for (Days a : daysList) {
            if (a.getDt_txt().substring(0, 10).equals(date.toString())) {
                int time = (Integer.parseInt(LocalTime.now().toString().charAt(0) + "") * 10) + (Integer.parseInt(LocalTime.now().toString().charAt(1) + ""));
                int giventime = (Integer.parseInt(a.getDt_txt().charAt(11) + "") * 10) + (Integer.parseInt(a.getDt_txt().charAt(12) + ""));
                float tempMin = a.getMain().getTemp_min();
                float tempMax = a.getMain().getTemp_max();
                float humidity = a.getMain().getHumidity();
                //System.out.println(time);
                if (time < 12 && flag) {
                    tempMin = a.getMain().getTemp_min();
                    tempMax = a.getMain().getTemp_max();
                    humidity = a.getMain().getHumidity();
                    currentTemp.setTemp_min(tempMin);
                    currentTemp.setTemp_max(tempMax);
                    currentTemp.setHumidity(humidity);
                    break;
                } else if (time >= 0 && time < 3) {
                    time = time + 3;
                    break;
                } else if (time - 3 <= giventime) {
                    tempMin = a.getMain().getTemp_min();
                    tempMax = a.getMain().getTemp_max();
                    humidity = a.getMain().getHumidity();
                    currentTemp.setTemp_min(tempMin);
                    currentTemp.setTemp_max(tempMax);
                    currentTemp.setHumidity(humidity);
                    break;
                } else {
                    currentTemp.setTemp_min(tempMin);
                    currentTemp.setTemp_max(tempMax);
                    currentTemp.setHumidity(humidity);
                }
                flag = false;
            }

        }
        return currentTemp;
    }

    /**
     * get the weather conditions object of the date provided
     * @param daysList list of days retrieved
     * @param currentDate date provided
     * @return temperature object with dats's temperature
     */
    public Weather getWeatherFrom(Days daysList[], LocalDate currentDate) {
        Weather weather = new Weather();

        for (Days a : daysList) {
            if (a.getDt_txt().substring(0, 10).equals(currentDate.toString())) {
                weather.setMain(a.getWeather()[0].getMain());
                weather.setDescription(a.getWeather()[0].getDescription());
            }
        }
        return weather;
    }

    /**
     * get the wind object of the date provided
     * @param daysList list of days retrieved
     * @param currentDate date provided
     * @return temperature object with dats's temperature
     */
    public Wind getWindFrom(Days daysList[], LocalDate currentDate) {
        Wind wind = new Wind();

        for (Days a : daysList) {
            if (a.getDt_txt().substring(0, 10).equals(currentDate.toString())) {
                wind.setSpeed(a.getWind().getSpeed());
            }
        }
        return wind;
    }
}
