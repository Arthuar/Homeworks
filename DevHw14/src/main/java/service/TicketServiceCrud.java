package service;

import crud.TicketCr;
import entity.Ticket;

public class TicketServiceCrud {
    private final TicketCr ticketCr = new TicketCr();

    public void save(Ticket entity) {
        ticketCr.save(entity);
    }


    public Ticket findById(long id) {
        return ticketCr.findById(id);
    }


    public void update(Ticket entity) {
        ticketCr.update(entity);
    }


    public void delete(Ticket entity) {
        ticketCr.delete(entity);
    }
}
