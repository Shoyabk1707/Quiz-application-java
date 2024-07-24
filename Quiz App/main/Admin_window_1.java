import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin_window_1 {

    Admin_window_1(){
    JFrame f = new JFrame();
//        f.setBounds(400,100,500,500);
        f.setSize(1380,770);
        f.setLayout(null);
        f.setResizable(false);



        // ADD QUESTION Panel
        JPanel addq_p = new JPanel();
        addq_p.setBounds(400,10,930,700);
        addq_p.setOpaque(false);
        addq_p.setLayout(null);
        addq_p.setVisible(false);
        f.add(addq_p);

        JLabel add_l = new JLabel("ADD NEW QUESTION");
        add_l.setBounds(305,40,400,40);
        add_l.setFont(new Font("Arial", Font.BOLD,30));
        addq_p.add(add_l);

        JLabel Ques_id = new JLabel("Question ID : ");
        Ques_id.setFont(new Font("Arial", Font.BOLD,20));
        Ques_id.setBounds(100,200,150,20);
        addq_p.add(Ques_id);


        JLabel Ques = new JLabel("Question : ");
        Ques.setFont(new Font("Arial", Font.BOLD,20));
        Ques.setBounds(100,250,150,20);
        addq_p.add(Ques);

        JTextField ques_t = new JTextField();
        ques_t.setFont(new Font("Arial", Font.PLAIN,15));
        ques_t.setBounds(220,245,500,30);
        addq_p.add(ques_t);

        JLabel op1 = new JLabel("Option 1 : ");
        op1.setFont(new Font("Arial", Font.BOLD,20));
        op1.setBounds(100,300,150,20);
        addq_p.add(op1);

        JTextField op1_t = new JTextField();
        op1_t.setBounds(220,295,200,30);
        op1_t.setFont(new Font("Arial", Font.PLAIN,15));
        addq_p.add(op1_t);

        JLabel op2 = new JLabel("Option 2 : ");
        op2.setFont(new Font("Arial", Font.BOLD,20));
        op2.setBounds(100,350,150,20);
        addq_p.add(op2);

        JTextField op2_t = new JTextField();
        op2_t.setBounds(220,345,200,30);
        op2_t.setFont(new Font("Arial", Font.PLAIN,15));
        addq_p.add(op2_t);

        JLabel op3 = new JLabel("Option 3 : ");
        op3.setFont(new Font("Arial", Font.BOLD,20));
        op3.setBounds(100,400,150,20);
        addq_p.add(op3);

        JTextField op3_t = new JTextField();
        op3_t.setBounds(220,395,200,30);
        op3_t.setFont(new Font("Arial", Font.PLAIN,15));
        addq_p.add(op3_t);

        JLabel op4 = new JLabel("Option 4 : ");
        op4.setFont(new Font("Arial", Font.BOLD,20));
        op4.setBounds(100,450,150,20);
        addq_p.add(op4);

        JTextField op4_t = new JTextField();
        op4_t.setBounds(220,445,200,30);
        op4_t.setFont(new Font("Arial", Font.PLAIN,15));
        addq_p.add(op4_t);

        JLabel ans = new JLabel("Answer : ");
        ans.setFont(new Font("Arial", Font.BOLD,20));
        ans.setBounds(100,500,150,20);
        addq_p.add(ans);

//        JLabel aa = new JLabel("Answer : ");
//        aa.setFont(new Font("Arial", Font.BOLD,20));
//        aa.setBounds(100,500,150,20);
//        addq_p.add(aa);

        JTextField ans_t = new JTextField();
        ans_t.setBounds(220,495,200,30);
        ans_t.setFont(new Font("Arial", Font.PLAIN,15));
        addq_p.add(ans_t);

        ImageIcon add_p = new ImageIcon("add.png");
        JButton b_add_q = new JButton(add_p);
        b_add_q.setBounds(220,560,100,30);
        b_add_q.setBorderPainted(false);
        addq_p.add(b_add_q);

        ImageIcon clear_pic = new ImageIcon("clear.png");
        JButton b_clear = new JButton(clear_pic);
        b_clear.setBounds(370,560,100,30);
        b_clear.setBorderPainted(false);
        addq_p.add(b_clear);


        ImageIcon panelbg = new ImageIcon(this.getClass().getResource("pbg.png"));
        JLabel pbg = new JLabel(panelbg);
        pbg.setBounds(0,0,930,700);
        addq_p.add(pbg);


        // Remove question Panel
        JPanel rem_p = new JPanel();
        rem_p.setBounds(400,10,930,700);
        rem_p.setBackground(Color.GRAY);
        rem_p.setOpaque(false);
        rem_p.setLayout(null);
        rem_p.setVisible(false);
        f.add(rem_p);

        JLabel bdl = new JLabel("REMOVE QUESTION");
        bdl.setBounds(305,40,400,40);
        bdl.setFont(new Font("Arial", Font.BOLD,30));
        rem_p.add(bdl);

        JLabel r_Ques_id = new JLabel("Question ID : ");
        r_Ques_id.setFont(new Font("Arial", Font.BOLD,20));
        r_Ques_id.setBounds(100,200,150,20);
        rem_p.add(r_Ques_id);

        JTextField qid_t = new JTextField();
        qid_t.setBounds(250,195,100,30);
        qid_t.setFont(new Font("Arial", Font.BOLD,20));
        qid_t.setFont(new Font("Arial", Font.PLAIN,15));
        rem_p.add(qid_t);

        ImageIcon s_pic = new ImageIcon("search.png");
        JButton search = new JButton(s_pic);
        search.setBounds(370,195,40,30);
        rem_p.add(search);


        JLabel r_Ques = new JLabel("Question : ");
        r_Ques.setFont(new Font("Arial", Font.BOLD,20));
        r_Ques.setBounds(100,250,150,20);
        rem_p.add(r_Ques);

        JLabel r_ques_t = new JLabel();
        r_ques_t.setFont(new Font("Arial", Font.PLAIN,15));
        r_ques_t.setBounds(220,245,500,30);
        rem_p.add(r_ques_t);

        JLabel r_op1 = new JLabel("Option 1 : ");
        r_op1.setFont(new Font("Arial", Font.BOLD,20));
        r_op1.setBounds(100,300,150,20);
        rem_p.add(r_op1);

        JLabel r_op1_t = new JLabel();
        r_op1_t.setBounds(220,295,200,30);
        r_op1_t.setFont(new Font("Arial", Font.PLAIN,15));
        rem_p.add(r_op1_t);

        JLabel r_op2 = new JLabel("Option 2 : ");
        r_op2.setFont(new Font("Arial", Font.BOLD,20));
        r_op2.setBounds(100,350,150,20);
        rem_p.add(r_op2);

        JLabel r_op2_t = new JLabel();
        r_op2_t.setBounds(220,345,200,30);
        r_op2_t.setFont(new Font("Arial", Font.PLAIN,15));
        rem_p.add(r_op2_t);

        JLabel r_op3 = new JLabel("Option 3 : ");
        r_op3.setFont(new Font("Arial", Font.BOLD,20));
        r_op3.setBounds(100,400,150,20);
        rem_p.add(r_op3);

        JLabel r_op3_t = new JLabel();
        r_op3_t.setBounds(220,395,200,30);
        r_op3_t.setFont(new Font("Arial", Font.PLAIN,15));
        rem_p.add(r_op3_t);

        JLabel r_op4 = new JLabel("Option 4 : ");
        r_op4.setFont(new Font("Arial", Font.BOLD,20));
        r_op4.setBounds(100,450,150,20);
        rem_p.add(r_op4);

        JLabel r_op4_t = new JLabel();
        r_op4_t.setBounds(220,445,200,30);
        r_op4_t.setFont(new Font("Arial", Font.PLAIN,15));
        rem_p.add(r_op4_t);

        JLabel r_ans = new JLabel("Answer : ");
        r_ans.setFont(new Font("Arial", Font.BOLD,20));
        r_ans.setBounds(100,500,150,20);
        rem_p.add(r_ans);

        JLabel r_ans_t = new JLabel();
        r_ans_t.setBounds(220,495,200,30);
        r_ans_t.setFont(new Font("Arial", Font.PLAIN,15));
        rem_p.add(r_ans_t);

        ImageIcon rmpic = new ImageIcon("remove.png");
        JButton b_rem_q = new JButton(rmpic);
        b_rem_q.setBounds(220,560,100,30);
        b_rem_q.setBorderPainted(false);
        rem_p.add(b_rem_q);

        ImageIcon panelbg1 = new ImageIcon(this.getClass().getResource("pbg.png"));
        JLabel pbg2 = new JLabel(panelbg1);
        pbg2.setBounds(0,0,930,700);
        rem_p.add(pbg2);


        // Show Panel
        JPanel show_p = new JPanel();
        show_p.setBounds(400,10,930,700);
        show_p.setBackground(Color.GRAY);
        show_p.setOpaque(false);
        show_p.setLayout(null);
        show_p.setVisible(false);
        f.add(show_p);



        JScrollBar s=new JScrollBar();
        s.setBounds(910,0, 20,700);
        show_p.add(s);

//        ImageIcon panelbg2 = new ImageIcon(this.getClass().getResource("pbg.png"));
        JLabel pbg3 = new JLabel(panelbg);
        pbg3.setBounds(0,0,930,700);
        show_p.add(pbg3);


        // Score Panel
        JPanel sp = new JPanel();
        sp.setBounds(400,10,930,700);
        sp.setBackground(Color.GRAY);
        sp.setOpaque(false);
        sp.setLayout(null);
        sp.setVisible(false);
        f.add(sp);

        JLabel scorel = new JLabel("SCORE BOARD");
        scorel.setBounds(340,40,250,40);
        scorel.setFont(new Font("Arial", Font.BOLD,30));
        sp.add(scorel);

//        DefaultTableModel model = new DefaultTableModel();
//        JTable score_table = new JTable();
//        score_table.setModel(model);
//        score_table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        score_table.setFillsViewportHeight(true);
//        score_table.setVisible(true);
//        sp.add(score_table);


//        ImageIcon panelbg3 = new ImageIcon(this.getClass().getResource("pbg.png"));
        JLabel pbg4 = new JLabel(panelbg);
        pbg4.setBounds(0,0,930,700);
        sp.add(pbg4);


        // Admins Panel
        JPanel Ap = new JPanel();
        Ap.setBounds(400,10,930,700);
        Ap.setBackground(Color.GRAY);
        Ap.setOpaque(false);
        Ap.setLayout(null);
        Ap.setVisible(false);
        f.add(Ap);

        JLabel al = new JLabel("ADMINS");
        al.setBounds(415,40,180,40);
        al.setFont(new Font("Arial", Font.BOLD,30));
        Ap.add(al);

//        ImageIcon panelbg2 = new ImageIcon(this.getClass().getResource("pbg.png"));
        JLabel pbg5 = new JLabel(panelbg);
        pbg5.setBounds(0,0,930,700);
        Ap.add(pbg5);



        // Dashboard
        ImageIcon add_pic = new ImageIcon("add_q.png");
        JButton add_q = new JButton(add_pic);
        add_q.setBounds(60,155,200,40);
        add_q.setBackground(Color.WHITE);
        add_q.setBorderPainted(false);
        f.add(add_q);

        ImageIcon rm_pic = new ImageIcon("rem_q.png");
        JButton rem = new JButton(rm_pic);
        rem.setBounds(60,230,200,40);
        rem.setBackground(Color.WHITE);
        rem.setBorderPainted(false);
        f.add(rem);

        ImageIcon show_pic = new ImageIcon("show_q.png");
        JButton show = new JButton(show_pic);
        show.setBounds(60,307,200,40);
        show.setBackground(Color.WHITE);
        show.setBorderPainted(false);
        f.add(show);

        ImageIcon sc = new ImageIcon("score.png");
        JButton score = new JButton(sc);
        score.setBounds(60,385,200,40);
        score.setBackground(Color.WHITE);
        score.setBorderPainted(false);
        f.add(score);

//        label to show score of the student in score frame
        JLabel totalscore= new JLabel();
        totalscore.setBounds(300,300,250,40);
        totalscore.setFont(new Font("Arial", Font.BOLD,25));
        sp.add(totalscore);

        JLabel p_name= new JLabel();
        p_name.setBounds(150,300,100,40);
        p_name.setFont(new Font("Arial", Font.BOLD,25));
        sp.add(p_name);

        JTextField S_textfiel=new JTextField();
        S_textfiel.setBounds(100,100,200,30);
        sp.add(S_textfiel);

        JButton S_search= new JButton("Search");
        S_search.setBounds(300,100,200,30);
        sp.add(S_search);


        ImageIcon home_pic = new ImageIcon("home.png");
        JButton home = new JButton(home_pic);
        home.setBounds(60,465,200,40);
        home.setBackground(Color.WHITE);
        home.setBorderPainted(false);
        f.add(home);

//        f.setVisible(true);


        add_q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rem_p.setVisible(false);
                show_p.setVisible(false);
                addq_p.setVisible(true);
                sp.setVisible(false);
                Ap.setVisible(false);
            }
        });

        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rem_p.setVisible(true);
                show_p.setVisible(false);
                addq_p.setVisible(false);
                sp.setVisible(false);
                Ap.setVisible(false);
            }
        });

//        show.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                show_p.setVisible(true);
//                rem_p.setVisible(false);
//                addq_p.setVisible(false);
//                sp.setVisible(false);
//                Ap.setVisible(false);
//            }
//        });

        score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp.setVisible(true);
                rem_p.setVisible(false);
                show_p.setVisible(false);
                addq_p.setVisible(false);
                Ap.setVisible(false);

            }
        });



        S_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345678");

                    Statement stmt=con.createStatement();

//step4 execute query
                    ResultSet rs=stmt.executeQuery("select * from stu");
                    while (rs.next()){
                        if(S_textfiel.getText().equals(String.valueOf(rs.getInt(1))))
                           totalscore.setText(String.valueOf(rs.getInt(3)));
                           p_name.setText(rs.getString(2));
                    }
                    con.close();
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });


        s.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
                System.out.println(s.getValue());
            }
        });



        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                f.dispose();
            }
        });



        b_add_q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qid=2;
                String A_qus_t=String.valueOf(ques_t.getText());
                String A_opt1_t=String.valueOf(op1_t.getText());
                String A_opt2_t=String.valueOf(op2_t.getText());
                String A_opt3_t=String.valueOf(op3_t.getText());
                String A_opt4_t=String.valueOf(op4_t.getText());
                String A_ans_t=String.valueOf(ans_t.getText());

                try{
//step1 load the driver class
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345678");

                    Statement stmt=con.createStatement();

//step4 execute query
                    ResultSet rs=stmt.executeQuery("select * from question");
                    while(rs.next()){

                        if(rs.isLast()){
                            qid=rs.getInt(1)+1;

                            String query = "insert into question values(" +qid+",'"+A_qus_t+"' , '"+A_opt1_t+"' , '"+A_opt2_t+"' ,'"+A_opt3_t+"' , '"+A_opt4_t+"' , '"+A_ans_t+"')";
                            stmt.executeUpdate(query);
                            System.out.println("added");

                            ques_t.setText("");
                            op1_t.setText(" ");
                            op2_t.setText(" ");
                            op3_t.setText(" ");
                            op4_t.setText(" ");
                            ans_t.setText(" ");

                            }
                    }

                    con.close();

                }catch(Exception e1){ System.out.println(e1);}


            }
        });



        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int S_qid=Integer.parseInt(qid_t.getText());
                try{

                    Class.forName("com.mysql.cj.jdbc.Driver");


                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345678");


                    Statement stmt=con.createStatement();

                    ResultSet rs=stmt.executeQuery("select * from question");
                    while(rs.next()){

                        if(S_qid==rs.getInt(1)) {
                            r_ques_t.setText(rs.getString(2));
                            r_op1_t.setText(rs.getString(3));
                            r_op2_t.setText(rs.getString(4));
                            r_op3_t.setText(rs.getString(5));
                            r_op4_t.setText(rs.getString(6));
                            r_ans_t.setText(rs.getString(7));
                        }

                    }
                    con.close();

                }catch(Exception e2){ System.out.println(e2);}


            }

        });


        b_rem_q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int S_qid=Integer.parseInt(qid_t.getText());

                try{
//step1 load the driver class
                    Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345678");

//step3 create the statement object
                    Statement stmt=con.createStatement();

//step4 execute query
                    ResultSet rs=stmt.executeQuery("select * from question");
                    while(rs.next()){

                        if(S_qid==rs.getInt(1)) {
                            String query = "delete from question where Qid="+S_qid;
                            stmt.executeUpdate(query);
                            System.out.println("Removed");


                            qid_t.setText("");
                            r_ques_t.setText("");
                            r_op1_t.setText(" ");
                            r_op2_t.setText(" ");
                            r_op3_t.setText(" ");
                            r_op4_t.setText(" ");
                            r_ans_t.setText(" ");

                        }

                    }
                    con.close();

                }catch(Exception e2){ System.out.println(e2);}

            }
        });



        b_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ques_t.setText("");
                op1_t.setText(" ");
                op2_t.setText(" ");
                op3_t.setText(" ");
                op4_t.setText(" ");
                ans_t.setText(" ");
            }
        });




        ImageIcon bg = new ImageIcon(this.getClass().getResource("Admin_d.jpg"));
        JLabel bck = new JLabel(bg);
        bck.setSize(1370,740);
        f.add(bck);

        f.setVisible(true);

}

public static void main(String[] args){
        Admin_window_1 a = new Admin_window_1();
    }
}
