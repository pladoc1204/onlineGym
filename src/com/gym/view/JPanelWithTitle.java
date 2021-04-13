package com.gym.view;

import javax.swing.*;

public class JPanelWithTitle {
    private JPanel panel;
    private String title;

    public JPanelWithTitle(JPanel panel,String title){
        this.panel=panel;
        this.title=title;
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getTitle() {
        return title;
    }
}
