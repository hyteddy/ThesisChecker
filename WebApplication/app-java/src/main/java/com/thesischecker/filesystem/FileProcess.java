package com.thesischecker.filesystem;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SyncFailedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.thesischecker.interfaces.IFileProcess;

/**
 * Created by awilczyn on 26.04.2014.
 */
public class FileProcess implements IFileProcess {

    /**
     * Logger for monitoring runtime.
     */
    private static final Logger log = LoggerFactory
            .getLogger(FileProcess.class);

    private static final int TEMP_FILE_ATTEMPTS = 10000;

    private String path;

    public FileProcess(String pathToFile) {
        this.path = pathToFile;
    }

    /**
     * This method check if File is located (correctly save on disk) to provide
     * transactions mechanism. If you want use this method to provide proper
     * consistency mechanism between database and file system, you need in you
     * upper method use {@link Transactional} annotation. Don't catch
     * Exceptions, let to handle mechanisms of transactions.
     * 
     * @throws FileNotFoundException
     */
    public void consistencyMechanism() throws FileNotFoundException {
        if (path == null) {
            throw new FileNotFoundException();
        }

        // Force all system buffers to synchronize with the underlying device.
        // This method returns after all modified data and attributes of this
        // FileDescriptor have been written to the relevant device(s). In
        // particular, if this FileDescriptor refers to a physical storage
        // medium, such as a file in a file system, sync will not return until
        // all in-memory modified copies of buffers associated with this
        // FileDescriptor have been written to the physical medium. sync is
        // meant to be used by code that requires physical storage (such as a
        // file) to be in a known state For example, a class that provided a
        // simple transaction facility might use sync to ensure that all changes
        // to a file caused by a given transaction were recorded on a storage
        // medium. sync only affects buffers downstream of this FileDescriptor.
        // If any in-memory buffering is being done by the application (for
        // example, by a BufferedOutputStream object), those buffers must be
        // flushed into the FileDescriptor (for example, by invoking
        // OutputStream.flush) before that data will be affected by sync.
        try {
            new FileDescriptor().sync();
        } catch (SyncFailedException e) {
            e.printStackTrace();
        }

        FileInputStream fileStream = getFileFromDisk();

        if (fileStream == null) {
            throw new FileNotFoundException();
        }
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
     * function to delete file from disk
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
        @SuppressWarnings("resource")
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

        out.flush();
        out.close();

        return newF.getAbsolutePath();
    }
}
