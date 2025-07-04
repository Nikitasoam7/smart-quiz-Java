//programe to decide the role user
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Role implements ActionListener
{
JFrame f;
JLabel l1,l2;
JButton b1,b2;
Login l;
TeacherLogin tl;
Role()
{
f=new JFrame("Quize Test");
f.setSize(1300,600);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

ImageIcon i=new ImageIcon("quiz.jpg");
l1=new JLabel(i);
l1.setBounds(0,0,600,600);
f.add(l1);

l2=new JLabel("CHOOSE YOUR ROLE");
l2.setBounds(720,80,600,100);
l2.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,50));
f.add(l2);


b1=new JButton(new ImageIcon("teacher.jpg"));
b1.setBounds(700,250,200,100);
f.add(b1);

b2=new JButton(new ImageIcon("student.jpg"));
b2.setBounds(1000,250,200,100);
f.add(b2);

f.setBackground(new Color(255,255,255));
b1.addActionListener(this);
b2.addActionListener(this);

f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
f.setVisible(false);
tl=new TeacherLogin();
}
else if(ae.getSource()==b2){
f.setVisible(false);
l=new Login();}
}
public static void main(String... ag)
{
Role r=new Role();
}
}