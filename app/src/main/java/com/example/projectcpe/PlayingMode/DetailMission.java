package com.example.projectcpe.PlayingMode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectcpe.Play;
import com.example.projectcpe.R;

public class DetailMission extends AppCompatActivity {

    ImageView btPlay;
    TextView txName, txNumstep, txAge, DetailMission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mission);

        bindData();




    }

    private void bindData() {
        btPlay = findViewById(R.id.btPlay);
        txName = findViewById(R.id.Name);
        txAge = findViewById(R.id.Age);
        txNumstep = findViewById(R.id.numstep);
        DetailMission = findViewById(R.id.DetailMission);
    }

    public void setBtPlayClick(View view){
        startActivity(new Intent(DetailMission.this, PlayPage.class));
        finish();
    }
}
