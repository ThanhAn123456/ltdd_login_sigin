package com.example.ltdd_layoutloginsignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialTextInputPicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button btn_DangNhap;
    TextInputLayout til_TaiKhoan,til_MatKhau;
    TextView txt_DangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_DangNhap = findViewById(R.id.btn_DangNhap);
        til_TaiKhoan = findViewById(R.id.til_TaiKhoan);
        til_MatKhau = findViewById(R.id.til_MatKhau);
        txt_DangKy = findViewById(R.id.txt_DangKy);
        txt_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, thirdActivity.class);
                startActivity(intent);
            }
        });

        TextChangedListener_errEmty(til_TaiKhoan);
        TextChangedListener_errEmty(til_MatKhau);

        btn_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TaiKhoan = til_TaiKhoan.getEditText().getText().toString();
                String MatKhau = til_MatKhau.getEditText().getText().toString();
                if(MatKhau.equals("")) {
                    til_MatKhau.setError("Không được để trống");
                }
                if(TaiKhoan.equals("")) {
                    til_TaiKhoan.setError("Không được để trống");
                }
                if(TaiKhoan.equals("thanhan") && MatKhau.equals("123456")) {
                    Intent intent = new Intent(MainActivity.this,secondActivity.class);
                    startActivity(intent);
                }else if (!MatKhau.equals("") || !TaiKhoan.equals("")){
                    Toast.makeText(getApplicationContext(), "ERR username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void TextChangedListener_errEmty(TextInputLayout textinputlayout){
        textinputlayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String TaiKhoan = textinputlayout.getEditText().getText().toString();
                if(TaiKhoan.equals("")) {
                    textinputlayout.setError("Không được để trống");
                }else {
                    textinputlayout.setError("");
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}