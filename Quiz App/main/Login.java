import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 class varible{
    static int roll;
}
public class Login{

    Login(){

        // Login Frame
        JFrame f = new JFrame();
//        f.setBounds(500,100,365,539);
        f.setLayout(null);
        f.setBounds(0,0,1380,770);
//        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Login as Admin

        JPanel lp = new JPanel();
        lp.setBounds(750,200,450,400);
        lp.setBackground(Color.WHITE);
//        lp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lp.setLayout(null);
        lp.setVisible(false);
        f.add(lp);

        JLabel lasa = new JLabel("Login as Admin");
        lasa.setBounds(130,20,180,30);
        lasa.setFont(new Font("Arial", Font.BOLD,20));
        lp.add(lasa);

        JLabel user = new JLabel("Username");
        user.setForeground(Color.GRAY);
        user.setFont(new Font("Arial", Font.BOLD,20));
        user.setBounds(50,100,100,30);
        lp.add(user);

        JTextField usert = new JTextField();
        usert.setFont(new Font("Arial", Font.PLAIN,18));
        usert.setBounds(170,100,160,30);
        lp.add(usert);

        JLabel pass = new JLabel("Password");
        pass.setForeground(Color.GRAY);
        pass.setFont(new Font("Arial", Font.BOLD,20));
        pass.setBounds(50,160,100,30);
        lp.add(pass);

        JPasswordField passt = new JPasswordField();
        passt.setFont(new Font("Arial", Font.PLAIN,18));
        passt.setEchoChar('*');
        passt.setBounds(170,160,160,30);
        lp.add(passt);

        ImageIcon log = new ImageIcon("login.png");
        JButton login = new JButton(log);
        login.setBounds(140,250,160,40);
        login.setBackground(Color.WHITE);
        login.setBorderPainted(false);
        lp.add(login);

        ImageIcon laspic= new ImageIcon("las.png");
        JButton las = new JButton(laspic);
        las.setBounds(105,320,220,40);
        las.setBackground(Color.WHITE);
        las.setBorderPainted(false);
        lp.add(las);

        ImageIcon showpng = new ImageIcon("show.png");
        ImageIcon hidepng = new ImageIcon("hide.png");
        JButton show = new JButton(hidepng);
        show.setBounds(350,162,30,25);
        show.setBorderPainted(false);
//        show.setVisible(false);
        lp.add(show);


        JButton hide = new JButton(showpng);
        hide.setBounds(350,162,30,25);
        hide.setOpaque(false);
        hide.setVisible(true);
        hide.setBorderPainted(false);
        lp.add(hide);




        // Login as Student

        JPanel p1 = new JPanel();
        p1.setBounds(750,200,450,400);
        p1.setBackground(Color.WHITE);
        p1.setVisible(true);
        p1.setLayout(null);
        f.add(p1);

        JLabel lasl = new JLabel("Login as Student");
        lasl.setBounds(130,20,180,30);
        lasl.setFont(new Font("Arial", Font.BOLD,20));
        p1.add(lasl);


        JLabel name = new JLabel("Enter Name");
        name.setBounds(50,100,120,30);
        name.setForeground(Color.GRAY);
        name.setFont(new Font("Arial", Font.PLAIN,20));
        p1.add(name);

        JTextField namet = new JTextField();
        namet.setFont(new Font("", Font.PLAIN,15));
        namet.setBounds(170,100,200,30);
        p1.add(namet);

        JLabel roll = new JLabel("Enter Roll no");
        roll.setBounds(50,160,120,30);
        roll.setForeground(Color.GRAY);
        roll.setFont(new Font("Arial", Font.PLAIN,20));
        p1.add(roll);

        JTextField rollt = new JTextField();
        rollt.setBounds(170,160,200,30);
        rollt.setFont(new Font("", Font.PLAIN,15));
        p1.add(rollt);

        ImageIcon st = new ImageIcon("start.png");
        JButton start = new JButton(st);
        start.setBounds(140,250,160,40);
        start.setBackground(Color.WHITE);
        start.setBorderPainted(false);
        p1.add(start);

        ImageIcon laapic = new ImageIcon("laa.png");
        JButton laa = new JButton(laapic);
        laa.setBounds(105,320,220,40);
        laa.setBackground(Color.WHITE);
        laa.setBorderPainted(false);
        p1.add(laa);



        // Action Listeners

        laa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                lp.setVisible(true);
            }
        });

        las.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lp.setVisible(false);
                p1.setVisible(true);
            }
        });



        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String un = usert.getText();
                String pa = String.valueOf(passt.getPassword());

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345678");

                    Statement stmt=con.createStatement();

//step4 execute query
                    ResultSet rs=stmt.executeQuery("select * from admin");
                    while(rs.next()){

                        if(un.equals(rs.getString(1)) && pa.equals(rs.getString(2))) {
                            System.out.println("login sucessful");
                            Admin_window_1 s=new Admin_window_1();
                        }
                        else if (rs.isLast()){
                            JOptionPane.showMessageDialog(f,"Wrong username or password");

                        }

                    }
//step5 close the connection object
                    con.close();

                }catch(Exception e2){ System.out.println(e2);}

            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String un = namet.getText();
                String pa = String.valueOf(rollt.getText());
                varible rol=new varible();
                rol.roll=Integer.parseInt(rollt.getText());

                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345678");

                    Statement stmt=con.createStatement();

                    ResultSet rs = stmt.executeQuery("select * from stu");
                    while (rs.next()) {

                        if (un.equals(String.valueOf(rs.getInt(1))) && pa.equals(rs.getString(2))) {
                            System.out.println("login sucessful");
                            Start_window s = new Start_window();
                        } else if (rs.isLast()) {
                            // New Student List
                            String query = "insert into stu(roll,name) values("+rollt.getText()+",'"+namet.getText()+"')";
                            stmt.executeUpdate(query);
                            System.out.println("added");
                            Start_window s = new Start_window();
                        }
                    }
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }


            }
        });


        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passt.setEchoChar((char)0);
                show.setVisible(false);
                hide.setVisible(true);
            }
        });

        hide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passt.setEchoChar('*');
                show.setVisible(true);
                hide.setVisible(false);
            }
        });



        // Background
        ImageIcon bg = new ImageIcon(this.getClass().getResource("loginbg.jpg"));
        JLabel bgl = new JLabel(bg);
        bgl.setBounds(0,0,1380,740);
        f.add(bgl);

        f.setVisible(true);

    }

    
public static void main(String[] args){
    Login l = new Login();

    }
}
