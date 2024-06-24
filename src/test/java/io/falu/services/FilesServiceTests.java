package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.files.File;
import io.falu.models.files.FileCreateRequest;
import io.falu.models.files.FileListOptions;
import io.falu.models.files.links.FileLink;
import io.falu.models.files.links.FileLinkCreateRequest;
import io.falu.models.files.links.FileLinkPatchModel;
import io.falu.models.files.links.FileLinksListOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
public class FilesServiceTests extends BaseApiServiceTests {

    private final File file = File.builder()
            .fileName("test.png")
            .type("image/png")
            .purpose("customer.selfie")
            .size(1024)
            .id("file_123")
            .build();

    private final FileLink fileLink = FileLink.builder()
            .fileId("file_123")
            .created(new Date())
            .url("https/::example.com/123")
            .expired(false)
            .build();

    @Mock
    private FilesService service;

    @Test
    public void test_GetFilesWorks() throws IOException {
        service = Mockito.mock(FilesService.class, withSettings().useConstructor(options));

        FileListOptions opt = FileListOptions.builder()
                .count(1)
                .build();

        ResourceResponse<File[]> response = getResourceResponse(200, new File[]{file});
        when(service.getFiles(opt, requestOptions)).thenReturn(response);

        mockWebServer.enqueue(getMockedResponse(200, new File[]{file}));

        // when
        ResourceResponse<File[]> resp = service.getFiles(opt, requestOptions);
        Assertions.assertNotNull(resp);
        Assertions.assertTrue(response.getResource().length > 0);
    }

    @Test
    public void test_FileUploadWorks() throws IOException {
        service = Mockito.mock(FilesService.class, withSettings().useConstructor(options));

        FileCreateRequest request = FileCreateRequest.builder()
                .content(new java.io.File("file.pdf"))
                .description("cake")
                .purpose("customer.signature")
                .build();

        // given
        ResourceResponse<File> expectedResponse = getResourceResponse(200, file);
        when(service.uploadFile(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new File[]{file}));

        // when
        ResourceResponse<File> response = service.uploadFile(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetFileWorks() throws IOException {
        service = Mockito.mock(FilesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<File> expectedResponse = getResourceResponse(200, file);
        when(service.getFile("file_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new File[]{file}));

        // when
        ResourceResponse<File> response = service.getFile("file_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetFileLinksWorks() throws IOException {
        service = Mockito.mock(FilesService.class, withSettings().useConstructor(options));

        FileLinksListOptions opt = FileLinksListOptions.builder()
                .count(1)
                .build();

        // given
        ResourceResponse<FileLink[]> expectedResponse = getResourceResponse(200, new FileLink[]{fileLink});
        when(service.getFileLinks(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new File[]{file}));

        // when
        ResourceResponse<FileLink[]> response = service.getFileLinks(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateFileLinkWorks() throws IOException {
        service = Mockito.mock(FilesService.class, withSettings().useConstructor(options));

        FileLinkCreateRequest request = FileLinkCreateRequest.builder()
                .fileId("file_123")
                .build();

        // given
        ResourceResponse<FileLink> expectedResponse = getResourceResponse(200, fileLink);
        when(service.createFileLink(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, file));

        // when
        ResourceResponse<FileLink> response = service.createFileLink(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetFileLinkWorks() throws IOException {
        service = Mockito.mock(FilesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<FileLink> expectedResponse = getResourceResponse(200, fileLink);
        when(service.getFileLink("link_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, file));

        // when
        ResourceResponse<FileLink> response = service.getFileLink("link_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdateFileLinkWorks() throws IOException {
        service = Mockito.mock(FilesService.class, withSettings().useConstructor(options));

        FileLinkPatchModel patchModel = FileLinkPatchModel.builder()
                .description("cake")
                .build();

        // given
        ResourceResponse<FileLink> expectedResponse = getResourceResponse(200, fileLink);
        when(service.updateFileLink("link_123", patchModel, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, file));

        // when
        ResourceResponse<FileLink> response = service.updateFileLink("link_123", patchModel, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

}
