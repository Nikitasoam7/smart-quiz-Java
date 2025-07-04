//program to Login and start quiz test for student
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login implements ActionListener
{
JFrame f;
JButton b1,b2;
JLabel l1,l2,l3;
ImageIcon i;
JTextField t;
Role r;
Rules ru;
Login()
{
f=new JFrame("Student");
f.setSize(900,500);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setResizable(false);

i=new ImageIcon("quiz.jpg");
l1=new JLabel(i);
l1.setBounds(0,0,450,500);
f.add(l1);

l2=new JLabel("SIMPLE MINDS");
l2.setBounds(540,80,350,50);
f.add(l2);

l2.setFont(new Font("times new roman",Font.BOLD|Font.ITALIC,40));
l3=new JLabel("Enter your name");
l3.setBounds(560,180,250,30);
f.add(l3);
l3.setFont(new Font("times new roman",Font.BOLD,30));
l3.setForeground(Color.BLACK);

b1=new JButton("Ok");
b1.setBounds(550,300,100,30);
b1.setFont(new Font("times new roman",Font.BOLD,20));
f.add(b1);

b2=new JButton("Back");
b2.setBounds(700,300,100,30);
b2.setFont(new Font("times new roman",Font.BOLD,20));
f.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
t=new JTextField();
t.setBounds(550,250,250,30);
t.setFont(new Font("times new roman",Font.BOLD,20));
f.add(t);
	t.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (t.getText().length() >= 30) {
                    e.consume(); // If length is greater than or equal to 10, ignore further input
                }
            }
        });

t.requestFocus();
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
if(t.getText().trim().equals(""))
{
JOptionPane.showMessageDialog(null,"Enter your name");}
else
{
String name=t.getText();
ru=new Rules(name);
f.setVisible(false);
}
}
else if(ae.getSource()==b2)
{
f.setVisible(false);
r=new Role();
}
}
}