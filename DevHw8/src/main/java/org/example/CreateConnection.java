package org.example;

import java.sql.*;

public class CreateConnection {
    public static void main(String[] args) {
        String sqlQwery = "SELECT * FROM osbb2.building";
        String url = "jdbc:mysql://localhost:3306/osbb2";
        String userName = "root";
        String pass = "Dikun19091988";

        try {
            Connection connection = DriverManager.getConnection(url, userName, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQwery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String adress = resultSet.getString("adress");
                System.out.println("id : " + id + " adress : " + adress);
            }
            connection.close();
            }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
