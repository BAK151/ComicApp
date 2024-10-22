package com.demo.comicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.demo.comicapp.databinding.ActivityLoginBinding;
import com.demo.comicapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initObserve();
        initToolbar();
    }
    private void initToolbar() {
        setSupportActionBar(binding.mdToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        binding.mdToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void initObserve(){
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                String username = "";
                String password = "";
                String phoneNum = "";

                if (TextUtils.isEmpty(binding.tfUsername.getEditText().getText())) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập Username!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    username = binding.tfUsername.getEditText().getText().toString();
                }

                if (!binding.tfPassword.getEditText().getText().toString().equals(binding.tfRePassword.getEditText().getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu không trùng khớp!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    password = binding.tfPassword.getEditText().getText().toString();
                }

                Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }



}