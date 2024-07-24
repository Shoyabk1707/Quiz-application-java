import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lo {
    lo(){

        JFrame f = new JFrame();
        f.setBounds(400,150,400,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame f1 = new JFrame();
        f1.setBounds(400,150,300,300);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel user = new JLabel("Username");
        user.setBounds(100,100,100,20);
        f.add(user);

        JLabel pass = new JLabel("Password");
        pass.setBounds(100,150,100,20);
        f.add(pass);

        JTextField usert = new JTextField();
        usert.setBounds(200,100,100,20);
        f.add(usert);

        JPasswordField passt = new JPasswordField();
        passt.setBounds(200,150,100,20);
        f.add(passt);

        JButton login = new JButton("Login");
        login.setBounds(150,200,80,20);
        f.add(login);


        f.setVisible(true);



        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usert.setText("Hello Aditya");

                         }
        });

    }

    public static void main(String[] main){
        lo l = new lo();
    }

}
