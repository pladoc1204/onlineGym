package com.gym.main;

import com.gym.request.RequestBroker;
import com.gym.view.MainFrame;

import javax.swing.*;

public class MainApplication {

    private JFrame jf;
    private String HOME="D:/workplace/onlineGym/";
    //private RequestBroker requestBroker;

    private void init(){
        jf = new JFrame("Online GYM");
        jf.setSize(480,720);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        MainFrame mainFrame= new MainFrame(HOME);
        jf.setContentPane(mainFrame.getMainWindow());
        jf.setVisible(true);
    }
    //private  void destory(){}

    public static void main(String[] args) {
        MainApplication mainApplication=new MainApplication();
        mainApplication.init();
        //mainApplication.destory();
    }
}
