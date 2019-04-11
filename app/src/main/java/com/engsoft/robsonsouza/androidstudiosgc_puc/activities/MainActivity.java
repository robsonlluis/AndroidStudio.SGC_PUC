package com.engsoft.robsonsouza.androidstudiosgc_puc.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.engsoft.robsonsouza.androidstudiosgc_puc.R;
import com.engsoft.robsonsouza.androidstudiosgc_puc.databinding.ActivityMainBinding;
import com.engsoft.robsonsouza.androidstudiosgc_puc.model.ClienteAlunoModel;
import com.engsoft.robsonsouza.androidstudiosgc_puc.services.UserLoginTask;
import com.engsoft.robsonsouza.androidstudiosgc_puc.viewmodels.MainActivityViewModel;
import com.engsoft.robsonsouza.androidstudiosgc_puc.viewmodels.interfaces.IMainActivityAccess;

public class MainActivity extends AppCompatActivity implements IMainActivityAccess {

    // Private fields ---------------------------------------------------------

    private ActivityMainBinding binding;

    private MainActivityViewModel viewModel;

    // Protected methods ------------------------------------------------------

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    public static Context SGC_PUC_TCCcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SGC_PUC_TCCcontext = getApplicationContext();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new MainActivityViewModel(this);
        binding.setViewModel(viewModel);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private void attemptLogin() {
        if (UserLoginTask.mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            ClienteAlunoModel clienteAlunoModel = new ClienteAlunoModel();
            clienteAlunoModel.setEmail(email);
            clienteAlunoModel.setSenha(password);
            viewModel.autenticarClienteAluno(clienteAlunoModel);
        }
    }
}