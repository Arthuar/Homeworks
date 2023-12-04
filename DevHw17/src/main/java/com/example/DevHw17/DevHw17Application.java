package com.example.DevHw17;
import com.example.DevHw17.flyway.FlyWayConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevHw17Application {


	public static void main(String[] args) {
		SpringApplication.run(DevHw17Application.class, args);
		FlyWayConnection flyWayConnection = new FlyWayConnection();
		flyWayConnection.runFlyWay();
	}

}
