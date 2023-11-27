package service;

import crud.PlanetCr;
import entity.Planet;

public class PlanetServiceCrud {
    private final PlanetCr planetCr = new PlanetCr();

    public void save(Planet entity) {
        planetCr.save(entity);
    }


    public Planet findById(long id) {
        return planetCr.findById(id);
    }


    public void update(Planet entity) {
        planetCr.update(entity);
    }


    public void delete(Planet entity) {
        planetCr.delete(entity);
    }
}
