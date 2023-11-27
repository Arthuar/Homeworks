package run;

import entity.Client;
import entity.Planet;
import fw.FlyWay;
import hibernate.HibernateU;
import service.ClientServiceCrud;
import service.PlanetServiceCrud;

public class Run {
    public static void main(String[] args) {
        FlyWay.executeMigration();
        try (HibernateU util = HibernateU.getInstance()) {
            ClientServiceCrud clientService = new ClientServiceCrud();
            PlanetServiceCrud planetService = new PlanetServiceCrud();

            //create
            Client newClient = new Client();
            newClient.setName("I'm new client");

            Planet newPlanet = new Planet();
            newPlanet.setName("Mercury");

            clientService.save(newClient);
            planetService.save(newPlanet);


            //read
            Client client = clientService.findById(1);
            Planet planet = planetService.findById(3);

            //update
            client.setName("I have a new name now");
            planet.setName("Far far planet");

            clientService.update(client);
            planetService.update(planet);

            //delete
            clientService.delete(client);
            planetService.delete(planet);

        }
    }
}
