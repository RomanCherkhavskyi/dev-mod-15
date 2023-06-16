package com.example.services;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

    public void flywayMigration(){

        Flyway flyway = Flyway
                .configure()
                .baselineOnMigrate(true)
                .dataSource("jdbc:h2:C:\\goit\\dev\\dvm12\\MyDB","","")
                .load();

        flyway.migrate();

    }

}
