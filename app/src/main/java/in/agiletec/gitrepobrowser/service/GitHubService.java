package in.agiletec.gitrepobrowser.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Shashanth
 */

public interface GitHubService {

    @GET("users/{user}")
    Call<String> getUserInfo(@Path("user") String userName);
}
