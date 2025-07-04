import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentQuizFrame {

    private JFrame frame;
    private ImageIcon icon;
    private JLabel imageLabel,select;
    private JComboBox<String> courseComboBox;
    private String namee;
    private JButton nextButton;

    public StudentQuizFrame(String name) {
        // Create the frame
        frame = new JFrame("Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440, 900);
        frame.setLocationRelativeTo(null); // Center the frame
	frame.setLayout(null);
	frame.setResizable(false);
	namee=name;
	
	//image icon use to paste image on label
        icon=new ImageIcon("imagequiz.png");
        // Create components
        imageLabel = new JLabel(icon); // Replace with actual image loading
	String[] courses = {"", "Java", "C", "C++", "Python", "Aptitude", "Reasoning" };
        courseComboBox = new JComboBox<>(courses); // Populate with course options later
        nextButton = new JButton("Next");
	courseComboBox.setSelectedIndex(0);
	nextButton.setFont(new Font("times new roman",Font.BOLD,30));
	courseComboBox.setFont(new Font("times new roman",Font.PLAIN,30));
	select=new JLabel("Select Course:");

	//set layout of frame
	imageLabel.setBounds(0,0,1440,500);
	select.setBounds(550,580,200,30);
	courseComboBox.setBounds(550,650,300,40);
	nextButton.setBounds(570,750,150,40);
	select.setFont(new Font("times new roman",Font.BOLD,30));
        // Add components to the frame
        frame.add(imageLabel);
        frame.add(select);
        frame.add(courseComboBox);
        frame.add(nextButton);

        // Add ActionListener to the button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
		if(selectedCourse.equals("C++"))
		selectedCourse="cplusplus";
		if(selectedCourse.equals(""))
		           JOptionPane.showMessageDialog(frame, "Please select the Course.");
		else{

                QuizTest  q=new QuizTest(namee,selectedCourse);
		frame.setVisible(false);
	}
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}