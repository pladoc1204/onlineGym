package com.gym.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class JSONTools {
    public static Object readJSONFromUri(String uri){
        String jsonStr = "";
        Object cateObj=null;
        try {
            File file = new File(uri);
            FileReader fileReader = new FileReader(file);

            Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while((ch=reader.read())!=-1){
                sb.append((char)ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        cateObj= JSON.parse(jsonStr);


        return cateObj;
    }

    public static JSONArray getItemArray(JSONObject data){
        return (JSONArray)data.getJSONArray("item");
    }
}
