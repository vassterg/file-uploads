/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.insurit;

import java.io.File;
import java.io.InputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Test;

/**
 *
 * @author vasilis
 */
public class MultipartTest {
    
    private static final String BASE_URI = "http://localhost:8080/JerseyUpload/resources/";

//    @Test
//    public void testGetIt() throws Exception {
//
//        final Client client = ClientBuilder.newBuilder()
//                .register(MultiPartFeature.class)
//                .build();
//        WebTarget t = client.target(BASE_URI).path("multipart").path("upload2");
//
//        //InputStream in = MultipartTest.class.getResourceAsStream("devops.jpg");
//        FileDataBodyPart filePart = new FileDataBodyPart("file", new File(getClass().getResource("devops.jpg").toURI()));
//        // UPDATE: just tested again, and the below code is not needed.
//        // It's redundant. Using the FileDataBodyPart already sets the
//        // Content-Disposition information
//        //filePart.setContentDisposition(
//        //        FormDataContentDisposition.name("file")
//        //                .fileName("stackoverflow.png").build());
//
//        String empPartJson
//                = "{"
//                + "  \"id\": 1234,"
//                + "  \"name\": \"Peeskillet\""
//                + "  \"age\": 52"
//                + "}";
//
//        MultiPart multipartEntity = new FormDataMultiPart()
//                .field("emp", empPartJson, MediaType.APPLICATION_JSON_TYPE)
//                .bodyPart(filePart);
//
//        Response response = t.request().post(
//                Entity.entity(multipartEntity, multipartEntity.getMediaType()));
//        System.out.println(response.getStatus());
//        System.out.println(response.readEntity(String.class));
//
//        response.close();
//    }

    @Test
    public void testGetItServlet() throws Exception {

        final Client client = ClientBuilder.newBuilder()
                .register(MultiPartFeature.class)
                .build();
        WebTarget t = client.target("http://localhost:8080/JerseyUpload").path("upload");

        //InputStream in = MultipartTest.class.getResourceAsStream("devops.jpg");
        FileDataBodyPart filePart = new FileDataBodyPart("file", new File(getClass().getResource("devops.jpg").toURI()));
        // UPDATE: just tested again, and the below code is not needed.
        // It's redundant. Using the FileDataBodyPart already sets the
        // Content-Disposition information
        //filePart.setContentDisposition(
        //        FormDataContentDisposition.name("file")
        //                .fileName("stackoverflow.png").build());

        String empPartJson
                = "{"
                + "  \"id\": 1234,"
                + "  \"name\": \"Peeskillet\""
                + "  \"age\": 52"
                + "}";

        MultiPart multipartEntity = new FormDataMultiPart()
                .field("emp", empPartJson, MediaType.APPLICATION_JSON_TYPE)
                .field("destination", "/home/vasilis")
                .bodyPart(filePart);

        Response response = t.request().post(
                Entity.entity(multipartEntity, multipartEntity.getMediaType()));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));

        response.close();
    }
}
