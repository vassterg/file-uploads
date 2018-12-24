/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.insurit.uploader.boundary;

import gr.insurit.uploader.entity.Data;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author vasilis
 */
@Path("multipart")
public class FileUpload {
    
    @POST
    @Path("/upload2")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response uploadFileWithData(
            @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition cdh,
            @FormDataParam("emp") Data d) throws Exception{

        //Image img = ImageIO.read(fileInputStream);
        //JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
        System.out.println(cdh.getName());
        System.out.println(d);

        return Response.ok("Cool Tools!").build();
    } 
}
