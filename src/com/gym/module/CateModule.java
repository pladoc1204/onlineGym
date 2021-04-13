package com.gym.module;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gym.component.CategoryItem;
import com.gym.request.RequestBroker;
import com.gym.tool.JSONTools;
import com.gym.view.JPanelWithTitle;

import javax.swing.*;
import java.awt.*;

public class CateModule implements Module{
    private String HOME;
    private RequestBroker  requestBroker;
    public CateModule(String HOME, RequestBroker requestBroker){
        this.HOME=HOME;
        this.requestBroker=requestBroker;
    }

    @Override
    public Object fetchResource(String uri) {
        return JSONTools.readJSONFromUri(uri);
    }
    private CategoryItem buildCateItem(JSONObject item){
        CategoryItem c= new CategoryItem(item.getString("image_src"),item.getString("name"),
                item.getInteger("video_count"),
                requestBroker.makeClickListener(item.getString("uri")));
        return c;
    }
    private CategoryItem buildVideoCateItem(JSONObject item){
        CategoryItem c= new CategoryItem(item.getString("image_src"),item.getString("name"),
                160,90,
                requestBroker.makeClickListener(item.getString("uri")));
        return c;
    }

    /*--------------------------------------------------------------*/

    public JPanelWithTitle makeCategoryGUI(Object cateObj) {
        String type  = ((JSONObject) cateObj).getString("type");
        String targetTitle = ((JSONObject) cateObj).getString("name");
        JPanel targetPanel = new JPanel(new GridLayout(3,0));
        if(type.equals("cate")){
            JSONArray itemArray = JSONTools.getItemArray((JSONObject) cateObj);
            if(itemArray.size()>0){
                System.out.println("begin build category panel!"); //For Test Only;
                for(int i=0;i<itemArray.size();i++){
                    System.out.println("adding "+i+" cate item into JPanel");
                    targetPanel.add(buildCateItem(itemArray.getJSONObject(i)).getMainComp());
                }
            }
        }else if(type.equals("video_cate")){
            JSONArray itemArray = JSONTools.getItemArray((JSONObject) cateObj);
            if(itemArray.size()>0){
                System.out.println("begin build Video_category panel!"); //For Test Only;
                for(int i=0;i<itemArray.size();i++){
                    System.out.println("adding "+i+" Video_cate item into JPanel");
                    targetPanel.add(buildVideoCateItem(itemArray.getJSONObject(i)).getMainComp());
                }
            }
        }
        return new JPanelWithTitle(targetPanel,targetTitle);
    }


}
