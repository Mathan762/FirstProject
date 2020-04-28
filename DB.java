package sample;

import javax.swing.*;
import java.sql.*;

import static sample.Controller.nameField;
import static sample.Controller.passwordField;

public class DB{
    public static String user_id;
    public void connect()
    {
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "mysql", "Mathan762@");
            //if (connection != null)
                //System.out.println("DataBase Connection Success");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM faculty");
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "UserName and Password Matched");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "UserName and Password does not Matched");
                nameField.setText("");
                passwordField.setText("");
            }
            //System.out.println(user_id);
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DB db = new DB();
        db.connect();
    }
}