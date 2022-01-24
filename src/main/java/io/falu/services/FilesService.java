package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.files.File;
import io.falu.models.files.FileCreateRequest;
import io.falu.models.files.FileListOptions;
import io.falu.models.files.links.FileLink;
import io.falu.models.files.links.FileLinkCreateRequest;
import io.falu.models.files.links.FileLinkPatchModel;
import io.falu.models.files.links.FileLinksListOptions;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    public ResourceResponse<File[]> getFiles(@Nullable FileListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getFiles(listOptions, requestOptions);
    }

    /**
     * Upload File.
     *
     * @param request        Information for creating a file.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<File> uploadFile(@NotNull FileCreateRequest request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().uploadFile(request, requestOptions);
    }

    /**
     * Get File.
     *
     * @param fileId         Unique identifier of the file.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<File> getFile(@NotNull String fileId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getFile(fileId, requestOptions);
    }

    /**
     * Get File Links.
     *
     * @param listOptions    Options for filtering and pagination of list file links.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<FileLink[]> getFileLinks(@Nullable FileLinksListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getFileLinks(listOptions, requestOptions);
    }

    /**
     * Create File Link.
     *
     * @param request        Information for creating a file.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<FileLink> createFileLink(@NotNull FileLinkCreateRequest request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().createFileLink(request, requestOptions);
    }

    /**
     * Get File Link.
     *
     * @param linkId         Unique identifier of the file.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<FileLink> getFileLink(@NotNull String linkId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getFileLink(linkId, requestOptions);
    }

    /**
     * Update File Link.
     *
     * @param linkId         Unique identifier of the file.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<FileLink> updateFileLink(@NotNull String linkId, @NotNull JsonPatchDocument<FileLinkPatchModel> patch, RequestOptions requestOptions) throws IOException {
        return getApiClient().updateFileLink(linkId, patch, requestOptions);
    }
}
