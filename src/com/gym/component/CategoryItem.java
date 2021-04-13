package com.gym.component;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CategoryItem {
    private JPanel body;
    private JLabel image;
    private JPanel imageContainer;
    private JPanel textContainer;
    private JLabel cateName;
    private JLabel videoCounts;
    private JLabel counts;
    private JPanel title;
    private JPanel attr;



    public CategoryItem(String Image_src,String cateTitle,int width,int height, MouseListener listener){
        this.imageContainer.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setCateTitle(cateTitle);
        this.setImage(Image_src,width,height);
        attr.remove(0);
        body.addMouseListener(listener);
        body.setPreferredSize(new Dimension(470,-1));
    }

    public CategoryItem(String Image_src,String cateTitle, int n, MouseListener listener){
        this(Image_src,cateTitle,100,100,listener);
    }

    public void setImage(String src,int width,int height) {
        boolean isSettled =false;
        try{
            File raw_image = new File(src);
            BufferedImage read = ImageIO.read(raw_image);
            Image img=read.getScaledInstance(width,height,Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            image.setIcon(icon);
            image.updateUI();
            isSettled=true;
        }catch (IOException e){
            System.out.println("cannot load image from "+src);
            image.updateUI();
        }
        if(isSettled==false){
            try{
                File raw_image = new File("src/icon/default.jpg");
                BufferedImage read = ImageIO.read(raw_image);
                Image img=read.getScaledInstance(width,height,Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                image.setIcon(icon);
                image.updateUI();
                isSettled=true;
        } catch (IOException e) {
                System.out.println("cannot load the default image!!!");
            }
        }
    }

    public void setImage(String src) {
        this.setImage(src,100,100);
    }

    public void setCateTitle(String cateTitle){
        cateName.setText(cateTitle);
    }

    public void setVideoCounts(int n){
        videoCounts.setText(""+n);
    }

    public JPanel getMainComp(){
        return body;
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame("categoryItemBuildTest");
        CategoryItem mainFrame = new CategoryItem("D:\\workplace\\onlineGym\\src\\icon\\default.jpg", "humorous", 10,
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("I am clicked!");
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
                });
        frame.setContentPane(mainFrame.body);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
