package com.wspa.vask.archiveservice.storage;

import com.wspa.vask.archiveservice.document.model.File;

import java.util.List;

public interface FileStorageService {

    void writeFile(File file);
    File readFile();
    void writeFiles(List<File> files);

}
