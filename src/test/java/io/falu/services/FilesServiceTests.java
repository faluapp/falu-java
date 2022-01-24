package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.files.File;
import io.falu.models.files.FileCreateRequest;
import io.falu.models.files.FileListOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class FilesServiceTests extends BaseApiServiceTests {

    @Test
    public void test_GetFilesWorks() throws IOException {
        FilesService service = new FilesService(options);

        FileListOptions opt = FileListOptions.builder()
                .count(1)
                .build();

        ResourceResponse<File[]> response = service.getFiles(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_FileUploadWorks() throws IOException {
        FilesService service = new FilesService(options);

        FileCreateRequest request = FileCreateRequest.builder()
                .content(new java.io.File("file.pdf"))
                .description("cake")
                .purpose("customer.signature")
                .build();

        ResourceResponse<File> response = service.uploadFile(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetFileWorks() throws IOException {
        FilesService service = new FilesService(options);

        ResourceResponse<File> response = service.getFile("file_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }
}
