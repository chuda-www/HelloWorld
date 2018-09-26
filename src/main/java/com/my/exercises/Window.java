package com.my.exercises;

import javax.swing.*;

class Window extends JFrame {
     public static void main(String[] args) {
         //Создайте экземпляр класса Window
        Window gui = new Window();
    }
    //Cоздаем контейнер JPanel
    JPanel pnl = new JPanel();
    public Window() {
        //метод присвает заголовок окна super()
        super("Окно Swing");
        //размер окна — указывается значение ширины,высоты в пикселях
        setSize(500, 200);
        //действие при закрытии пользователем окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*В данном примере значение EXIT_ON_CLOSE это константа,
        являющаяся членом класса JFrame.Она производит выход из программы при закрытии окна.*/
        //компонент окна —контейнер JPanel,к которому будут добавляться более
        // мелкие компоненты при использовании наследуемого метода add()
        add(pnl);
        //параметр отображения окна
        setVisible(true);
    }}