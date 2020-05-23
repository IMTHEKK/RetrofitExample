package com.abc.example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("/wmsweb/webapi/email/")
    Call<ArrayList<EmailListResponse>> getEmails();

    @POST("/wmsweb/webapi/email/")
    Call<EmailListResponse> addEmail(@Body EmailListResponse emailListResponse);

    @PUT("/wmsweb/webapi/email/{idtableEmail}")
    Call<EmailListResponse> updateEmail(@Path("idtableEmail") int i, @Body EmailListResponse emailListResponse);

    @DELETE("/wmsweb/webapi/email/{idtableEmail}")
    Call<Boolean> deleteEmail(@Path("idtableEmail") int i);
}
