package com.company;

import java.io.File;
import java.nio.file.Files;

public class FileReader {
    private File file;
    private String extension;
    private byte[] fileContent;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public void getFileByName(String fileName) throws Exception {
        file = new File(fileName);

        if(!file.exists()) {
            throw new RuntimeException("There is no such file!");
        }

        fileContent = Files.readAllBytes(file.toPath());
        String name = file.getName();
        extension = name.substring(name.lastIndexOf("."));
    }
}
