package com.gym.component;

import com.gym.request.RequestBroker;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class ClickListener implements MouseListener {
    private RequestBroker requestBroker;
    private String uri;
    @Override
    public void mouseClicked(MouseEvent e) {
        if(uri.equals("null")){
            JOptionPane.showMessageDialog(requestBroker.getCanva(),"requested item is invalid!");
        }else{
            System.out.println("Execute request to "+uri);//For test only;
            try {
                requestBroker.executeRequest(uri);
            } catch (IOException e1) {
                System.out.println("Request Execution failed!!!");
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public ClickListener(RequestBroker requestBroker,String uri){
        this.requestBroker=requestBroker;
        this.uri=uri;
    }
}
