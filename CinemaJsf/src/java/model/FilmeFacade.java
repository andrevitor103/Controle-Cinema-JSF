/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Filme;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andre Vitor
 */
@Stateless
public class FilmeFacade extends AbstractFacade<Filme> {

    @PersistenceContext(unitName = "CinemaJsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmeFacade() {
        super(Filme.class);
    }
    
}
