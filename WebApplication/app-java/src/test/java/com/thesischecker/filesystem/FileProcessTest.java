package com.thesischecker.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by awilczyn on 27.04.2014.
 */
public class FileProcessTest extends TestCase {

    String currentDir = System.getProperty("user.dir");

    @Test(expected = IOException.class)
    public void checkConsistencyMechanismNegativeScenario() {
        FileProcess fileProcess = new FileProcess(null);
        fileProcess.consistencyMechanism();
    }

    @Test
    public void checkConsistencyMechanismPositiveScenario() {
        FileProcess fileProcess = new FileProcess(
                currentDir
                        + "/WebApplication/app-java/src/main/resources/files/test6295411515061869163.md");
        fileProcess.consistencyMechanism();
    }

    @Test
    public void testCreateTempFile() throws Exception {
        FileProcess fileP = new FileProcess(currentDir
                + "/WebApplication/app-java/src/main/resources/files");
        File uploadFile = new File(currentDir
                + "/WebApplication/app-java/src/test/resources/testow.towy.md");
        File test = fileP.createTempFile(uploadFile);
    }

    @Test
    public void testDeleteFileFromDisk() throws Exception {
        FileProcess fileP = new FileProcess(
                currentDir
                        + "/WebApplication/app-java/src/main/resources/files/test584778542838682843.md");

        fileP.deleteFileFromDisk();
    }

    @Test
    public void testGetFileFromDisk() throws Exception {
        FileProcess fileP = new FileProcess(
                currentDir
                        + "/WebApplication/app-java/src/main/resources/files/test584778542838682843.md");
        FileInputStream test = fileP.getFileFromDisk();
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
