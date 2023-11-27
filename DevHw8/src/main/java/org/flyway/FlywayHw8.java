package org.flyway;

import org.example.database.DataConnect;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

import java.sql.*;

public class FlywayHw8 {

    public void runFlyway() throws SQLException {
        MigrateResult flyway = Flyway.configure()
                .dataSource(DataConnect.url, DataConnect.userName, DataConnect.pass)
                .locations("classpath:db/migration")
                .load()
                .migrate();
    }
}
