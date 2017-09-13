package com.fzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fuzhongyu on 2017/9/12.
 */
public class Boundary extends JFrame{

    public static void main(String[] args) {

        //初始化一个jframe
        final JFrame frame = new JFrame("测试  author: fzy");

        //设置关闭方式
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //设置字体
        JLabel textLable = new JLabel();
        Font font=new Font("宋体",Font.BOLD,36);

        //初始化文本panel
        JPanel panel_tx= new JPanel();
        //初始化一个jlable
        textLable.setFont(font);
        textLable.setText("<html>fzy<br/></html>");
        //把文字添加到pannel
        panel_tx.add(textLable);

        //初始化时间计时panel
        JPanel panel_time=new JPanel();
        //设置倒计时时间
        final JLabel timeLable = new JLabel("10秒");
        timeLable.setFont(font);
        final Timer timer=new Timer(1000, new ActionListener() {
            int second=10;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("--->"+second);
                if (second>0){
                    timeLable.setForeground(Color.red);
                    second=second-1;
                }else {
//                   new ShutDownTool().shutDowns(1);
                    System.out.println("关闭");
                }
                timeLable.setText(second+"秒");
            }
        });
        timer.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        panel_time.add(timeLable);


        //初始化选择panel
        JPanel panel_choose= new JPanel();
        final JRadioButton yesBtn = new JRadioButton("是");
        final JRadioButton noBtn = new JRadioButton("否");
        ButtonGroup group = new ButtonGroup();
        group.add(yesBtn);
        group.add(noBtn);
        panel_choose.add(yesBtn);
        panel_choose.add(noBtn);

        //初始化时间计时panel
        JPanel panel_btn=new JPanel();
        JButton button=new JButton("确定");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(yesBtn.isSelected()){
                   timer.stop();
                   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }else if (noBtn.isSelected()){
//                    new ShutDownTool().shutDowns(1);
                    System.out.println("---》关闭");
                }
            }
        });

        panel_btn.add(button);




        //初始化一个容器
        Container container = frame.getContentPane();

        //设置布局
        container.setLayout(new GridLayout(4,1));

        //把panel添加到容器
        container.add(panel_tx);
        container.add(panel_time);
        container.add(panel_choose);
        container.add(panel_btn);

        //设置大小
        frame.setSize(600,500);

        //设置位置
        int winWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int winHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        frame.setLocation((winWidth-600)/2,(winHeight-500)/2);

        //设置可见性
        frame.setVisible(true);


    }


}
