package org.example.database;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InformationResult {
    String sqlQwery = "SELECT members.first_name, members.last_name, members.mail, members.allow2drive," +
            " members.ownership, building.id AS numberOfBuilding, building.adress AS adressOfBuilding," +
            " flat.flat_number, flat.flat_area  \n" +
            "FROM flat \n" +
            "INNER JOIN members ON members.id_flat = flat.id\n" +
            "INNER JOIN building ON flat.id_building = building.id\n" +
            "WHERE allow2drive = '0' and ownership = '1';";

    public void resultData() {
        try {
            Connection connection = new DataConnect().getMyDbConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQwery);
            ResultSet resultSet = preparedStatement.executeQuery();
            FileWriter fileWriter = new FileWriter("src/file.txt", true);
            while (resultSet.next()) {
                String first_name = resultSet.getString("members.first_name");
                String last_name = resultSet.getString("members.last_name");
                String mail = resultSet.getString("members.mail");
                int allow2drive = resultSet.getInt("members.allow2drive");
                int ownership = resultSet.getInt("members.ownership");
                int id = resultSet.getInt("numberOfBuilding");
                String adress = resultSet.getString("adressOfBuilding");
                int flat_number = resultSet.getInt("flat.flat_number");
                double flat_area = resultSet.getDouble("flat.flat_area");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(("first_name='" + first_name + '\'' +
                        ", last_name='" + last_name + '\'' +
                        ", mail='" + mail + '\'' +
                        ", allow2drive=" + allow2drive +
                        ", ownership=" + ownership +
                        ", id=" + id +
                        ", adress='" + adress + '\'' +
                        ", flat_number=" + flat_number +
                        ", flat_area=" + flat_area));
                System.out.println(stringBuilder);
                fileWriter.write(String.valueOf(stringBuilder) + "\n");
            }
            fileWriter.close();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
