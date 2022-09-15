package org.rivera.cliente.jaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
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

    System.out.println("========== Lista de todos los Cursos ==========");


  }
}
