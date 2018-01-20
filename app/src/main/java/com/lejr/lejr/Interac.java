package com.lejr.lejr;

/**
 * Created by jason on 20/01/18.
 */

import retrofit2.*;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Interac {
    // GET - access token
    @GET("access-tokens")
    Call<String> token(@Header("secretKey") String secretKey, @Header("salt") String salt, @Header("thirdPartyAccessId") String thirdPartyAccessId);

    // POST - send request
    @POST("/money-requests/send")
    Call<Void> request(@Header("accessToken") String accessToken, @Header("thirdPartyAccessId") String thirdPartyAccessId, @Header("requestId") String requestId, @Header("deviceId") String deviceId, @Header("apiRegistrationId") String apiRegistrationId);
}
