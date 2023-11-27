package org.example.database;

import org.flyway.FlywayHw8;

import java.sql.SQLException;

public class RunApp {
    public static void main(String[] args) throws SQLException {
        new FlywayHw8().runFlyway();
        new InformationResult().resultData();
    }
}
