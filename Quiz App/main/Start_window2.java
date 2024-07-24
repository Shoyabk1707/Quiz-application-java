import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start_window2{
    Start_window2(){

        JFrame f = new JFrame("start");
        f.setSize(1380,770);
        f.setLayout(null);
        f.setResizable(false);



        ImageIcon j = new ImageIcon("java.png");
        JButton java = new JButton(j);
        java.setBounds(400,400,120,150);
        java.setBackground(Color.WHITE);
        java.setBorderPainted(false);
        f.add(java);

        ImageIcon b = new ImageIcon("bigdata.png");
        JButton bd = new JButton(b);
        bd.setBounds(600,400,120,150);
        bd.setBackground(Color.WHITE);
        bd.setBorderPainted(false);
        f.add(bd);

        ImageIcon d = new ImageIcon("daa.png");
        JButton daa = new JButton(d);
        daa.setBounds(800,400,120,150);
        daa.setBackground(Color.WHITE);
        daa.setBorderPainted(false);
        f.add(daa);




        // Action Listener
        java.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JAVA j = new JAVA();
            }
        });

        bd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BD j = new BD();
            }
        });

        daa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAA j = new DAA();
            }
        });



        ImageIcon bg = new ImageIcon("startbg2.jpg");
        JLabel bck = new JLabel(bg);
        bck.setSize(1380,740);
        f.add(bck);

        f.setVisible(true);

    }
    public static void main(String[] args){

        Start_window2 s=new Start_window2();
    }
}

