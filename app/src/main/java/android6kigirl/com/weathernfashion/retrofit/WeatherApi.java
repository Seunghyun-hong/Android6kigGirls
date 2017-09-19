package android6kigirl.com.weathernfashion.retrofit;

import android6kigirl.com.weathernfashion.model.CurrentWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    String APP_ID = "3316b092a59a6858f30444012e97edc9";

    @GET("weather?lang=kr&units=metric&appid=" + APP_ID) // 항상 할꺼는 고정시켜버리고 (언어, 온도(섭시로)
    Call<CurrentWeather> getCurrentWeather(@Query("q") String cityName); // 쿼리는 이렇게 해주고. 바뀌는건
}