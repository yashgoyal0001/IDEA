package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class relaxedmood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.relaxed1, R.drawable.relaxed2, R.drawable.relaxed3, R.drawable.relaxed4, R.drawable.relaxed5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxedmood);
        link = findViewById(R.id.relaxedlink);
        list = findViewById(R.id.relaxedlist);

        relaxedpage hp = new relaxedpage(this,str, images);
        list.setAdapter(hp);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://www.google.com/maps/place/Kerala/@10.5387229,73.4954062,7z/data=!3m1!4b1!4m6!3m5!1s0x3b0812ffd49cf55b:0x64bd90fbed387c99!8m2!3d10.1631526!4d76.6412712!16zL20vMGJ5aDhq?entry=ttu");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });

    }
}