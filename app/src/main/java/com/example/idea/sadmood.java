package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class sadmood extends AppCompatActivity {
    TextView link;
    ListView list;
    String[] str = {"", "", "", "", ""};
    int[] images = {R.drawable.sad1, R.drawable.sad2, R.drawable.sad3, R.drawable.sad4, R.drawable.sad5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadmood);
        link = findViewById(R.id.sadlink);
        list = findViewById(R.id.sadlist);
        sadpage hp = new sadpage(this,str, images);
        list.setAdapter(hp);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://www.google.com/maps/place/Rishikesh,+Uttarakhand/@30.0878016,78.1882066,12z/data=!3m1!4b1!4m6!3m5!1s0x39093e67cf93f111:0xcc78804a6f941bfe!8m2!3d30.0869281!4d78.2676116!16zL20vMGNjdHZz?entry=ttu");
                Intent web = new Intent(Intent.ACTION_VIEW, page);
                startActivity(web);
            }
        });
    }
}