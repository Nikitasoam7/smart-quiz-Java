import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class StudentDetails extends JFrame {

    public StudentDetails() {
        super("Student Attend Test");

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 730);
        setLocationRelativeTo(null); // Center the frame
        setLayout(null);
	setResizable(false);

        // Create components
                JButton back = new JButton("Back");
        	back.addActionListener(e -> {
            // TODO: Add logic to restart the game
	    TeacherFrame t=new TeacherFrame();
            dispose(); // Close this frame
        });


	JTable table=new JTable();
	DefaultTableModel model=new DefaultTableModel();
	String head[]={"Student Name","Course","Score"};
	model.setColumnIdentifiers(head);
	JScrollPane pane=new JScrollPane(table);
	pane.setBounds(50,50,650,500);
	table.setModel(model);
	add(pane);

	try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/quiz","root","");
PreparedStatement st=conn.prepareStatement("select * from Student");
ResultSet rs=st.executeQuery();
while(rs.next())
{
String name=rs.getString(1);
String course=rs.getString(2);
 int score=rs.getInt(3);

model.addRow(new Object[]{name,course,score});
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e);
System.exit(0);
}

        // Add components to frame
        back.setBounds(350,620,150,40);
	back.setFont(new Font("times new roman",Font.BOLD,25));
	add(back);

        // Make frame visible
        setVisible(true);
    }
}