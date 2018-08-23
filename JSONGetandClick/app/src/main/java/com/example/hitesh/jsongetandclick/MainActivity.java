package com.example.hitesh.jsongetandclick;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hitesh.jsongetandclick.Adapters.ActorAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String Actor_URL = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";

    ListView listView;
    ArrayList<HashMap<String,String>> hashMapArrayList =new ArrayList<>();
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.actor_list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,ShowDetails.class);
                intent.putExtra("ch",hashMapArrayList.get(position).get("children"));
                intent.putExtra("na",hashMapArrayList.get(position).get("name"));
                intent.putExtra("db",hashMapArrayList.get(position).get("dob"));
                intent.putExtra("sp",hashMapArrayList.get(position).get("spouse"));
                intent.putExtra("co",hashMapArrayList.get(position).get("country"));
                intent.putExtra("he",hashMapArrayList.get(position).get("height"));
                intent.putExtra("di",hashMapArrayList.get(position).get("description"));
                startActivity(intent);

            }
        });
        new ActorData().execute();

    }

    private class ActorData extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Connecting");
            dialog.setTitle("Loading");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            ActorDataParser dataParser = new ActorDataParser();
            String result = dataParser.getJson(Actor_URL);

            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray =jsonObject.getJSONArray("actors");

                for (int i =0;i<jsonArray.length();i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String name = jsonObject1.getString("name");
                    String disc = jsonObject1.getString("description");
                    String dob = jsonObject1.getString("dob");
                    String country = jsonObject1.getString("country");
                    String height = jsonObject1.getString("height");
                    String spouse = jsonObject1.getString("spouse");
                    String children = jsonObject1.getString("children");
                    String image = jsonObject1.getString("image");


                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("name",name);
                    hashMap.put("description",disc);
                    hashMap.put("dob",dob);
                    hashMap.put("country",country);
                    hashMap.put("height",height);
                    hashMap.put("spouse",spouse);
                    hashMap.put("children",children);
                    hashMap.put("image",image);

                    hashMapArrayList.add(hashMap);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            dialog.dismiss();
            ActorAdapter adapter = new ActorAdapter(MainActivity.this,R.layout.actor_layout,hashMapArrayList);
            listView.setAdapter(adapter);
            super.onPostExecute(aVoid);
        }
    }
}
