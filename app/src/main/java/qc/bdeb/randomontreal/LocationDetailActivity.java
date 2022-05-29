package qc.bdeb.randomontreal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationDetailActivity extends AppCompatActivity {
    ImageView imgLocDetails;
    TextView txtLocDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);


        imgLocDetails = findViewById(R.id.imgLocDetail);
        txtLocDetails = findViewById(R.id.location);
        Intent intent = getIntent();

        imgLocDetails.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_foreground));
        txtLocDetails.setText(intent.getStringExtra("detail"));
    }
}