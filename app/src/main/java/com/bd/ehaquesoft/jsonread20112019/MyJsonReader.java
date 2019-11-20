package com.bd.ehaquesoft.jsonread20112019;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MyJsonReader {

    protected static String url;
    private JSONObject jsonObject;
    private String rawData;

    public MyJsonReader(String url) {
        this.url = url;
        System.out.println("inshalla teshalshel");
    }

    private JSONObject readFromUrl() throws JSONException, IOException {
        System.out.println("koshlaeme shelha");
        InputStream is = new URL(this.url).openStream();
        BufferedReader buf = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String json = readAll(buf);
        jsonObject = new JSONObject(json);
        System.out.println("teharben");
        return jsonObject;
    }

    private String readAll(BufferedReader buf) throws IOException {
        System.out.println("ya ben shel zona");
        StringBuilder sb = new StringBuilder();
        String ch;
        while ((ch = buf.readLine()) != null) {
            sb.append(ch);
        }
        rawData = sb.toString();
        System.out.println(rawData);
        return sb.toString();
    }

    public List<String> getNamesList() throws JSONException, IOException {
        System.out.println("ya rohev al ofnaim bli kise");
        List<String> names = new ArrayList<>();
        JSONObject object = readFromUrl();
        JSONArray array = object.getJSONArray("employees");
        for (int i = 0; i < array.length(); i++) {
            JSONObject name = array.getJSONObject(i);
            String employeeName = name.getString("firstname");
            System.out.println(employeeName);
            names.add(employeeName);
        }
        return names;
    }
}
