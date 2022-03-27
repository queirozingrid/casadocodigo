package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.http.Part;

public class FileSaver {

    private static final String SERVER_PATH = "/casadocodigo_teste";

    public String write(Part arquivo, String path) {
        String relativePath =  path + "/" + arquivo.getSubmittedFileName();
    	System.out.println("primeiro path" + relativePath);

        try(InputStream is = arquivo.getInputStream()){
        	System.out.println("antes file");
        	Files.copy(is, new File(System.getProperty("java.io.tmpdir") + SERVER_PATH + "/" + relativePath).toPath());
        	System.out.println(relativePath);
        	return relativePath;
        } catch(IOException e) {
        	e.printStackTrace();
        	return null;
        }
		/*
		 * try { System.out.println(arquivo.getSubmittedFileName());
		 * arquivo.write(SERVER_PATH + "/" + relativePath); return relativePath;
		 * 
		 * } catch (IOException e) { e.printStackTrace(); throw new RuntimeException(e);
		 * }
		 */
    }
}
