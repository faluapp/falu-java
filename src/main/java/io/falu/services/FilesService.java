package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.files.File;
import io.falu.models.files.FileCreateRequest;
import io.falu.models.files.FileListOptions;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class FilesService extends BaseApiService {
    public FilesService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Get Files.
     *
     * @param listOptions    Options for filtering and pagination of list files.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<File[]> getFiles(FileListOptions listOptions, RequestOptions requestOptions) throws IOException {
        return getApiClient().getFiles(listOptions, requestOptions);
    }

    /**
     * Upload Files.
     *
     * @param request        Information for creating a file.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<File> uploadFile(FileCreateRequest request, RequestOptions requestOptions) throws IOException {
        return getApiClient().uploadFile(request, requestOptions);
    }

    /**
     * Upload Files.
     *
     * @param fileId         Unique identifier of the file.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<File> getFile(String fileId, RequestOptions requestOptions) throws IOException {
        return getApiClient().getFile(fileId, requestOptions);
    }
}
