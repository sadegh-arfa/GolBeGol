package health.sport.oxygen.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import health.sport.oxygen.R;
import health.sport.oxygen.models.User;
import health.sport.oxygen.server.ApiClient;
import health.sport.oxygen.server.ApiInterface;
import health.sport.oxygen.util.userConfig;
import retrofit2.Call;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText mailAddress;
    private EditText password;
    private ProgressBar process;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = (EditText) findViewById(R.id.username);
        mailAddress = (EditText) findViewById(R.id.mail);
        password = (EditText) findViewById(R.id.password);
        process = findViewById(R.id.process);


        TextView register = (TextView) findViewById(R.id.Register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              validateAndRegister();
            }
        });
    }


    private void validateAndRegister() {



        if (username.getText() == null || username.getText().length() < 4) {
            username.setError(getResources().getString(R.string.InvalidUsername));
            return;
        } else {
            username.setError(null);
        }

        if (mailAddress.getText() == null || mailAddress.getText().length() < 3 || !isEmailValid(mailAddress.getText())) {
            mailAddress.setError(getResources().getString(R.string.InvalidEmail));
            return;
        } else {
            mailAddress.setError(null);
        }


        if (password.getText() == null || password.getText().length() < 6) {
            password.setError(getResources().getString(R.string.InvalidPass));
            return;
        } else {
            password.setError(null);
        }

        process.setVisibility(View.VISIBLE);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        Call<User> call = apiService.register(username.getText().toString() , mailAddress.getText().toString(), password.getText().toString());
        call.enqueue(new retrofit2.Callback<User>() {
            @Override
            public void onResponse(Call<User> call, retrofit2.Response<User> response) {

                process.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (!user.isError()) {
                        userConfig.setUser(user);
                        startActivity(new Intent(RegisterActivity.this , MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, user.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, getResources().getString(R.string.loginError), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                process.setVisibility(View.GONE);
                // Log error here since request failed
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
