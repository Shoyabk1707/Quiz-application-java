import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Arrays;

import static com.mysql.cj.conf.PropertyKey.logger;

public class Start_window{
    int i,a;
    int score=0,total=0;
    Start_window(){



        JFrame f = new JFrame("start");
        f.setSize(1380,770);
        f.setLayout(null);
        f.setResizable(false);

        ActionListener tp = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("hello");
            }
        };

        Timer timer = new Timer(100,tp);
        timer.setRepeats(false);
        timer.start();






        JPanel start_p = new JPanel();
        start_p.setBounds(50,50,1280,640);
//        start_p.setOpaque(false);
        start_p.setLayout(null);
        start_p.setVisible(true);
        f.add(start_p);



        // Exit Scrren
        JPanel exit_page = new JPanel();
        exit_page.setBounds(50,50,1280,640);
//        exit_page.setOpaque(false);
        exit_page.setLayout(null);
        exit_page.setVisible(false);
        f.add(exit_page);

        JLabel ty = new JLabel("Thanks for playing");
        ty.setBounds(400,150,600,80);
        ty.setFont(new Font("Arial", Font.BOLD,50));
        exit_page.add(ty);

        JButton restart = new JButton("Restart");
        restart.setBounds(590,290,100,30);
        exit_page.add(restart);

        JButton exit = new JButton("Exit");
        exit.setBounds(590,340,100,30);
        exit_page.add(exit);




        //Next Button
        ImageIcon n_pic = new ImageIcon("next.png");
        JButton next = new JButton(n_pic);
        next.setBounds(1160,590,100,30);
        next.setBorderPainted(false);
        f.add(next);


        // Back Button
        ImageIcon back_pic = new ImageIcon("back.png");
        JButton back = new JButton(back_pic);
        back.setBounds(80,590,100,30);
        back.setBorderPainted(false);
        f.add(back);


        // Submit Button
        ImageIcon sub_pic = new ImageIcon("submit.png");
        JButton submit = new JButton(sub_pic);
        submit.setBounds(560,590,100,30);
        submit.setBorderPainted(false);
        f.add(submit);


        // start button
        ImageIcon st = new ImageIcon("start.png");
        JButton start = new JButton(st);
        start.setBounds(550,300,160,40);
        start.setBackground(Color.WHITE);
        start.setBorderPainted(false);
        start_p.add(start);



        JLabel S_no = new JLabel();
        S_no.setBounds(100,200,40,30);
        S_no.setFont(new Font("Arial", Font.BOLD,25));
        f.add(S_no);

        JLabel question = new JLabel();
        question.setBounds(150,200,900,30);
        question.setFont(new Font("Arial", Font.BOLD,30));
        f.add(question);


//        JLabel option1 = new JLabel();

        JRadioButton option1 = new JRadioButton();
        option1.setBounds(100,350,300,30);
        option1.setFont(new Font("Arial", Font.BOLD,20));
        option1.setOpaque(false);
        f.add(option1);

        JRadioButton option2 = new JRadioButton();
        option2.setBounds(500,350,300,30);
        option2.setFont(new Font("Arial", Font.BOLD,20));
        option2.setOpaque(false);
        f.add(option2);

        JRadioButton option3 = new JRadioButton();
        option3.setBounds(100,500,300,30);
        option3.setFont(new Font("Arial", Font.BOLD,20));
        option3.setOpaque(false);
        f.add(option3);

        JRadioButton option4 = new JRadioButton();
        option4.setBounds(500,500,400,30);
        option4.setFont(new Font("Arial", Font.BOLD,20));
        option4.setOpaque(false);
        f.add(option4);


        // Action Listener

        ImageIcon bg = new ImageIcon("startbg2.jpg");
        JLabel bck = new JLabel(bg);
        bck.setSize(1380,740);
        f.add(bck);

        f.setVisible(true);

        start.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent actionEvent) {
                start_p.setVisible(false);

                try {
//step1 load the driver class
                    Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");

//step3 create the statement object
                    Statement stmt = con.createStatement();

                        ResultSet rs1 = stmt.executeQuery("select * from question where Qid="+1);
                        String[] q_n = new String[10];
                        while (rs1.next()) {



                            S_no.setText(String.valueOf(rs1.getInt(1))+")");
                            question.setText(rs1.getString(2));
                            option1.setText(rs1.getString(3));
                            option2.setText(rs1.getString(4));
                            option3.setText(rs1.getString(5));
                            option4.setText(rs1.getString(6));

                            System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + "\n" + rs1.getString(3) + "\n" + rs1.getString(4) + "\n" + rs1.getString(5) + "\n" + rs1.getString(6));
                        }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        });
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(option1.isSelected()){
                    try {
//step1 load the driver class
                        Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");

//step3 create the statement object
                        Statement stmt = con.createStatement();
                        ResultSet rs5=stmt.executeQuery("select * from question where Qid="+i);
                        while (rs5.next()){
                            if(rs5.getString(7).equals(option1.getText())){
                                System.out.println("correct answer");
                                score=score+1;
                            }
                        }
                    }catch (Exception k){
                        k.printStackTrace();
                    }
                }
            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(option2.isSelected()){
                    try {
//step1 load the driver class
                        Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");

//step3 create the statement object
                        Statement stmt = con.createStatement();
                        ResultSet rs5=stmt.executeQuery("select * from question where Qid="+i);
                        while (rs5.next()){
                            if(rs5.getString(7).equals(option2.getText())){
                                System.out.println("correct answer");
                                score=score+1;
                            }
                        }
                    }catch (Exception k){
                        k.printStackTrace();
                    }
                }
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(option3.isSelected()){
                    try {
//step1 load the driver class
                        Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");

//step3 create the statement object
                        Statement stmt = con.createStatement();
                        ResultSet rs6=stmt.executeQuery("select * from question where Qid="+i);
                        while (rs6.next()){
                            if(rs6.getString(7).equals(option3.getText())){
                                System.out.println("correct answer");
                                score=score+1;
                            }
                        }
                    }catch (Exception k){
                        k.printStackTrace();
                    }
                }
            }
        });
        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(option4.isSelected()){
                    try {
//step1 load the driver class
                        Class.forName("com.mysql.cj.jdbc.Driver");
//step2 create  the connection object
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");
//step3 create the statement object
                        Statement stmt = con.createStatement();
                        ResultSet rs5=stmt.executeQuery("select * from question where Qid="+i);
                        while (rs5.next()){
                            if(rs5.getString(7).equals(option4.getText())){

                                System.out.println("correct answer");
                                score=score+1;
                            }
                        }
                    }catch (Exception k){
                        k.printStackTrace();
                    }
                }
            }
        });

        next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                i++;

                try {
//step1 load the driver class
                    Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");

//step3 create the statement object
                    Statement stmt = con.createStatement();

                        ResultSet rs1 = stmt.executeQuery("select * from question where Qid="+i);
                        while (rs1.next()) {
                            a=rs1.getInt(1);
                            option1.setSelected(false);
                            option2.setSelected(false);
                            option3.setSelected(false);
                            option4.setSelected(false);

                            S_no.setText(String.valueOf(rs1.getInt(1))+")");
                            question.setText(rs1.getString(2));
                            option1.setText(rs1.getString(3));
                            option2.setText(rs1.getString(4));
                            option3.setText(rs1.getString(5));
                            option4.setText(rs1.getString(6));

//                            if(rs1.isLast()){
//                                next.setVisible(false);
//                                submit.setVisible(true);
//                            }
                        }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int k=a--;
                try {
//step1 load the driver class
                    Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");

//step3 create the statement object
                    Statement stmt = con.createStatement();


                        ResultSet rs3 = stmt.executeQuery("select * from question where Qid=" +k);
                        while (rs3.next()) {
                            i=rs3.getInt(1);
                            option1.setSelected(false);
                            option2.setSelected(false);
                            option3.setSelected(false);
                            option4.setSelected(false);


                            S_no.setText(String.valueOf(rs3.getInt(1)) + ")");
                            question.setText(rs3.getString(2));
                            option1.setText(rs3.getString(3));
                            option2.setText(rs3.getString(4));
                            option3.setText(rs3.getString(5));
                            option4.setText(rs3.getString(6));

                        }

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varible obj=new varible();


                try {
//step1 load the driver class
                    Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345678");

//step3 create the statement object
                    Statement stmt = con.createStatement();


                    String query= "update stu set score="+score+" where roll="+obj.roll;
                    stmt.executeUpdate(query);

                    ResultSet Tot=stmt.executeQuery("select * from stu where roll="+obj.roll);

                    while (Tot.next()){
                        total=Tot.getInt(3);
                    }

                }catch (Exception l){
                    l.printStackTrace();
                }

                JOptionPane.showMessageDialog(f,"Your Score is  : "+total);

                submit.setVisible(false);
                next.setVisible(false);
                back.setVisible(false);
               exit_page.setVisible(true);
            }
        });

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Start_window s=new Start_window();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(10);
            }
        });
    }
    public static void main(String[] args){

        Start_window s=new Start_window();

    }
}

