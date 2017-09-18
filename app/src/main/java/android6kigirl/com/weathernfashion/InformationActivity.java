package android6kigirl.com.weathernfashion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.bind(this);

    }
}
