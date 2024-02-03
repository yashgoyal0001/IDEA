package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class angrymood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.angry1, R.drawable.angry2, R.drawable.angry3, R.drawable.angry4, R.drawable.angry5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angrymood);

        link = findViewById(R.id.angrylink);
        list = findViewById(R.id.angrylist);

        angrypage ap = new angrypage(this,str, images);
        list.setAdapter(ap);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://www.google.com/maps/search/+Ladakh,+Jammu+and+Kashmir/@33.9814727,74.8029823,7z/data=!3m1!4b1?entry=ttu");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });
    }
}