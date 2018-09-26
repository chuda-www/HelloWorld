package com.my.exercises;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TimerClass {


// Имя этого класса указано полностью для разрешения
// конфликта имен с классом java.util.Timer

    public static void main(String[] args)    {
        ActionListener listener = new TimePrinter();
// построить таймер, вызывающий приемник событий
// каждые 10 секунд
        Timer t = new Timer(10000, listener);
        t .start();
        JOptionPane.showMessageDialog(null, "Quitp rogram?");
        System.exit(0);

    }
}
class TimePrinter implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}