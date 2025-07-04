import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class QuestionnaireGUI extends JFrame {

    public QuestionnaireGUI(String course) {
        // Setting up the JFrame
        setTitle("Questionnaire");
        setSize(1400, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
	setLocationRelativeTo(null);
	setResizable(false);
	Font fontStyle=new Font("times new roman",Font.BOLD,25);

        // Adding components
        // Label "Add Question"
        JLabel addQuestionLabel = new JLabel("Add Question");
	addQuestionLabel.setFont(new Font("times new roman",Font.BOLD,40));
        addQuestionLabel.setBounds(600, 20, 250, 40);
        add(addQuestionLabel);

        // Label "Course Name"
        JLabel courseNameLabel = new JLabel(course);
        courseNameLabel.setBounds(50, 100, 200, 40);
	courseNameLabel.setFont(new Font("times new roman",Font.BOLD,30));
        add(courseNameLabel);

        // Label "Question"
        JLabel questionLabel = new JLabel("Question");
        questionLabel.setBounds(20, 170, 150, 30);
	questionLabel.setFont(fontStyle);
        add(questionLabel);

        // Text area for question
        JTextArea questionTextArea = new JTextArea();
	questionTextArea.setFont(fontStyle);
	questionTextArea.setLineWrap(true);
	questionTextArea.setWrapStyleWord(true);
	JScrollPane pane1=new JScrollPane(questionTextArea);
        pane1.setBounds(150, 170, 1200, 200);
        add(pane1);


        // Label "Option 1"
        JLabel option1Label = new JLabel("Option 1");
        option1Label.setBounds(20, 420, 100, 30);
	option1Label.setFont(fontStyle);
        add(option1Label);

        // Text area for option 1
        JTextArea option1TextArea = new JTextArea();
	option1TextArea.setFont(fontStyle);
	option1TextArea.setLineWrap(true);
	option1TextArea.setWrapStyleWord(true);
	JScrollPane pane2=new JScrollPane(option1TextArea);
	 pane2.setBounds(150, 420, 1200, 50);
        add(pane2);

        // Labels and text areas for option 2, 3, and 4
        JLabel option2Label = new JLabel("Option 2");
        option2Label.setBounds(20, 500, 100, 30);
	option2Label.setFont(fontStyle);
        add(option2Label);

        JTextArea option2TextArea = new JTextArea();
	option2TextArea.setFont(fontStyle);
	option2TextArea.setLineWrap(true);
	option2TextArea.setWrapStyleWord(true);
	JScrollPane pane3=new JScrollPane(option2TextArea);
	 pane3.setBounds(150, 500, 1200, 50);
        add(pane3);

        JLabel option3Label = new JLabel("Option 3");
        option3Label.setBounds(20, 580, 100, 30);
	option3Label.setFont(fontStyle);
        add(option3Label);

        JTextArea option3TextArea = new JTextArea();
	option3TextArea.setFont(fontStyle);
	option3TextArea.setLineWrap(true);
	option3TextArea.setWrapStyleWord(true);
	JScrollPane pane4=new JScrollPane(option3TextArea);
	 pane4.setBounds(150, 580, 1200, 50);
        add(pane4);

        JLabel option4Label = new JLabel("Option 4");
        option4Label.setBounds(20, 660, 100, 30);
	option4Label.setFont(fontStyle);
        add(option4Label);

        JTextArea option4TextArea = new JTextArea();
	option4TextArea.setFont(fontStyle);
	option4TextArea.setLineWrap(true);
	option4TextArea.setWrapStyleWord(true);
	JScrollPane pane5=new JScrollPane(option4TextArea);
	 pane5.setBounds(150, 660, 1200, 50);
        add(pane5);

        // Label "Correct Option"
        JLabel correctOptionLabel = new JLabel("Correct Option");
        correctOptionLabel.setBounds(30, 780, 200, 30);
	correctOptionLabel.setFont(fontStyle);
        add(correctOptionLabel);

        // Combo box for correct option
        JComboBox<String> correctOptionComboBox = new JComboBox<>(new String[]{"","Option 1", "Option 2", "Option 3", "Option 4"});
        correctOptionComboBox.setBounds(250, 780, 200, 30);
	correctOptionComboBox.setFont(fontStyle);
        add(correctOptionComboBox);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(700, 780, 150, 40);
	submitButton.setFont(fontStyle);
        add(submitButton);

        // back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(900, 780, 150, 40);
	backButton.setFont(fontStyle);
        add(backButton);
	
	submitButton.addActionListener(e->{
	String correct;
	 String correctOption = (String) correctOptionComboBox.getSelectedItem();
        if (correctOption.equals("Option 1")) {
            correct= option1TextArea.getText();
        } else if (correctOption.equals("Option 2")) {
            correct=option2TextArea.getText();
        } else if (correctOption.equals("Option 3")) {
            correct= option3TextArea.getText();
        } else if (correctOption.equals("Option 4") ){
            correct=option4TextArea.getText();
        }
    	else{
        	correct= "";}
 	String question = questionTextArea.getText().trim();
        String option1 = option1TextArea.getText().trim();
        String option2 = option2TextArea.getText().trim();
        String option3 = option3TextArea.getText().trim();
        String option4 = option4TextArea.getText().trim();
	if(question.equals("")||option1.equals("")||option3.equals("")||option2.equals("")||option4.equals("")||correct.equals("")){
	JOptionPane.showMessageDialog(null,"Please fill all the required fields and Choose the Correct Option");
}
  	else{
		 addQuestionToDatabase(course, question, option1, option2, option3, option4, correct);
	questionTextArea.setText(null);
	option1TextArea.setText(null);
	option2TextArea.setText(null);
	option3TextArea.setText(null);
	option4TextArea.setText(null);
	correctOptionComboBox.setSelectedIndex(0); 

        	}

});

	backButton.addActionListener(e->{
	TeacherFrame teacher=new TeacherFrame();
	dispose();

});


        // Displaying the JFrame
        setVisible(true);
    }
 public static void addQuestionToDatabase(String tableName, String question, String option1, String option2, String option3, String option4, String correctOption) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/quiz","root","");

            // Create a parameterized SQL query to insert a new question
            String sql = "INSERT INTO " + tableName + " (Question, option1, option2, option3, option4, correctOption) VALUES (?, ?, ?, ?, ?, ?)";

            // Prepare the statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, option1);
            preparedStatement.setString(3, option2);
            preparedStatement.setString(4, option3);
            preparedStatement.setString(5, option4);
            preparedStatement.setString(6, correctOption);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
		JOptionPane.showMessageDialog(null, "Question added successfully. ");
            } else {
		JOptionPane.showMessageDialog(null, "Failed to add the question.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
}
}