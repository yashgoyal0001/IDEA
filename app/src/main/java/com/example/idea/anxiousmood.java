package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class anxiousmood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.anxious1, R.drawable.anxious2, R.drawable.anxious3, R.drawable.anxious4, R.drawable.anxious5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anxiousmood);

        link = findViewById(R.id.anxiouslink);
        list = findViewById(R.id.anxiouslist);

        anxiouspage ap = new anxiouspage(this,str, images);
        list.setAdapter(ap);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://www.google.com/maps/place/Gangtok,+Sikkim/@27.3402059,88.5792752,13z/data=!3m1!4b1!4m6!3m5!1s0x39e6a56a5805eafb:0x73d6132c501c8f20!8m2!3d27.3313512!4d88.6138113!16zL20vMDR2ZGYy?entry=ttu");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });
    }
}