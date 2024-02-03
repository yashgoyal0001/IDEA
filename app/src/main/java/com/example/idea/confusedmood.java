package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class confusedmood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.confused1, R.drawable.confused2, R.drawable.confused3, R.drawable.confused4, R.drawable.confused5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confusedmood);
        link = findViewById(R.id.confusedlink);
        list = findViewById(R.id.confusedlist);

       confusedpage hp = new confusedpage(this,str, images);
        list.setAdapter(hp);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://www.google.com/maps/place/Varanasi,+Uttar+Pradesh/@25.3208949,82.9087066,12z/data=!3m1!4b1!4m6!3m5!1s0x398e2db76febcf4d:0x68131710853ff0b5!8m2!3d25.3176452!4d82.9739144!16zL20vMDFqOTIy?entry=ttu");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });
    }
}