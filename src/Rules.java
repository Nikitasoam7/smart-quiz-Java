//program to show rules of the test to the student
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Rules implements ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JButton b1,b2;
Login l;
String namee;
StudentQuizFrame s;
Rules(String name)
{
f=new JFrame("RULES");
f.setSize(900,700);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setResizable(false);
namee=name;

l1=new JLabel("Welcome Tom to Simple Minds");
l1.setBounds(100,30,700,50);
l1.setForeground(Color.BLUE);
l1.setFont(new Font("times new roman",Font.BOLD|Font.ITALIC,40));
f.add(l1);

l2=new JLabel("1. You are trained to be a programmer and not a story teller, answer point to point");
l2.setBounds(50,120,900,20);
l2.setFont(new Font("times new roman",Font.PLAIN,20));
f.add(l2);
l3=new JLabel("2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer");
l3.setBounds(50,170,900,20);
l3.setFont(new Font("times new roman",Font.PLAIN,20));
f.add(l3);
l4=new JLabel("3. You may have lot of options in life but here all the questions are compulsory");
l4.setBounds(50,220,900,20);
l4.setFont(new Font("times new roman",Font.PLAIN,20));
f.add(l4);
l5=new JLabel("4. Crying is allowed but please do so quietly.");
l5.setBounds(50,270,900,20);
l5.setFont(new Font("times new roman",Font.PLAIN,20));
f.add(l5);
l6=new JLabel("5. Only a fool asks and a wise answers (Be wise, not otherwise)");
l6.setBounds(50,320,900,20);
l6.setFont(new Font("times new roman",Font.PLAIN,20));
f.add(l6);
l7=new JLabel("6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di.");
l7.setBounds(50,370,900,20);
l7.setFont(new Font("times new roman",Font.PLAIN,20));
f.add(l7);
l8=new JLabel("7. Brace yourself, this paper is not for the faint hearted");
l8.setBounds(50,420,900,20);
l8.setFont(new Font("times new roman",Font.PLAIN,20));
f.add(l8);
l9=new JLabel("8. Maybe, "+name+" you know more than what your friend knows,Good Luck");
l9.setBounds(50,470,900,20);
l9.setFont(new Font("times new roman",Font.PLAIN,20));
f.add(l9);

b1=new JButton("Start");
b1.setBounds(200,550,150,30);
f.add(b1);
b2=new JButton("Back");
b2.setBounds(550,550,150,30);
f.add(b2);
b1.setFont(new Font("times new roman",Font.BOLD,30));
b2.setFont(new Font("times new roman",Font.BOLD,30));

b1.addActionListener(this);
b2.addActionListener(this);
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1)
{
s=new StudentQuizFrame(namee);
f.setVisible(false);
}
else if(ae.getSource()==b2){
l=new Login();
f.setVisible(false);
}
}
}