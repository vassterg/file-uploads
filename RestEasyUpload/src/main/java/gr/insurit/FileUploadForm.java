/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.insurit;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

/**
 *
 * @author vasilis
 */
public class FileUploadForm {

    public FileUploadForm() {
    }

    private byte[] data;

    public byte[] getData() {
        return data;
    }

    @FormParam("uploadedFile")
    @PartType("application/octet-stream")
    public void setData(byte[] data) {
        this.data = data;
    }

}
