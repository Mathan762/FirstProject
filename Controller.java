package sample;

import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField.*;

import javax.swing.*;
import java.sql.*;

//import static sample.DB.user_id;

public class Controller {
    @FXML
    public static TextField nameField;
    public static TextField passwordField;
    public String username = nameField.getText();

    @FXML
    public void onButtonPressed() {
        System.out.println("Button Pressed ");
        //getUserName();
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "mysql", "Mathan762@");
            //if (connection != null)
            //System.out.println("DataBase Connection Success");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM faculty");
            if (resultSet.next()) {
                System.out.println(username);
                if (username.equals(resultSet.getString("fid")))
                    JOptionPane.showMessageDialog(null, "UserName and Password Matched");
                else {
                    JOptionPane.showMessageDialog(null, "UserName and Password does not Matched");
                }
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
        //System.out.println(getUserName());
        //getPassword();
    }

    public String getNameField()
    {
        return nameField.getText();
    }
//




//    public void checkUserName(String username)
//    {
//        if (username.equals(user_id))
//            System.out.println("True");
//        else
//            System.out.println("False");
//    }

    //    public Button log_in;




//    public static void getUdderID(ActionEvent a)
//    {
//        String username = user_id.getText();
//        System.out.println(usernam)

        //public String user_id

//    }
//public static void main(String[] args) {
//    Controller c = new Controller();
//    c.onButtonPressed();
//}
}
