/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonaclientapi.resource;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hm.registropersonabusiness.service.PersonaService;
import com.hm.registropersonaclientapi.util.Utilidades;
import com.hm.registropersonaentities.entities.Persona;
import com.hm.registropersonaentities.pojo.Respuesta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

/**
 *
 * @author HugoM
 */
@Path("persona")
public class PersonaResource {

    private static final Logger log = Logger.getLogger(PersonaResource.class);

    @EJB
    private PersonaService personaService;

    @GET
    @Path("getAllpersons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllpersons() {
        try {
            personaService = (PersonaService) Utilidades.getEJBRemote("PersonaService", PersonaService.class.getName());
        } catch (Exception ex) {
            log.error("Problemas de comunicacion con el EJB: " + ex);
        }

        List<Persona> lPersona = personaService.getAllPersons();
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .header("Access-Control-Allow-Headers", "Content-Type")
                .status(Response.Status.OK).entity(lPersona).build();

    }

    @GET
    @Path("getByPersonId/{idPersona}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPersonId(@PathParam("idPersona") long idPersona) {
        try {
            personaService = (PersonaService) Utilidades.getEJBRemote("PersonaService", PersonaService.class.getName());
        } catch (Exception ex) {
            log.error("Problemas de comunicacion con el EJB: " + ex);
        }
        Persona persona = personaService.getByPersonId(idPersona);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .header("Access-Control-Allow-Headers", "Content-Type")
                .status(Response.Status.OK).entity(persona).build();

    }

    @POST
    @Path("insertPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPerson(String request) throws ParseException {
        log.info("Inicio del metodo insertPerson de PersonaResource");
        Respuesta respuesta = new Respuesta();
        boolean response = false;
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(request);
        System.out.println("jsonObject: " + jsonObject);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = jsonObject.get("fechaNacimiento").toString().replaceAll("\"", "").replaceAll("/", "-");
        jsonObject.remove("fechaNacimiento");
        System.out.println("fecha: " + fecha);
        Persona persona = gson.fromJson(jsonObject, Persona.class);
        persona.setFechaNacimiento(sdf.parse(fecha));

        try {
            personaService = (PersonaService) Utilidades.getEJBRemote("PersonaService", PersonaService.class.getName());
        } catch (Exception ex) {
            log.error("Problemas de comunicacion con el EJB: " + ex);
        }
        response = personaService.insertPerson(persona);

        if (response) {
            respuesta.setMensaje("Registro exitoso!");
            respuesta.setResultado("0");
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET,POST")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .status(Response.Status.CREATED).entity(respuesta).build();
        } else {
            respuesta.setMensaje("Registro fallido!");
            respuesta.setResultado("-1");
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET,POST")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .status(Response.Status.CREATED).entity(respuesta).build();
        }
    }

    @PUT
    @Path("updatePerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(String request) throws ParseException {
        Respuesta respuesta = new Respuesta();
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(request);
        System.out.println("jsonObject: " + jsonObject);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = jsonObject.get("fechaNacimiento").toString().replaceAll("\"", "").replaceAll("/", "-");
        jsonObject.remove("fechaNacimiento");
        Persona persona = gson.fromJson(jsonObject, Persona.class);
        persona.setFechaNacimiento(sdf.parse(fecha));
        try {
            personaService = (PersonaService) Utilidades.getEJBRemote("PersonaService", PersonaService.class.getName());
        } catch (Exception ex) {
            log.error("Problemas de comunicacion con el EJB: " + ex);
        }
        boolean response = personaService.updatePerson(persona);
        if (response) {
            respuesta.setMensaje("Registro actualizado exitoso!");
            respuesta.setResultado("0");
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET,POST")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .status(Response.Status.CREATED).entity(respuesta).build();
        } else {
            respuesta.setMensaje("Actualizacion fallida!");
            respuesta.setResultado("-1");
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET,POST")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .status(Response.Status.CREATED).entity(respuesta).build();
        }
    }

    @DELETE
    @Path("deletePerson/{idPersona}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("idPersona") long idPersona) {
        Respuesta respuesta = new Respuesta();
        try {
            personaService = (PersonaService) Utilidades.getEJBRemote("PersonaService", PersonaService.class.getName());
        } catch (Exception ex) {
            log.error("Problemas de comunicacion con el EJB: " + ex);
        }
        boolean response = personaService.DeletePerson(idPersona);
        if (response) {
            respuesta.setMensaje("Registro eliminado con éxito!");
            respuesta.setResultado("0");
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET,POST")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .status(Response.Status.CREATED).entity(respuesta).build();
        } else {
            respuesta.setMensaje("falló la eliminación del registro!");
            respuesta.setResultado("-1");
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET,POST")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .status(Response.Status.CREATED).entity(respuesta).build();
        }
    }

}
