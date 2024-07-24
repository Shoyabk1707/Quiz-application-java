import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BD {
    BD() {
        JFrame f = new JFrame();
//        f.setBounds(400, 100, 500, 500);
        f.setSize(1380,770);
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);

        JLabel j = new JLabel("BIG DATA");
        j.setBounds(180,50,180,30);
        j.setFont(new Font("Arial", Font.BOLD,30));
        f.add(j);


    }
    public static void main(String[] args){
        BD s= new BD();
    }
}
