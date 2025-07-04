import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class GameOverFrame extends JFrame {

    public GameOverFrame(String playerName, int score,String course) {
        super("Simple Minds - Game Over");

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null); // Center the frame
        setLayout(null);
	setResizable(false);

        // Create components
        JLabel titleLabel = new JLabel("Thankyou " + playerName + " for playing Simple Minds");
        titleLabel.setFont(new Font("times new roman",Font.BOLD|Font.ITALIC,30));


        JLabel scoreLabel = new JLabel("Your score is " + score);
        scoreLabel.setFont(new Font("times new roman", Font.BOLD, 25));

        JButton playAgainButton = new JButton("Play Again");
	playAgainButton.setFont(new Font("times new roman",Font.BOLD,25));
        playAgainButton.addActionListener(e -> {
            // TODO: Add logic to restart the game
	    Login l=new Login();
            dispose(); // Close this frame
        });

	//set layout of components
	titleLabel.setBounds(50,60,750,40);
	scoreLabel.setBounds(450,150,250,40);
	playAgainButton.setBounds(450,230,200,30);
        // Add components to frame
	add(scoreLabel);
        add(titleLabel);
        add(playAgainButton);

	String query = "INSERT INTO Student (name, course, score) VALUES (?, ?, ?)";

        try{ 
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, playerName);
            preparedStatement.setString(2, course);
            preparedStatement.setInt(3, score);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null,"Student information stored successfully.");
            } else {
                JOptionPane.showMessageDialog(null,"Failed to store student information.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Make frame visible
        setVisible(true);
    }
}