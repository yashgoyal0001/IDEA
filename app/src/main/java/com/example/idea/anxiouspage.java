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

public class anxiouspage extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] str;
    private final int[] images;

    public anxiouspage(Activity context, String[] str, int[] images) {
        super(context, R.layout.anxiousadapter, str);
        this.context = context;
        this.str = str;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.anxiousadapter, null, true);
        TextView tv = view.findViewById(R.id.anxiousnotext);
        ImageView iv = view.findViewById(R.id.anxiousimage);
        tv.setText(str[position]);
        iv.setImageResource(images[position]);
        return view;
    }
}
