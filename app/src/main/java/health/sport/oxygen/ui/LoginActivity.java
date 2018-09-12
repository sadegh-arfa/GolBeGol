package health.sport.oxygen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class LoginActivity extends AppCompatActivity {

    private EditText mailAddress;
    private EditText password;
    private ProgressBar process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mailAddress = (EditText) findViewById(R.id.mailAddress);
        password = (EditText) findViewById(R.id.password);
        process = findViewById(R.id.process);

        TextView login = (TextView) findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndLogin();
            }
        });


        TextView register = (TextView) findViewById(R.id.Register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });


    }


    private void validateAndLogin() {


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


        Call<User> call = apiService.login(mailAddress.getText().toString(), password.getText().toString());
        call.enqueue(new retrofit2.Callback<User>() {
            @Override
            public void onResponse(Call<User> call, retrofit2.Response<User> response) {

                process.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (!user.isError()) {
                        userConfig.setUser(user);
                        startActivity(new Intent(LoginActivity.this , MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, user.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.loginError), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                process.setVisibility(View.GONE);
                // Log error here since request failed
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
