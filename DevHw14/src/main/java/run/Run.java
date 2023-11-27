package run;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import fw.FlyWay;
import hibernate.HibernateU;
import service.ClientServiceCrud;
import service.PlanetServiceCrud;
import service.TicketServiceCrud;

import java.util.Date;

public class Run {
    public static void main(String[] args) {
        FlyWay.executeMigration();
        try (HibernateU util = HibernateU.getInstance()) {
            ClientServiceCrud clientService = new ClientServiceCrud();
            PlanetServiceCrud planetService = new PlanetServiceCrud();
            TicketServiceCrud ticketService = new TicketServiceCrud();

            Client client = clientService.findById(3);
            Planet fromPlanet = planetService.findById(2);
            Planet toPlanet = planetService.findById(3);

            //create
            //not valid entity
            Ticket newTicket1 = new Ticket();
            newTicket1.setClient(null);
            newTicket1.setFromPlanet(null);
            newTicket1.setToPlanet(null);
            newTicket1.setCreatedAt(new Date());
            ticketService.save(newTicket1);

            //valid entity
            Ticket newTicket = new Ticket();
            newTicket.setToPlanet(toPlanet);
            newTicket.setFromPlanet(fromPlanet);
            newTicket.setCreatedAt(new Date());
            newTicket.setClient(client);
            ticketService.save(newTicket);

            //read
            Ticket ticket = ticketService.findById(3);
            System.out.println(ticket);

            //update
            ticket.setClient(clientService.findById(1));
            ticketService.update(ticket);
            System.out.println(ticketService.findById(3));

            //delete
            ticketService.delete(ticket);
        }

    }
}
