package android6kigirl.com.weathernfashion.retrofit;

import android6kigirl.com.weathernfashion.model.CurrentWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    String APP_ID = "3316b092a59a6858f30444012e97edc9";

    @GET("weather?lang=kr&units=metric&appid=" + APP_ID)
    Call<CurrentWeather> getCurrentWeather(@Query("q") String cityName);
}