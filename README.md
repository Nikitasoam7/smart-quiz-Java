📚 Smart Quiz Application
A Java-based quiz system built using basic tools like Notepad and MySQL Workbench. It supports two user roles — Teacher and Student — and enables secure quiz creation, participation, and result tracking for multiple courses.

🚀 Features
👩‍🏫 Teacher Role
Secure login using teacher credentials

View student attempts and scores for each course

Add new quiz questions to any subject (Java, C, C++, Python, Aptitude, Reasoning)

👨‍🎓 Student Role
Enter name and view quiz instructions

Choose a course and start quiz

10 random questions fetched from the MySQL database

View final score after submission

Option to play again by re-entering name

💻 Technologies Used
Component	Technology
Frontend	Java (via Notepad)
Backend Logic	Java (Console or Swing)
Database	MySQL (Workbench)
Tools	Notepad, Command Prompt, MySQL Workbench

🗃️ Example Table Structure
sql
Copy
Edit
CREATE TABLE python (
  QuestionID INT AUTO_INCREMENT PRIMARY KEY,
  Question TEXT NOT NULL,
  Option1 VARCHAR(255),
  Option2 VARCHAR(255),
  Option3 VARCHAR(255),
  Option4 VARCHAR(255),
  CorrectOption VARCHAR(255)
);
Each subject (Java, C++, Aptitude, etc.) has a similar table with questions and options.

📸 Screenshots
You can add screenshots here after uploading images in your GitHub repo:

Copy
Edit
![Home Page](screenshots/Role.png)
![Quiz Page](screenshots/quiz.png)


📦 How to Run the Project
Open Notepad and write your Java code (or open existing .java files).

Compile using Command Prompt:

bash
Copy
Edit
javac Role.java
java Role
Set up MySQL tables using MySQL Workbench (e.g., import quiz.sql if available).

Ensure your database connection (Connection, DriverManager, etc.) matches your MySQL credentials.

🧠 Future Enhancements
Add graphical user interface (GUI) using Swing or JavaFX

Implement timer for quizzes

Allow teachers to delete or edit questions

Generate performance reports for students

📄 License
This project is for educational purposes. You may reuse or extend it freely.
