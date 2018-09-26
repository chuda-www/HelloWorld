package com.my.exercises;

import javax.swing.*;

public class WindowButton extends JButton {
    public static void main(String[] args) {
        //Создайте экземпляр класса Window
        Window gui = new Window();

    }

    //Cоздаем контейнер JPanel
    JPanel pnl = new JPanel();
    //создаем два объекта изображений ImageIcon
    /*ImageIcon tick = new ImageIcon( "tick.png" ) ;
    ImageIcon cross = new ImageIcon( "cross.png" ) ;*/
    //создаем 3 объекта JButton:1-будет отображаться текст,
    //2—изображение,3—и текст,и изображение.
    JButton btn = new JButton("Нажми меня");
    //создаем объект ClassLoader
    ClassLoader ldr = this.getClass().getClassLoader();
    //Загружаем адреса ресурсов (файлов изображений)
    java.net.URL tickURL = ldr.getResource("tick.png");
    java.net.URL crossURL = ldr.getResource("cross.png");
    ImageIcon tick = new ImageIcon(tickURL);
    ImageIcon cross = new ImageIcon(crossURL);
    JButton tickBtn = new JButton(tick);
    JButton crossBtn = new JButton("СТОП", cross);

    public WindowButton() {
        super("Окно Swing");
        add(pnl);
        setSize(500, 200);
        pnl.add(btn);
        pnl.add(tickBtn);
        pnl.add(crossBtn);
        setVisible(true);
    }
}

