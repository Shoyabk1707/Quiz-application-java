import javax.swing.*;
class ex
{
   ex(){
      JFrame f= new JFrame("Scrollbar Example");
      JScrollBar s=new JScrollBar();
      s.setBounds(365,0, 20,365);
      f.add(s);
      f.setSize(400,400);
      f.setLayout(null);
      f.setVisible(true);
   }
   public static void main(String args[])
   {
      new ex();
   }}