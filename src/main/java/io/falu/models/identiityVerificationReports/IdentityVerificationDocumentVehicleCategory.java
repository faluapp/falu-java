package io.falu.models.identiityVerificationReports;

import lombok.Getter;

import java.util.Date;

@Getter
public class IdentityVerificationDocumentVehicleCategory {
    private String category;

    ///
    private Date issued;

    ///
    private Date expires;
}
