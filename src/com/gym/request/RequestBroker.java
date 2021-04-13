package com.gym.request;

import javax.swing.*;

import com.alibaba.fastjson.JSONObject;
import com.gym.component.ClickListener;
import com.gym.module.CateModule;
import com.gym.tool.UriAnalyzer;
import com.gym.view.JPanelWithTitle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class RequestBroker {

    private UriAnalyzer uriAnalyzer ;
    private String HOME;
    private JScrollPane canva;
    private CateModule cm=null;
    //private MydataModeule mydataModeule;
    private JLabel title;
    private JButton back;
    private Stack<JPanelWithTitle> stack=new Stack<JPanelWithTitle>();



    private void setTitle(String title){
        this.title.setText(title);this.title.updateUI();
    }
    private void saveCurrentPanel(){
        stack.push(new JPanelWithTitle(((JPanel) canva.getViewport().getView()),getTitleText()));
        back.setEnabled(true);
    }
    private void setCanva(JPanel requestResult){
        if(stack.isEmpty()){
            back.setEnabled(false);
        }
        System.out.println("try to set the Canva!");
        canva.setViewportView(requestResult);
        canva.validate();
        canva.repaint();
    }
    private void initParas(String HOME, JScrollPane canva,JLabel title,JButton back) {
        this.HOME=HOME;
        this.canva=canva;
        this.title=title;
        this.back=back;
        this.uriAnalyzer=new UriAnalyzer();
    }
    private void initModules(){
        this.cm=new CateModule(HOME,this);
    }
    private void initBackButton(){
        /*init back_button*/
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToLastPanel();
            }
        });
    }
    private void backToLastPanel(){
        if(!stack.isEmpty()) {
            JPanelWithTitle tempPanel = stack.pop();
            setTitle(tempPanel.getTitle());
            setCanva(tempPanel.getPanel());
        }else{
            JOptionPane.showMessageDialog(canva,"The page stack is empty!");
            back.setEnabled(false);
        }
    }


    public RequestBroker(String HOME, JScrollPane canva,JLabel title,JButton back){
        initParas(HOME, canva, title, back);
        initModules();
        initBackButton();
    }
    public JScrollPane getCanva() {
        return canva;
    }
    public String getTitleText(){return title.getText();}
    public void setGUI(JPanelWithTitle jp){
        saveCurrentPanel();
        setCanva(jp.getPanel());
        setTitle(jp.getTitle());
    }
    public void executeRequest(String uri) throws IOException {
        String action = UriAnalyzer.getType(uri);
        if (action.equals("cate")) {
            if (cm == null) {
                cm = new CateModule(HOME, this);
            }
            setGUI(cm.makeCategoryGUI(cm.fetchResource(uri)));
        } else if (action.equals("video")) {
            Desktop.getDesktop().open(new File(uri));
        } else if (action.equals("mydata")) {
            //module.makeOption
        } else {
            JOptionPane.showMessageDialog(canva, "This Action isn't supported by this version app!");
        }
    }
    public ClickListener makeClickListener(String uri){
        return new ClickListener(this,uri);
    }










}
