package org.rivera.cliente.jaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.rivera.cliente.jaxrs.models.Curso;

import java.util.List;

public class Main {
  public static void main(String[] args) {

    Client client = ClientBuilder.newClient();
    WebTarget rootUri = client.target("http://localhost:8080/webapp-jaxrs/api").path("/cursos");
    System.out.println("========== Curso por ID ==========");
    Curso course = rootUri.path("/3")
            .request(MediaType.APPLICATION_JSON)  //Lo que manda el servicio
            .get(Curso.class);                    //Cast a clase(El Back manda cierta estructura del objeto)
    System.out.println(course);

    System.out.println("========== Otra forma de obtener Curso por ID(Puedo tener mas información) ==========");
    Response response = rootUri.path("/5")
                .request(MediaType.APPLICATION_JSON)
                .get();
    Curso course2 = response.readEntity(Curso.class);
    System.out.println(course2);
    System.out.println(response.getStatus());
    System.out.println(response.getMediaType());

    System.out.println("========== Lista de Cursos ==========");
    List<Curso> curses = rootUri.request(MediaType.APPLICATION_JSON)
            .get(Response.class)
            .readEntity(new GenericType<List<Curso>>(){});
    curses.forEach(System.out::println);

    System.out.println("========== Lista de Cursos, de otra forma ==========");
    Response response2 = rootUri.request(MediaType.APPLICATION_JSON)
                .get();
    List<Curso> curses2 = response2.readEntity(new GenericType<List<Curso>>(){});
    curses2.forEach(System.out::println);
    System.out.println(response2.getDate());

  }
}
