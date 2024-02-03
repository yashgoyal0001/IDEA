package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class playfulmood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.playful1, R.drawable.playful2, R.drawable.playful3, R.drawable.playful4, R.drawable.playful5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfulmood);
        link = findViewById(R.id.playfullink);
        list = findViewById(R.id.playfullist);

        playfulpage hp = new playfulpage(this,str, images);
        list.setAdapter(hp);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://google.com/maps/place/Bengaluru,+Karnataka/@12.9544595,77.3012647,10z/data=!3m1!4b1!4m6!3m5!1s0x3bae1670c9b44e6d:0xf8dfc3e8517e4fe0!8m2!3d12.9715987!4d77.5945627!16zL20vMDljMTc?entry=ttu");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });
    }
}