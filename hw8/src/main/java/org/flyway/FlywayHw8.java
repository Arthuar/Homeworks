package org.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class FlywayHw8 {
    String url = "jdbc:mysql://localhost:3306/hw8";
    String userName = "root";
    String pass = "Dikun19091988";
    public void runFlyway() {
        MigrateResult flyway = Flyway.configure()
                .dataSource(url, userName, pass)
                .locations("classpath:db/migration")
                .load()
                .migrate();
    }
    public Connection getMyDbConnect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, pass);
        return connection;
    }

    public static void main(String[] args) throws IOException {

        FlywayHw8 fh = new FlywayHw8();
        fh.runFlyway();

        String sqlQwery = "SELECT members.first_name, members.last_name, members.mail, members.allow2drive," +
                " members.ownership, building.id AS numberOfBuilding, building.adress AS adressOfBuilding," +
                " flat.flat_number, flat.flat_area  \n" +
                "FROM flat \n" +
                "INNER JOIN members ON members.id_flat = flat.id\n" +
                "INNER JOIN building ON flat.id_building = building.id\n" +
                "WHERE allow2drive = '0' and ownership = '1';";
        try {
            Connection connection = new FlywayHw8().getMyDbConnect();
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
                stringBuilder.append((first_name + "," + last_name + "," + mail + "," + allow2drive + "," + ownership + ","
                        + id + "," + adress + "," + flat_number + "," + flat_area));
                System.out.println(stringBuilder);
                fileWriter.write(String.valueOf(stringBuilder) + "\n");
            }
            fileWriter.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
