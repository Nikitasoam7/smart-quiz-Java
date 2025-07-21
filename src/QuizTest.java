import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.HashSet;
import java.sql.*;
import java.util.Set;


public class QuizTest {
	JFrame frame;
	 ImageIcon imageIcon;
	JButton button1,button2;
	JTextArea question,option1,option2,option3,option4;
	ButtonGroup group ;
	JRadioButton radioButton1,radioButton2,radioButton3,radioButton4;
	Connection connection;
	PreparedStatement prepareStatement;
	ResultSet resultSet;
	int[] randomNumbers;
	int max,index,marks;

	QuizTest(String name,String course){
        frame = new JFrame("Quiz Test");
        frame.setSize(1440, 1000);
        frame.setLayout(null); // Using null layout
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);	
	index=1;
	marks=0;
        // Image label
        imageIcon = new ImageIcon("imagequiz.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 1440, 430); // x, y, width, height
        frame.add(imageLabel);

	try{
	Class.forName("com.mysql.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Mysql@77");
	 // Construct the SQL query with the table name directly
         String query = "SELECT MAX(QuestionNo) FROM " + course;
         prepareStatement = connection.prepareStatement(query);
	resultSet=prepareStatement.executeQuery();
	if(resultSet.next())
	{
		max=Integer.parseInt(resultSet.getString(1));
	}
	else {
		JOptionPane.showMessageDialog(null,"Something is wrong, data is not fetched from DataBase");
		frame.dispose();}
	}
	catch(Exception e)
	{

	JOptionPane.showMessageDialog(null,"2  "+e);
            e.printStackTrace(); // Print stack trace to help debug
	System.exit(0);
}
        // Text label
        question = new JTextArea();
	question.setLineWrap(true);
	question.setWrapStyleWord(true);
	question.setFont(new Font("times new roman",Font.BOLD,20));
	question.setEditable(false);
	JScrollPane scrollPane=new JScrollPane(question);
        scrollPane.setBounds(50, 460, 1100, 170); // x, y, width, height
        frame.add(scrollPane);

        // Buttons
        button1 = new JButton("Submit");
         button1.setEnabled(false);
	button1.setFont(new Font("times new roman",Font.BOLD,30));
        button1.setBounds(1200, 650, 150, 40); // x, y, width, height
        frame.add(button1);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	 String selectedOption = getSelectedOption();
                if (selectedOption != null) {
		try{
			//Logic to check qestion
			String check="Select correctOption from "+course+" where QuestionNo=" + randomNumbers[index-1];
			prepareStatement = connection.prepareStatement(check);
			resultSet=prepareStatement.executeQuery();
			if(resultSet.next())
			{
				String correctOption=resultSet.getString("correctOption");
				if(correctOption.equals(selectedOption))
					marks+=10;
                		GameOverFrame g=new GameOverFrame(name,marks,course);
				frame.setVisible(false);
            
			}
}
			catch(Exception ee)
			{ JOptionPane.showMessageDialog(null,ee);}
}
	}
        });


        option1 = new JTextArea();
	option1.setLineWrap(true);
	option1.setWrapStyleWord(true);
	option1.setFont(new Font("times new roman",Font.BOLD,25));
	option1.setEditable(false);
	JScrollPane pane1=new JScrollPane(option1);
	option1.setOpaque(false); // Make the text area transparent
        pane1.setBounds(70, 650, 1000, 50); // x, y, width, height
        frame.add(pane1);


        // Radio buttons
        radioButton1 = new JRadioButton();
        radioButton1.setBounds(50, 650, 20, 50); // x, y, width, height
        frame.add(radioButton1);

        option2 = new JTextArea();
	option2.setLineWrap(true);
	option2.setWrapStyleWord(true);
	option2.setFont(new Font("times new roman",Font.BOLD,25));
	option2.setEditable(false);
	JScrollPane pane2=new JScrollPane(option2);
	option2.setOpaque(false); // Make the text area transparent
        pane2.setBounds(70, 720, 1000, 50); // x, y, width, height
        frame.add(pane2);

        radioButton2 = new JRadioButton();
	radioButton2.setFont(new Font("times new roman",Font.BOLD,20));
        radioButton2.setBounds(50, 720, 20, 50); // x, y, width, height
        frame.add(radioButton2);

        option3 = new JTextArea();
	option3.setLineWrap(true);
	option3.setWrapStyleWord(true);
	option3.setFont(new Font("times new roman",Font.BOLD,25));
	option3.setEditable(false);
	JScrollPane pane3=new JScrollPane(option3);
	option3.setOpaque(false); // Make the text area transparent
        pane3.setBounds(70, 790, 1000, 50); // x, y, width, height
        frame.add(pane3);

        radioButton3 = new JRadioButton();
	radioButton3.setFont(new Font("times new roman",Font.BOLD,20));
        radioButton3.setBounds(50, 790, 20, 50); // x, y, width, height
        frame.add(radioButton3);

        option4 = new JTextArea();
	option4.setLineWrap(true);
	option4.setWrapStyleWord(true);
	option4.setFont(new Font("times new roman",Font.BOLD,25));
	option4.setEditable(false);
	JScrollPane pane4=new JScrollPane(option4);
	option4.setOpaque(false); // Make the text area transparent
        pane4.setBounds(70, 860, 1000, 50); // x, y, width, height
        frame.add(pane4);

        radioButton4 = new JRadioButton();
	radioButton4.setFont(new Font("times new roman",Font.BOLD,20));
        radioButton4.setBounds(50, 860, 20, 50); // x, y, width, height
        frame.add(radioButton4);

        // Button group for radio buttons
        group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);

        // Create a Set to keep track of  generated random numbers
        Set<Integer> generatedNumbers = new HashSet<>();
	randomNumbers=new int[10];
	Random random=new Random();
	for (int i = 0; i < randomNumbers.length; i++) {
            int number;
            do {
                number = random.nextInt(max)+1; // Generate random number
            } while (generatedNumbers.contains(number)); // Ensure the number is unique

            randomNumbers[i] = number;
            generatedNumbers.add(number); // Add the number to the Set
        }
	System.out.println(max);
        for (int num : randomNumbers) 
	System.out.println(num);
	try{
        String  query = "SELECT * FROM " + course + " where QuestionNo=" + randomNumbers[0];
         prepareStatement = connection.prepareStatement(query);
	resultSet=prepareStatement.executeQuery();
	if(resultSet.next())
	{
		question.setText("Question 1.  " + resultSet.getString("Question"));
		option1.setText(resultSet.getString("option1"));
		option2.setText(resultSet.getString("option2"));
		option3.setText(resultSet.getString("option3"));
		option4.setText(resultSet.getString("option4"));
		
	}

	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"3  "+e);
		System.exit(0);
	}

        JButton button2 = new JButton("Next");
	button2.setFont(new Font("times new roman",Font.BOLD,30));
        button2.setBounds(1200, 760, 150, 40); // x, y, width, height
        frame.add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

		radioButton1.setSelected(false);
		radioButton2.setSelected(false);
		radioButton3.setSelected(false);
		radioButton4.setSelected(false);

	 String selectedOption = getSelectedOption();
                if (selectedOption != null) {
		try{
			//Logic to check qestion
			String check="Select correctOption from "+course+" where QuestionNo=" + randomNumbers[index-1];
			prepareStatement = connection.prepareStatement(check);
			resultSet=prepareStatement.executeQuery();
			if(resultSet.next())
			{
				String correctOption=resultSet.getString("correctOption");
				if(correctOption.equals(selectedOption))
					marks+=10;
			}

                    // Logic to load the next question goes here
		
        String  query = "SELECT * FROM " + course + " where QuestionNo=" + randomNumbers[index];
         prepareStatement = connection.prepareStatement(query);
	resultSet=prepareStatement.executeQuery();
	if(resultSet.next())
	{
		question.setText("Question "+(index+1)+".  " + resultSet.getString("Question"));
		option1.setText(resultSet.getString("option1"));
		option2.setText(resultSet.getString("option2"));
		option3.setText(resultSet.getString("option3"));
		option4.setText(resultSet.getString("option4"));
		index++;
	}
	if(index>=10)
	{
		button1.setEnabled(true);
		button2.setEnabled(false);
	}

	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"4  "+ e);
		System.exit(0);
	}
	}
	 else {
                    JOptionPane.showMessageDialog(frame, "Please select an option.");
                }
	}
        });


        // Set frame visibility
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private String getSelectedOption() {
        if (radioButton1.isSelected()) {
            return option1.getText();
        } else if (radioButton2.isSelected()) {
            return option2.getText();
        } else if (radioButton3.isSelected()) {
            return option3.getText();
        } else if (radioButton4.isSelected()) {
            return option4.getText();
        }
        return null;
    }
}