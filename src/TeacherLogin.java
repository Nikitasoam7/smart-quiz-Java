//first slied for role
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class TeacherLogin implements ActionListener
{
JFrame f;
JLabel l1,l2,l3;
JTextField t1;
JPasswordField  p;
JButton b1,b2;
Connection connection;
PreparedStatement prepareStatement;
ResultSet resultSet;
Role r;
TeacherLogin()
{
f=new JFrame("Teacher");
f.setSize(1300,600);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

ImageIcon i=new ImageIcon("quiz.jpg");
l1=new JLabel(i);
l1.setBounds(0,0,600,600);
f.add(l1);

l2=new JLabel("ID");
l2.setBounds(700,100,150,30);
l2.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,30));
f.add(l2);
t1=new JTextField();
t1.setBounds(900,100,300,30);
t1.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,20));
f.add(t1);
p=new JPasswordField();
p.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,20));
p.setBounds(900,180,300,30);
f.add(p);

l3=new JLabel("Password");
l3.setBounds(700,180,150,30);
l3.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,20));
f.add(l3);

b1=new JButton("Submit");
b1.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,20));
b1.setBounds(750,360,150,30);
f.add(b1);

b2=new JButton("Back");
b2.setBounds(1000,360,150,30);
b2.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,20));
f.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);

	t1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (t1.getText().length() >= 4) {
                    e.consume(); // If length is greater than or equal to 10, ignore further input
                }
            }
        });
	p.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (p.getText().length() >= 15) {
                    e.consume(); // If length is greater than or equal to 15, ignore further input
                }
            }
        });

//connection with databse
try{
	Class.forName("com.mysql.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Mysql@77");

}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
System.exit(0);
}
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
	{
	String id=t1.getText();
String pin=p.getText();
try
{
if(id.trim().equals("")||pin.trim().equals(""))
JOptionPane.showMessageDialog(f,"Enter your Details");
else
{
prepareStatement=connection.prepareStatement("select TeacherName from teacher where teacherid=? and password=?");
prepareStatement.setString(1,id);
prepareStatement.setString(2,pin);
resultSet=prepareStatement.executeQuery();
if(resultSet.next())
{
JOptionPane.showMessageDialog(null,"welcome Teacher ");
TeacherFrame teacher=new TeacherFrame();
f.dispose();
}
else
JOptionPane.showMessageDialog(null,"Invalid id/password");
}
}
catch(Exception e){
JOptionPane.showMessageDialog(null,e);
System.exit(0);
}
}
else if(ae.getSource()==b2)
{
f.setVisible(false);
r=new Role();
}
}
}