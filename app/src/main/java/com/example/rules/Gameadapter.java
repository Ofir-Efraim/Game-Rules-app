package com.example.rules;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Gameadapter extends ArrayAdapter<Gamedes> {

    Context context;

    List<Gamedes> objects;

    public Gameadapter(Context context, int resource, int textViewResourceId , List<Gamedes> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.objects = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_layout,parent,false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvAges = view.findViewById(R.id.tvAges);
        ImageView ivGame = view.findViewById(R.id.ivGame);

        Gamedes temp = objects.get(position);

        if (temp != null)

        {

            ivGame.setImageBitmap(temp.getBitmap());

            tvName.setText("" + temp.getName());

            tvAges.setText(temp.getAges());


        }
        return view;

    }
}
