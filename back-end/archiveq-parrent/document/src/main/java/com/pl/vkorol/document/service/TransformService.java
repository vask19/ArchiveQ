package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.entity.DocumentInstance;
import com.pl.vkorol.document.model.payload.DocumentDto;

public interface TransformService {

    DocumentInstance toDocumentInstance(DocumentDto documentDto);
}
