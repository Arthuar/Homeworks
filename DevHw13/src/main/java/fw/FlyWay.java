package fw;

import org.flywaydb.core.Flyway;

public class FlyWay {
    private FlyWay() {

    }

    public static void executeMigration() {
        Flyway
                .configure()
                .dataSource("jdbc:h2:./SpaceTravelDB", "", "")
                .load().migrate();
    }

}

