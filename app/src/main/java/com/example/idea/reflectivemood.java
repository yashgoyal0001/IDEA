package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class reflectivemood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.reflexive1, R.drawable.reflexive2, R.drawable.reflexive3, R.drawable.reflexive4, R.drawable.reflexive5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflectivemood);
        link = findViewById(R.id.reflectivelink);
        list = findViewById(R.id.reflectivelist);
        reflectivepage rp = new reflectivepage(this, str, images);
        list.setAdapter(rp);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://www.google.com/maps/place/Dharamshala,+Himachal+Pradesh/@32.2168132,76.2985656,14z/data=!3m1!4b1!4m6!3m5!1s0x391b50df65bd7311:0x3e08bdb100c6dc10!8m2!3d32.219042!4d76.3234037!16s%2Fm%2F0j65lnw?entry=ttu");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });
    }
}