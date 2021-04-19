package com.restaurant.Context;

public class Response {
    private String fileName;
    private String fileDownloadUri;

    private long size;

    public Response(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;

        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }




    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
