/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.insurit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/*
https://www.mkyong.com/webservices/jax-rs/file-upload-example-in-resteasy/
*/

@Path("/file")
public class UploadFileService {

    private final String UPLOADED_FILE_PATH = "/home/vasilis/";

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    public Response uploadFile(MultipartFormDataInput input) {

        String fileName = "";

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("uploadedFile");

        for (InputPart inputPart : inputParts) {

            try {

                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = getFileName(header);

                //convert the uploaded file to inputstream
                InputStream inputStream = inputPart.getBody(InputStream.class, null);

                byte[] bytes = IOUtils.toByteArray(inputStream);

                //constructs upload file path
                fileName = UPLOADED_FILE_PATH + fileName;

                writeFile(bytes, fileName);

                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return Response.status(200)
                .entity("uploadFile is called, Uploaded file name : " + fileName).build();

    }

    @POST
    @Path("/uploadm")
    @Consumes("multipart/form-data")
    public Response uploadFile(@MultipartForm FileUploadForm form) {

        String fileName = UPLOADED_FILE_PATH + "anything";

        try {
            writeFile(form.getData(), fileName);
        } catch (IOException e) {

            e.printStackTrace();
        }

        System.out.println("Done");

        return Response.status(200)
                .entity("uploadFile is called, Uploaded file name : " + fileName).build();

    }

    /**
     * header sample { Content-Type=[image/png], Content-Disposition=[form-data;
     * name="file"; filename="filename.extension"] }
     *
     */
    //get uploaded filename, is there a easy way in RESTEasy?
    private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }

    //save to somewhere
    private void writeFile(byte[] content, String filename) throws IOException {

        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fop = new FileOutputStream(file);

        fop.write(content);
        fop.flush();
        fop.close();

    }
}
