package com.thesischecker.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.thesischecker.interfaces.IFileProcess;

/**
 * Created by awilczyn on 26.04.2014.
 */
public class FileProcess implements IFileProcess {
    private static final int TEMP_FILE_ATTEMPTS = 10000;

    /**
     * @return the tempFileAttempts
     */
    public static int getTempFileAttempts() {
        return TEMP_FILE_ATTEMPTS;
    }

    private String path;

    public FileProcess(String pathToFile) {
        this.path = pathToFile;
    }

    /**
     * function to create file with unique filename
     * 
     * @param uploadFile
     * @return
     * @throws IOException
     */
    @Override
    public File createTempFile(File uploadFile) throws IOException {
        File baseDir = new File(this.path);
        String baseName = uploadFile.getName();
        String name;
        if (!baseName.contains(".")) {
            name = baseName;
        } else {
            name = baseName.substring(0, baseName.lastIndexOf("."));
        }
        String extension = baseName.substring(baseName.lastIndexOf('.'));

        File f = File.createTempFile(name, extension, baseDir);
        if (f.exists()) {
            return f;
        } else {
            throw new IllegalStateException("Error while creating file");
        }
    }

    /**
     * function to delete fie from disk
     */
    @Override
    public boolean deleteFileFromDisk() {
        try {
            File file = new File(this.path);
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * function to get file from disk
     * 
     * @return file stream
     */
    @Override
    public FileInputStream getFileFromDisk() {
        try {
            File file = new File(this.path);
            FileInputStream fis = new FileInputStream(file);
            return fis;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * function to save file on disk
     * 
     * @param uploadFile
     * @return
     * @throws IOException
     */
    @Override
    public String saveFileOnDisk(File uploadFile) throws IOException {
        InputStream uploadedInputStream = new FileInputStream(uploadFile);
        OutputStream out;
        int read = 0;
        byte[] bytes = new byte[1024];

        File newF = createTempFile(uploadFile);
        out = new FileOutputStream(newF);
        try {
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        uploadedInputStream.close();
        out.flush();
        out.close();
        return newF.getAbsolutePath();
    }
}
