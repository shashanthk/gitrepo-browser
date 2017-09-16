package in.agiletec.gitrepobrowser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.agiletec.gitrepobrowser.service.GitHubClient;
import in.agiletec.gitrepobrowser.service.GitHubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shashanth
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.et_github_user_name);
        Button btnGet = (Button) findViewById(R.id.btn_get_details);

        final GitHubService service = GitHubClient.getService();

        btnGet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Call<String> call = service.getUserInfo(name.getText().toString());
                        call.enqueue(
                                new Callback<String>() {
                                    @Override
                                    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

                                        Log.i(TAG, "onResponse: " + response.body());

                                    }

                                    @Override
                                    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

                                        Log.d(TAG, "onFailure() called with: Error " + t.getMessage());

                                    }
                                }
                        );

                    }
                }
        );
    }
}
