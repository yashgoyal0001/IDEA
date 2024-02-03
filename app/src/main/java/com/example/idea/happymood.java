package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class happymood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.happy1, R.drawable.happy2, R.drawable.happy3, R.drawable.happy4, R.drawable.happy5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happymood);
        link = findViewById(R.id.happylink);
        list = findViewById(R.id.happylist);

        happypage hp = new happypage(this,str, images);
        list.setAdapter(hp);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://www.google.com/maps/place/Goa/@15.3500845,73.3471721,9z/data=!3m1!4b1!4m6!3m5!1s0x3bbfba106336b741:0xeaf887ff62f34092!8m2!3d15.2993265!4d74.123996!16zL20vMDFjMW5t?entry=ttu");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });

    }
}