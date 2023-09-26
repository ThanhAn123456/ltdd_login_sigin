package com.example.ltdd_layoutloginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class thirdActivity extends AppCompatActivity {
    TextInputLayout til_Hoten,til_NgaySinh,til_Gmail,til_MoTa,til_DienThoai,til_TaiKhoanDangKy,til_MatKhauDangKy,til_XacNhanMatkhauDangKy;
    CheckBox checkBoxId;
    Button btn_DangKy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        til_Hoten = findViewById(R.id.til_HoTen);
        til_NgaySinh = findViewById(R.id.til_NgaySinh);
        til_Gmail = findViewById(R.id.til_Gmail);
        til_MoTa = findViewById(R.id.til_MoTa);
        til_DienThoai = findViewById(R.id.til_DienThoai);
        til_TaiKhoanDangKy = findViewById(R.id.til_TaiKhoanDangKy);
        til_MatKhauDangKy = findViewById(R.id.til_MatKhauDangKy);
        til_XacNhanMatkhauDangKy = findViewById(R.id.til_XacNhanMatKhauDangKy);
        checkBoxId = findViewById(R.id.checkboxId);
        btn_DangKy = findViewById(R.id.btn_DangKy);

//      làm thông báo err ko đc để trống
        TextChangedListener_errEmty(til_Hoten);
        TextChangedListener_errEmty(til_NgaySinh);
        TextChangedListener_errEmty(til_Gmail);
        TextChangedListener_errEmty(til_DienThoai);
        TextChangedListener_errEmty(til_TaiKhoanDangKy);
        TextChangedListener_errEmty(til_MatKhauDangKy);
        TextChangedListener_errEmty(til_XacNhanMatkhauDangKy);
        TextChangedListener_errEmty(til_MoTa);
//      hiện mục chọn ngày tháng năm
        til_NgaySinh.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
//       kiểm tra checkbox-> ẩn hiện button
        checkBoxId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxId.isChecked()){
                    btn_DangKy.setVisibility(View.VISIBLE);
                }else {
                    btn_DangKy.setVisibility(View.INVISIBLE);
                }
            }
        });
        btn_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void openDialog(){
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog dialog = new DatePickerDialog(this,R.style.DialogThemes, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                til_NgaySinh.getEditText().setText(String.valueOf(day)+"/"+String.valueOf(month+1)+"/"+String.valueOf(year));
            }
        },nam,thang,ngay);
        dialog.show();
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