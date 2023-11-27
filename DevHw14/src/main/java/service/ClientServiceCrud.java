package service;

import crud.ClientCr;
import entity.Client;

public class ClientServiceCrud {
    private final ClientCr clientCr = new ClientCr();

    public void save(Client entity) {
        clientCr.save(entity);
    }


    public Client findById(long id) {
        return clientCr.findById(id);
    }


    public void update(Client entity) {
        clientCr.update(entity);
    }


    public void delete(Client entity) {
        clientCr.delete(entity);
    }
}
