package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class contentmood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.content1, R.drawable.content2, R.drawable.content3, R.drawable.content4, R.drawable.content5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentmood);
        link = findViewById(R.id.contentlink);
        list = findViewById(R.id.contentlist);

        contentpage hp = new contentpage(this,str, images);
        list.setAdapter(hp);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://unsplash.com/s/photos/Udaipur%2C-Rajasthan?license=free&orientation=landscape");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });
    }
}