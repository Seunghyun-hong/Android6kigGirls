package android6kigirl.com.weathernfashion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android6kigirl.com.weathernfashion.model.CurrentWeather;
import android6kigirl.com.weathernfashion.retrofit.WeatherUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private WeatherUtil mWeatherUtil;
    private EditText mFirstCityNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstCityNameEditText = (EditText) findViewById(R.id.first_city_edit_text);

        mWeatherUtil = new WeatherUtil();

    }

    public void onClickedSaveButton(View view) {
        search(mFirstCityNameEditText.getText().toString());
    }

    // 검색 기능을 만들자
    private void search(String cityName) {
        mWeatherUtil.getApiService().getCurrentWeather(cityName).enqueue(new Callback<CurrentWeather>() {
            @Override //성공
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
                intent.putExtra("temp", response.body().getMain().getTemp()); // 현재 온도 가져오기
                intent.putExtra("cityName", mFirstCityNameEditText.getText()); // 현재 지역 가져오기
                intent.putExtra("icon", response.body().getWeather().get(0).getIcon());
                startActivity(intent);

            }

            @Override //실패
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
