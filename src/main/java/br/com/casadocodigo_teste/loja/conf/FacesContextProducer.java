package br.com.casadocodigo_teste.loja.conf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer{

    @RequestScoped
    @Produces
    public FacesContext getFacesContext(){
            return FacesContext.getCurrentInstance();
    }

}
