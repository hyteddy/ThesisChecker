package com.thesischecker.file;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

/**
 * Created by awilczyn on 27.04.2014.
 */
public class FileProcessTest extends TestCase {
    @Test
    public void testSaveFileOnDisk() throws Exception {
        URL resourceUrl = getClass().getResource("/test.md");
        File uploadFile = new File(resourceUrl.getPath());
        URL resourceUrl2 = getClass().getResource("/files");
        FileProcess fileP = new FileProcess("/Users/awilczyn/ThesisChecker/WebApplication/app-web/src/main/resources/files");
    }

    @Test
    public void testGetFileFromDisk() throws Exception {
        FileProcess fileP = new FileProcess("/Users/awilczyn/ThesisChecker/WebApplication/app-web/src/main/resources/files/test584778542838682843.md");
        FileInputStream test = fileP.getFileFromDisk();
    }

    @Test
    public void testDeleteFileFromDisk() throws Exception {
        FileProcess fileP = new FileProcess("/Users/awilczyn/ThesisChecker/WebApplication/app-web/src/main/resources/files/test584778542838682843.md");
        fileP.deleteFileFromDisk();
    }

    @Test
    public void testCreateTempFile() throws Exception {
        FileProcess fileP = new FileProcess("/Users/awilczyn/ThesisChecker/WebApplication/app-web/src/main/resources/files");
        File uploadFile = new File("/Users/awilczyn/ThesisChecker/filesystem/src/test/resources/testow.towy.md");
        File test = fileP.createTempFile(uploadFile);
    }
}
