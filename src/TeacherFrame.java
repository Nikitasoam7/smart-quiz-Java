import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherFrame {

    private JFrame frame;
    private ImageIcon icon;
    private JLabel imageLabel,select;
    private JComboBox<String> courseComboBox;
    private JButton addQuestionButton,studentDetails,back;

    public TeacherFrame() {
        // Create the frame
        frame = new JFrame("Teacher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440, 900);
        frame.setLocationRelativeTo(null); // Center the frame
	frame.setLayout(null);
	frame.setResizable(false);

	//image icon use to paste image on label
        icon=new ImageIcon("imagequiz.png");
        // Create components
        imageLabel = new JLabel(icon); // Replace with actual image loading
	String[] courses = {"", "Java", "C", "C++", "Python", "Aptitude", "Reasoning" };
        courseComboBox = new JComboBox<>(courses); // Populate with course options later
        addQuestionButton = new JButton("Add Question");
	studentDetails = new JButton("Student Details");
	addQuestionButton.setFont(new Font("times new roman",Font.BOLD,25));
	studentDetails.setFont(new Font("times new roman",Font.BOLD,25));
	courseComboBox.setFont(new Font("times new roman",Font.PLAIN,30));
	select=new JLabel("Select Course:");
        // back button
        back = new JButton("Back");
	back.setFont(new Font("times new roman",Font.BOLD,25));



	//set layout of frame
	imageLabel.setBounds(0,0,1440,450);
	select.setBounds(200,530,200,30);
	courseComboBox.setBounds(200,590,300,40);
	addQuestionButton.setBounds(850,550,250,40);
	studentDetails.setBounds(850,620,250,40);
        back.setBounds(850, 690, 250, 40);
	select.setFont(new Font("times new roman",Font.BOLD,30));
        // Add components to the frame
        frame.add(imageLabel);
        frame.add(select);
        frame.add(courseComboBox);
        frame.add(addQuestionButton);
        frame.add(studentDetails);
	frame.add(back);

        // Add ActionListener to the button
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
		if(selectedCourse.equals("C++"))
			selectedCourse="cplusplus";
		if(selectedCourse.equals(""))
		           JOptionPane.showMessageDialog(frame, "Please select the Course.");
		else{
                QuestionnaireGUI  add= new QuestionnaireGUI(selectedCourse);
		frame.setVisible(false);
	}
            }
        });
        studentDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		StudentDetails st=new StudentDetails();
		frame.setVisible(false);
            }
        });

	back.addActionListener(e->{
	TeacherLogin tl=new TeacherLogin();
	frame.dispose();

});



        // Make the frame visible
        frame.setVisible(true);
    }
}