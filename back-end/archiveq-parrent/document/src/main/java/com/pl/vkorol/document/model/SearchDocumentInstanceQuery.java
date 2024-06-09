package com.pl.vkorol.document.model;

import com.pl.vkorol.document.model.payload.DescriptorDto;
import com.pl.vkorol.document.model.payload.DocumentDto;
import jakarta.persistence.Query;
import lombok.Data;

import java.util.List;

@Data
public class SearchDocumentInstanceQuery {

    private String documentName;
    private List<DescriptorDto> descriptorDtoList;

    private SearchDocumentInstanceQuery(String documentName, List<DescriptorDto> descriptorDtoList) {
        this.documentName = documentName;
        this.descriptorDtoList = descriptorDtoList;
    }

    public static SearchDocumentInstanceQuery ofDocumentDto(DocumentDto documentDto) {
        return new SearchDocumentInstanceQuery(documentDto.getDocumentName(), documentDto.getDescriptors());
    }

    public String generateJpqlQuery() {
        StringBuilder jpql = new StringBuilder("SELECT d FROM document_instance d");
        boolean hasConditions = false;

        if (documentName != null && !documentName.isEmpty()) {
            jpql.append(" WHERE d.template.documentName = :documentName");
            hasConditions = true;
        }

        if (descriptorDtoList != null && !descriptorDtoList.isEmpty()) {
            for (int i = 0; i < descriptorDtoList.size(); i++) {
                String descriptorValue = descriptorDtoList.get(i).value();
                if (descriptorValue != null && !descriptorValue.isEmpty()) {
                    if (hasConditions) {
                        jpql.append(" AND");
                    } else {
                        jpql.append(" WHERE");
                        hasConditions = true;
                    }
                    jpql
                            .append(" EXISTS (SELECT 1 FROM d.descriptors desc WHERE desc.archiveDescriptor.name = :name")
                            .append(i)
                            .append(" AND desc.value = :value")
                            .append(i)
                            .append(")");
                }
            }
        }

        return jpql.toString();
    }

    public void setQueryParameters(Query query) {
        if (documentName != null && !documentName.isEmpty()) {
            query.setParameter("documentName", documentName);
        }
        if (descriptorDtoList != null && !descriptorDtoList.isEmpty()) {
            for (int i = 0; i < descriptorDtoList.size(); i++) {
                String descriptorValue = descriptorDtoList.get(i).value();
                if (descriptorValue != null && !descriptorValue.isEmpty()) {
                DescriptorDto descriptorDto = descriptorDtoList.get(i);
                query.setParameter("name" + i, descriptorDto.name());
                query.setParameter("value" + i, descriptorDto.value());
            }
            }
        }
    }
}
