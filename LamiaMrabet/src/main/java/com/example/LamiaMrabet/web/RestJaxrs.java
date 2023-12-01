package com.example.LamiaMrabet.web;

import com.example.LamiaMrabet.enteties.Compte;
import com.example.LamiaMrabet.repositories.CompteRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Path("/banque")
public class RestJaxrs {
    @Autowired
    private CompteRepository cmt_rep;

    @GET
    @Path("/comptes")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> comptelist(){
        return cmt_rep.findAll();
    }
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value = "id") Long id){
        return cmt_rep.findById(id).get();
    }
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public  Compte save(Compte cmt){
        return cmt_rep.save(cmt);
    }
    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Compte update(Compte cmt, @PathParam("id") Long id){
        cmt.setId(id);
        return cmt_rep.save(cmt);
    }
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id){
        cmt_rep.deleteById(id);
    }
}
