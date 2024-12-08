package com.pl.vkorol.document.controller.definition;

import com.pl.vkorol.document.model.payload.request.ArchiveDocumentDto;
import com.pl.vkorol.document.model.payload.request.PostArchiveDocument;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ArchiveDocumentController {

    @PostMapping
    @Operation(
            description = "Creates archive document.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request!"
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
     ResponseEntity<?> createArchiveDocument(@RequestBody PostArchiveDocument postArchiveDocument);

    @GetMapping(value = "/all")
    @Operation(
            description = "Returns all archive documents.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Returns all archive documents.",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                [
                                                    {
                                                        "documentName": "Document 1",
                                                        "descriptors": [
                                                            {
                                                                "name": "Descriptor 1",
                                                                "type": "String",
                                                                "maxLength": "255",
                                                                "description": "Description for descriptor 1"
                                                            },
                                                            {
                                                                "name": "Descriptor 2",
                                                                "type": "Integer",
                                                                "maxLength": "10",
                                                                "description": "Description for descriptor 2"
                                                            }
                                                        ]
                                                    },
                                                    {
                                                        "documentName": "Document 2",
                                                        "descriptors": [
                                                            {
                                                                "name": "Descriptor 3",
                                                                "type": "Boolean",
                                                                "maxLength": "5",
                                                                "description": "Description for descriptor 3"
                                                            }
                                                        ]
                                                    }
                                                ]
                                                """
                                            )
                                    }
                            )
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
    ResponseEntity<List<ArchiveDocumentDto>> getArchiveDocuments();

    @GetMapping
    @Operation(
            description = "Fetches a paginated list of archive documents.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully returned paginated list of archive documents.",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = """
                                            [
                                                {
                                                    "documentName": "Document 1",
                                                    "descriptors": [
                                                        {
                                                            "name": "Descriptor 1",
                                                            "type": "String",
                                                            "maxLength": "255",
                                                            "description": "Description for descriptor 1"
                                                        }
                                                    ]
                                                }
                                            ]
                                    """)
                            )
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
    ResponseEntity<List<ArchiveDocumentDto>> getArchiveDocuments(
            @RequestParam(required = false, defaultValue = "1") int _page,
            @RequestParam(required = false, defaultValue = "10") int _pageSize);

    @GetMapping(value = "/{name}")
    @Operation(
            description = "Fetches an archive document by name.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully returned the archive document.",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = """
                                            {
                                                "documentName": "Document 1",
                                                "descriptors": [
                                                    {
                                                        "name": "Descriptor 1",
                                                        "type": "String",
                                                        "maxLength": "255",
                                                        "description": "Description for descriptor 1"
                                                    }
                                                ]
                                            }
                                    """)
                            )
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
    ResponseEntity<ArchiveDocumentDto> getArchiveDocumentByName(@PathVariable String name);
}
