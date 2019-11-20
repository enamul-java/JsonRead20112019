package com.bd.ehaquesoft.jsonread20112019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<String> names = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MyJsonTask().execute();
    }

    public class MyJsonTask extends AsyncTask<String, String, String> {

        private List<String> list;
        @Override
        protected String doInBackground(String... strings) {
            System.out.println("tihanek");
            list = new ArrayList<>();
            MyJsonReader myJsonReader = new MyJsonReader("https://api.myjson.com/bins/qj8aq");
            try {
                MainActivity.names.addAll(myJsonReader.getNamesList());
                list.addAll(myJsonReader.getNamesList());
                for (int i = 0; i < names.size(); i++) {
                    Log.e("Data", "Name"+i+":  "+ list.get(i).toString());
                }
                System.out.println("tigsos");
            } catch (JSONException e) {
                System.out.println("tisaref");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            System.out.println("tamot");
            Log.d("yoni",s);
        }
    }
}
