/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import entities.*;
import javax.ejb.EJB;
import model.SessaoFacade;

/**
 *
 * @author Andre Vitor
 */
@Named(value = "sessaoController")
@SessionScoped
public class sessaoController implements Serializable {

    @EJB
    private SessaoFacade sessaoFacade;
    
    Sessao sessao = new Sessao();

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
    public List <Sessao> findAll(){
        return this.sessaoFacade.findAll();
    }
    
    
    public sessaoController() {
    }
    
    public String adicionar(){
        this.sessaoFacade.create(this.sessao);
        this.sessao = new Sessao();
        return "ListaSessao";
    }
    
    public void delete(Sessao sessao){
        this.sessaoFacade.remove(sessao);
    }
    
    public String editar(Sessao sessao){
        this.sessao = sessao;
        return "EditarSessao";
    }
    
    public String editar(){
        this.sessaoFacade.edit(sessao);
        this.sessao = new Sessao();
        return "ListaSessao";
    }
    
}

