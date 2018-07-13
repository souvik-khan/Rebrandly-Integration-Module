package souvik.rebrandlyintegrationmodule.Data.Remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import souvik.rebrandlyintegrationmodule.Data.RebrandlyModel.Response.Response;

/**
 * Created by Souvik on 13-7-18.
 */

public interface RebrandlyApiService
{
    String rebrandlyApiKey = "fce9948d80714287af1036f30a3a2112";        //Rebrandly API key
    @Headers({
            "apikey: " + rebrandlyApiKey,
            "Content-Type: application/json"
    })
    @POST("links")
    Call<Response> savePost(@Body souvik.rebrandlyintegrationmodule.Data.RebrandlyModel.Request.Body requestBody);
}
