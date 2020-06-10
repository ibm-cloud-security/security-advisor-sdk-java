package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DeleteNoteOptions;

public class DeleteNote {

    private DeleteNote() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        DeleteNoteOptions opts = new DeleteNoteOptions.Builder()
            .accountId("<accountId>")
            .providerId("<providerId>")
            .noteId("<noteId>")
            .build();

        Response<Void> resp = findingsApi.deleteNote(opts).execute();
        System.out.println(resp.getResult());
    }
}
