package com.example.DevHw17.flyway;

import com.example.DevHw17.H2Connect.Connect;
import org.flywaydb.core.Flyway;


public class FlyWayConnection {
    public void runFlyWay() {
        Flyway.configure()
                .dataSource(Connect.URL, Connect.USER_NAME, Connect.PASS)
                .locations("db.migration")
                .load()
                .migrate();
    }
}
