package com.adarsh;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Stopwatch extends JFrame implements ActionListener{

//    private JLabel heading=new JLabel("LUCKY CHAT SEVER");
    JFrame frame = new JFrame();
    Font font = new Font("Roboto",Font.BOLD,20);
    JLabel img = new JLabel("Img");

    JLabel heading = new JLabel("HEADING");
    JLabel h = new JLabel("Heading2");
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds =0;
    int minutes =0;
    int hours =0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime=elapsedTime+1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

        }

    });


    Stopwatch(){
        JFrame f1 = new JFrame();
//        this.setTitle("Server Lucky Chat");
//        this.setSize(550,620);
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heading.setFont(font);
//        messaageArea.setFont(font);
//        messageIP.setFont(font);

        img.setBounds(10,0,325,70);
//        heading.setFont(new Font("san serif",Font.PLAIN,30));
//        heading.setBackground(Color.cyan);
//        img.setBorder(BorderFactory.createBevelBorder(5));
//        img.setOpaque(true);
        img.setHorizontalAlignment(img.CENTER);
        img.setIcon(new ImageIcon("C:\\Users\\Lucky\\Desktop\\JAVA\\own\\src\\com\\adarsh\\2.png"));
        img.setHorizontalTextPosition(SwingConstants.CENTER);
        img.setVerticalTextPosition(SwingConstants.BOTTOM);
        img.setHorizontalAlignment(SwingConstants.CENTER);
        img.setBorder(BorderFactory.createEmptyBorder(30,20,30,30));

        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeLabel.setBounds(100,200,200,100);
        timeLabel.setFont(new Font("san serif",Font.PLAIN,35));
        timeLabel.setBackground(Color.cyan);
        timeLabel.setBorder(BorderFactory.createBevelBorder(5));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        heading.setText("Code Clause Stop Watch");

        heading.setBounds(25,70,350,50);
        heading.setFont(new Font("san serif",Font.BOLD,25));
//        heading.setBackground(Color.lightGray);
        heading.setForeground(Color.blue);
        heading.setBorder(BorderFactory.createBevelBorder(5));
        heading.setOpaque(false);
        heading.setHorizontalAlignment(JTextField.CENTER);

        h.setText("Stop Watch");

        h.setBounds(25,200,350,50);
        h.setFont(new Font("san serif",Font.BOLD,25));
        h.setBackground(Color.red);
        h.setForeground(Color.red);
        h.setBorder(BorderFactory.createBevelBorder(5));
        h.setOpaque(false);
        h.setHorizontalAlignment(h.CENTER);

        startButton.setBounds(100,300,100,50);
        startButton.setFont(new Font("poppins",Font.PLAIN,15));
        startButton.setBackground(Color.red);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200,300,100,50);
        resetButton.setFont(new Font("san serif",Font.BOLD,15));
        resetButton.setBackground(Color.blue);
        resetButton.setForeground(new Color(255,192,0));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setHorizontalAlignment(JTextField.CENTER);
        frame.getContentPane().add(img);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(heading);
        frame.add(timeLabel);
        frame.setTitle("Stop Watch");
        frame.setBackground(Color.GREEN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,450);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==startButton) {

            if(started==false) {
                started=true;
                startButton.setText("STOP");
                start();
            }
            else {
                started=false;
                startButton.setText("START");
                stop();
            }

        }
        if(e.getSource()==resetButton) {
            started=false;
            startButton.setText("START");
            reset();
        }

    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime=0;
        seconds =0;
        minutes=0;
        hours=0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);       timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }

}

