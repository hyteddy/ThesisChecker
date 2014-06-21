package com.thesischecker.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by awilczyn on 27.04.2014.
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class FileProcessTest extends TestCase {

    String currentDir = System.getProperty("user.dir");

    @Test(expected = FileNotFoundException.class)
    public void testConsistencyMechanismNegativeScenario()
            throws FileNotFoundException {
        // What
        FileProcess fileProcess = new FileProcess(null);
        // When
        fileProcess.consistencyMechanism();
        // Then ... throw new Exception
    }

    @Test
    public void testConsistencyMechanismPositiveScenario() throws Exception {
        System.out.println(currentDir);
        FileProcess fileProcess = new FileProcess(currentDir
                + "/src/main/resources/files/test6295411515061869163.md");
        fileProcess.consistencyMechanism();
    }

    @Test
    public void testCreateTempFile() throws Exception {
        FileProcess fileP = new FileProcess(currentDir
                + "/src/main/resources/files");
        File uploadFile = new File(currentDir
                + "/src/test/resources/testow.towy.md");
        File test = fileP.createTempFile(uploadFile);
    }

    @Test
    public void testDeleteFileFromDisk() throws Exception {
        FileProcess fileP = new FileProcess(currentDir
                + "/src/main/resources/files");
        File uploadFile = new File(currentDir
                + "/src/test/resources/testow.towy.md");
        File test = fileP.createTempFile(uploadFile);
        FileProcess fileToDelete = new FileProcess(currentDir
                + "/src/main/resources/files/" + test.getName());

        fileP.deleteFileFromDisk();
    }

    @Test
    public void testGetFileFromDisk() throws Exception {
        FileProcess fileP = new FileProcess(currentDir
                + "/src/main/resources/files/test6295411515061869163.md");
        FileInputStream test = fileP.getFileFromDisk();
    }

    @Test
    public void testSaveFileOnDisk() throws Exception {
        URL resourceUrl = getClass().getResource("/test.md");
        File uploadFile = new File(resourceUrl.getPath());
        FileProcess fileP = new FileProcess(currentDir
                + "/src/main/resources/files");
        fileP.saveFileOnDisk(uploadFile);
    }
}
