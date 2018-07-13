package souvik.rebrandlyintegrationmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import souvik.rebrandlyintegrationmodule.Data.RebrandlyModel.Request.Body;
import souvik.rebrandlyintegrationmodule.Data.RebrandlyModel.Response.Response;
import souvik.rebrandlyintegrationmodule.Data.Remote.RebrandlyApiService;
import souvik.rebrandlyintegrationmodule.Data.Remote.RebrandlyApiUtils;

public class MainActivity extends AppCompatActivity
{
    private String title = "This is a demo";                    //sample title
    private RebrandlyApiService rebrandlyApiService;
    private Body requestBody;

    private EditText lngUrlET;
    private Button sbmtBtn;
    private TextView shrtUrlTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lngUrlET = findViewById(R.id.lngUrlET);
        sbmtBtn = findViewById(R.id.sbmtBtn);
        shrtUrlTV = findViewById(R.id.shrtUrlTV);

        rebrandlyApiService = RebrandlyApiUtils.getAPIService();
        requestBody = new Body();

        sbmtBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                requestBody.setTitle(title);
                requestBody.setDestination(lngUrlET.getText().toString());
                rebrandlyApiService.savePost(requestBody).enqueue(new Callback<Response>()
                {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response)
                    {
                        String shortUrl = response.body().getShortUrl();
                        shrtUrlTV.setText(shortUrl);
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t)
                    {
                        Toast.makeText(MainActivity.this, "Short url not generated", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
