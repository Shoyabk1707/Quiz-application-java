import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JAVA {
    JAVA() {
        JFrame f = new JFrame();
//        f.setBounds(400, 100, 500, 500);
        f.setSize(1380,740);
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);

        JLabel j = new JLabel("JAVA");
        j.setBounds(200,50,120,30);
        j.setFont(new Font("Arial", Font.BOLD,30));
        f.add(j);



    }
    public static void main(String[] args){
        JAVA s=new JAVA();
    }

}
