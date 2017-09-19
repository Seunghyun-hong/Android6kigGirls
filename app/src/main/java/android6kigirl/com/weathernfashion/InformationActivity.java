package android6kigirl.com.weathernfashion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import android6kigirl.com.weathernfashion.retrofit.WeatherUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InformationActivity extends AppCompatActivity {

    @BindView(R.id.output_text_view)
    TextView outputTextView;
    @BindView(R.id.weather_image_view)
    ImageView weatherImageView;
    @BindView(R.id.current_temp_text_view)
    TextView currentTempTextView;
    @BindView(R.id.sun_text_view)
    TextView sunTextView;
    @BindView(R.id.air_text_view)
    TextView airTextView;
    @BindView(R.id.cody_image_view)
    ImageView codyImageView;
    @BindView(R.id.cody_text_view)
    TextView codyTextView;

    private WeatherUtil mWeather;
    private double mTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.bind(this);


        mWeather = new WeatherUtil();
        Intent intent = getIntent();
        String name = intent.getStringExtra("cityName");
        mTemp = intent.getDoubleExtra("temp", 0);
        outputTextView.setText(name); // 받아온 도시이름 설정해주기
        currentTempTextView.setText("현재기온 : " + mTemp); // 받아온 기온 설정하기.
        Glide.with(this).load(intent.getIntExtra("icon",0)).into(weatherImageView);  // 받아온 날씨이미지 넣기!

        setWeatherCody();
    }


    private void setWeatherCody() {
        if (mTemp <= 5) { // 온도가 5도 이하
            codyImageView.setImageResource(R.drawable.cody5);
        } else if (5 < mTemp && mTemp <= 9) {
            codyImageView.setImageResource(R.drawable.cody9);
        } else if (9 < mTemp && mTemp <= 11) {
            codyImageView.setImageResource(R.drawable.cody11);
        } else if (11 < mTemp && mTemp <= 16) {
            codyImageView.setImageResource(R.drawable.cody16);
        } else if (16 < mTemp && mTemp <= 19) {
            codyImageView.setImageResource(R.drawable.cody19);
        } else if (19 < mTemp && mTemp <= 22) {
            codyImageView.setImageResource(R.drawable.cody22);
        } else if (22 < mTemp && mTemp <= 26) {
            codyImageView.setImageResource(R.drawable.cody26);
        } else {
            codyImageView.setImageResource(R.drawable.cody27);
        }
    }
}
