package com.iu33.crudfirebase.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.iu33.crudfirebase.R;
import com.iu33.crudfirebase.helper.MyFunction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends MyFunction {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.btn_reset_password)
    Button btnResetPassword;
    @BindView(R.id.btn_back1)
    Button btnBack1;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        auth = FirebaseAuth.getInstance();

    }

    @OnClick({R.id.btn_reset_password, R.id.btn_back1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_reset_password:
                progressBar.setVisibility(View.VISIBLE);
                String om = email.getText().toString();
                if (!om.equals("")) {
                    auth.sendPasswordResetEmail(om).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (!task.isSuccessful()) {
                                myToast("gagal ganti email" + task.getException());
                            } else {
                                myToast("berhasil ganti email");
                                auth.signOut();
                                //                           startActivity(new Intent(MainActivity.this,LoginActivity.class));
                                finish();
                            }
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                } else if (om.equals("")) {
                    email.setError("email lama harus diisi");
                    progressBar.setVisibility(View.GONE);
                }

                break;
            case R.id.btn_back1:
                finish();
                break;
        }
    }

}
