package souvik.rebrandlyintegrationmodule.Data.Remote;

/**
 * Created by Souvik on 13-7-18.
 */

public class RebrandlyApiUtils
{
    private RebrandlyApiUtils()
    {}

    public static final String BASE_URL = "https://api.rebrandly.com/v1/";

    public static RebrandlyApiService getAPIService()
    {
        return RetrofitClient.getClient(BASE_URL).create(RebrandlyApiService.class);
    }
}
