package com.example.hitesh.jsongetandclick.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hitesh.jsongetandclick.MainActivity;
import com.example.hitesh.jsongetandclick.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ActorAdapter extends BaseAdapter{

    Context context;
    ArrayList<HashMap<String, String>> hashMapArrayList;
    int actor_layout;

    public ActorAdapter(MainActivity mainActivity, int actor_layout, ArrayList<HashMap<String, String>> hashMapArrayList) {

        this.context =mainActivity;
        this.hashMapArrayList =hashMapArrayList;
        this.actor_layout = actor_layout;
    }

    @Override
    public int getCount() {
        return hashMapArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1 = LayoutInflater.from(context).inflate(actor_layout,null);

        /*TextView name = (TextView)view1.findViewById(R.id.act_name);
        TextView disc = (TextView)view1.findViewById(R.id.act_disc);
        TextView dob = (TextView)view1.findViewById(R.id.act_dob);
        TextView country = (TextView)view1.findViewById(R.id.act_country);
        TextView height = (TextView)view1.findViewById(R.id.act_height);
        TextView spouse = (TextView)view1.findViewById(R.id.act_spouse);
        TextView children = (TextView)view1.findViewById(R.id.act_child);*/
        ImageView image = (ImageView) view1.findViewById(R.id.act_img);

        /*name.setText(hashMapArrayList.get(i).get("name"));
        disc.setText(hashMapArrayList.get(i).get("description"));
        dob.setText("DOB : "+hashMapArrayList.get(i).get("dob"));
        country.setText("Country : "+hashMapArrayList.get(i).get("country"));
        height.setText("Height : "+hashMapArrayList.get(i).get("height"));
        spouse.setText("Spouse : "+hashMapArrayList.get(i).get("spouse"));
        children.setText("Children : "+hashMapArrayList.get(i).get("children"));*/

        Picasso.with(context).load(hashMapArrayList.get(i).get("image")).into(image);


        return view1;
    }
}
