package com.thesischecker.filesystem;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by awilczyn on 27.04.2014.
 */
public class FileProcessTest extends TestCase {

    String currentDir = System.getProperty("user.dir");

    @Test
    public void testCreateTempFile() throws Exception {
        // FileProcess fileP = new
        // FileProcess(currentDir+"/WebApplication/app-java/src/main/resources/files");
        // File uploadFile = new
        // File(currentDir+"/WebApplication/app-java/src/test/resources/testow.towy.md");
        // File test = fileP.createTempFile(uploadFile);
    }

    @Test
    public void testDeleteFileFromDisk() throws Exception {
        // FileProcess fileP = new
        // FileProcess(currentDir+"/WebApplication/app-java/src/main/resources/files/test584778542838682843.md");
        // fileP.deleteFileFromDisk();
    }

    @Test
    public void testGetFileFromDisk() throws Exception {
        // FileProcess fileP = new
        // FileProcess(currentDir+"/WebApplication/app-java/src/main/resources/files/test584778542838682843.md");
        // FileInputStream test = fileP.getFileFromDisk();
    }

    @Test
    public void testSaveFileOnDisk() throws Exception {
        URL resourceUrl = getClass().getResource("/test.md");
        File uploadFile = new File(resourceUrl.getPath());
        FileProcess fileP = new FileProcess(currentDir
                + "/WebApplication/app-java/src/main/resources/files");
        fileP.saveFileOnDisk(uploadFile);
    }
}
