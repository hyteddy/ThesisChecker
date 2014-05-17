package com.thesischecker.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by awilczyn on 27.04.2014.
 */
public interface IFileProcess {

    public String saveFileOnDisk(File uploadFile) throws IOException;

    public FileInputStream getFileFromDisk();

    public boolean deleteFileFromDisk();

    public File createTempFile(File uploadFile) throws IOException;

}
