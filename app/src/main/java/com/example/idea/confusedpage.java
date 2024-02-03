package com.example.idea;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class confusedpage extends ArrayAdapter {
    private final Activity context;
    private final String[] str;
    private final int[] images;

    public confusedpage(Activity context, String[] str, int[] images) {
        super(context, R.layout.confusedadapter, str);
        this.context = context;
        this.str = str;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.confusedadapter, null, true);
        TextView tv = view.findViewById(R.id.confusednotext);
        ImageView iv = view.findViewById(R.id.confusedimage);
        tv.setText(str[position]);
        iv.setImageResource(images[position]);
        return view;
    }
}
