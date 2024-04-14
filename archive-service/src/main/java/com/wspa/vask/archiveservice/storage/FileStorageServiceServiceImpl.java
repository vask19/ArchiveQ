package com.wspa.vask.archiveservice.storage;

import com.wspa.vask.archiveservice.document.model.File;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileStorageServiceServiceImpl implements FileStorageService {

    @Override
    public void writeFile(File file) {

    }

    @Override
    public File readFile() {
        return null;
    }

    @Override
    public void writeFiles(List<File> files) {

    }
}
