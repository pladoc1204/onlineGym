package com.gym.tool;

import java.util.HashMap;

/***
 * Uri format:
 *       gym.com/category/?cate=xxxxx&video=xxxxx
 */

public class UriAnalyzer{


    public static   String getType(String uri){
        uri.trim();
        String[] splitedUri=uri.split("/");
        System.out.println("Type:"+splitedUri[0]);
        return splitedUri[0];
    }

    public  static HashMap<String,String> getPara(String uri){

        HashMap<String,String> result = new HashMap<String, String>();
        String[] temp;

        uri.trim();
        String paras=uri.split("\\?")[1];
        String[] paraArray=paras.split("&");

        for(String parapair:paraArray){
            temp=parapair.split("=");
            System.out.println(temp[0]+":"+temp[1]);
            result.put(temp[0],temp[1]);
        }

        return result;
    }



}
