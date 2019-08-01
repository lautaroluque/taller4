package com.taller4.app.dominio;

import java.util.Objects;

public class UploadResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    
    public UploadResponse() {
    }

    public UploadResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return this.fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public UploadResponse fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public UploadResponse fileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
        return this;
    }

    public UploadResponse fileType(String fileType) {
        this.fileType = fileType;
        return this;
    }

    public UploadResponse size(long size) {
        this.size = size;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UploadResponse)) {
            return false;
        }
        UploadResponse uploadResponse = (UploadResponse) o;
        return Objects.equals(fileName, uploadResponse.fileName) && Objects.equals(fileDownloadUri, uploadResponse.fileDownloadUri) && Objects.equals(fileType, uploadResponse.fileType) && size == uploadResponse.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, fileDownloadUri, fileType, size);
    }

    @Override
    public String toString() {
        return "{" +
            " fileName='" + getFileName() + "'" +
            ", fileDownloadUri='" + getFileDownloadUri() + "'" +
            ", fileType='" + getFileType() + "'" +
            ", size='" + getSize() + "'" +
            "}";
    }
    
}