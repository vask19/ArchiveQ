package com.pl.vkorol.fileservice.service;

import com.pl.vkorol.fileservice.exceptions.FtpConnectionException;
import com.pl.vkorol.fileservice.kafka.FtpFile;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


@Service
public class FtpService {

    @Value("${ftp.server}")
    private String FTP_SERVER;
    @Value("${ftp.username}")
    private String FTP_USERNAME;
    @Value("${ftp.password}")
    private String FTP_PASSWORD;
    @Value("${ftp.origin}")
    private String FTP_ORIGIN_DIRECTORY;
    @Value("${ftp.port}")
    private int FTP_PORT;


    private FTPClient getFtpConnection() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(FTP_SERVER, FTP_PORT);
        ftpClient.login(FTP_USERNAME, FTP_PASSWORD);

        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        return ftpClient;
    }

    public void uploadFileToFtp(FtpFile ftpFile) throws FtpConnectionException, IOException {
        try {
            FTPClient ftpClient = getFtpConnection();
            String remoteFilePath = FTP_ORIGIN_DIRECTORY + "/" + ftpFile.getDocumentUuid() + "/" + ftpFile.getFileName();
            boolean uploaded = streamFile(ftpFile.getContent(), ftpClient, remoteFilePath);
            if (!uploaded) {
                createFolder(ftpClient, ftpFile.getDocumentUuid());
                if (!streamFile(ftpFile.getContent(), ftpClient, remoteFilePath)) {
                    throw new FtpConnectionException("Cannot connect to server");
                }
            }
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException e) {
            throw new FtpConnectionException(e);
        }
    }

    private void createFolder(FTPClient client, String documentUuid) throws IOException {
        client.makeDirectory(FTP_ORIGIN_DIRECTORY + "/" + documentUuid);
    }

    private boolean streamFile(byte[] content, FTPClient ftpClient, String remoteFilePath) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(content);
        boolean uploaded = ftpClient.storeFile(remoteFilePath, inputStream);
        inputStream.close();
        return uploaded;
    }

    public boolean deleteFile(String path) throws IOException {
        FTPClient ftpClient = getFtpConnection();
        boolean deleted = ftpClient.deleteFile(path);
        ftpClient.logout();
        ftpClient.disconnect();
        return deleted;
    }

//    public ByteArrayOutputStream getFile(ImageEntity imageEntity) throws IOException {
//        FTPClient ftpClient = getFtpConnection();
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        boolean downloaded = ftpClient.retrieveFile(imageEntity.getPath(), outputStream);
//        ftpClient.logout();
//        ftpClient.disconnect();
//        if (downloaded) {
//            return outputStream;
//        }
//        throw new FtpConnectionException("Cannot download file");
//    }
}
