package com.gym.view;

import com.gym.request.RequestBroker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    private JPanel ButtonArea;
    private JScrollPane canva;
    private JButton categoryButton;
    private JPanel mainWindow;
    private JButton searchButton;
    private JButton liveButton;
    private JButton calendarButton;
    private JButton myDataButton;
    private JPanel titleBar;
    private JButton back;
    private JLabel title;
    private JPanel TitleArea;
    private String HOME;
    private RequestBroker requestBroker;

    public MainFrame(String HOME){
        this.HOME=HOME;
        back.setEnabled(false);
        cancelAllButtonBorder();
        requestBroker=new RequestBroker(HOME,canva,title,back);
        addListenersToButtons();
    }

    private void cancelAllButtonBorder() {
        cancelButtonBackground(calendarButton);
        cancelButtonBackground(categoryButton);
        cancelButtonBackground(searchButton);
        cancelButtonBackground(myDataButton);
        cancelButtonBackground(liveButton);
        cancelButtonBackground(back);
    }

    public void cancelButtonBackground(JButton jButton){
        jButton.setBorder(null);
        jButton.setContentAreaFilled(false);
    }
    public JPanel getMainWindow() {
        return mainWindow;
    }
    private void addListenersToButtons() {


        /*adding Listener to function button*/
        categoryButton.addMouseListener(requestBroker.makeClickListener("cate/cate.json"));
        myDataButton.addMouseListener(requestBroker.makeClickListener("mydata/userid=xxx"));
    }


}
