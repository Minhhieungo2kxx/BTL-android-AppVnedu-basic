package com.example.btl_qlsv;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.btl_qlsv.DB.EventDBHelper;
import com.example.btl_qlsv.DB.GradeOpenHelper;
import com.example.btl_qlsv.DB.ScoreDBHelper;
import com.example.btl_qlsv.DB.StudentOpenHelper;
import com.example.btl_qlsv.DB.SubjectDBHelper;
import com.example.btl_qlsv.DB.TeacherDBHelper;
import com.example.btl_qlsv.helpers.Alert;
import com.example.btl_qlsv.models.Session;
import com.example.btl_qlsv.models.Teacher;

public class LoginActivity extends AppCompatActivity {

    Session session;

    EditText txtUsername, txtPassword;
    AppCompatButton btnSignIn, btnRegister;
    TeacherDBHelper db = new TeacherDBHelper(this);
    Boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new Session(LoginActivity.this);


        checkAuth();
        setControl();
        setEvent();

    }


    private void checkAuth() {
        Teacher gv = ((App) LoginActivity.this.getApplication()).getTeacher();
        if (gv == null) return;
        gotoHome();
    }

    private void setControl() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void setEvent() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy input
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();


                // kiểm tra input
                if (username.isEmpty()) {
                    txtUsername.setError("Hãy nhập username!");
                    return;
                } else if (password.isEmpty()) {
                    txtPassword.setError("Hãy nhập password!");
                    return;
                }
                // khởi tạo alert
                Alert alert = new Alert(LoginActivity.this);
                alert.normal();

                // lấy Data từ csdl dựa trên input
                Teacher gv = db.getTeacher(Integer.parseInt(username));

                // Kiểm tra login
                if (gv == null) {
                    isLogin = false;
                    alert.showAlert("Tài khoản không tồn tại!", R.drawable.info_icon);
                } else if (!gv.getPassword().equals(password)) {
                    isLogin = false;
                    alert.showAlert("Sai mật khẩu!", R.drawable.info_icon);
                } else {
                    isLogin = true;
                    // set biến toàn cục
                    ((App) LoginActivity.this.getApplication()).setTeacher(gv);

                    session.set("teacherName", gv.getName());
                    session.set("teacherId", String.valueOf(gv.getId()));

                    alert.showAlert("Đăng nhập thành công!", R.drawable.check_icon);
                }


                alert.btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isLogin) {
                            gotoHome();
                        }
                        alert.dismiss();
                    }
                });
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeacherDBHelper dbDemoTeacher = new TeacherDBHelper(LoginActivity.this);
                dbDemoTeacher.deleteAndCreatTable();

                GradeOpenHelper dbDemoGrade = new GradeOpenHelper(LoginActivity.this);
                dbDemoGrade.deleteAndCreatTable();

                StudentOpenHelper dbDemoStudent = new StudentOpenHelper(LoginActivity.this);
                dbDemoStudent.deleteAndCreateTable();

                SubjectDBHelper dbDemoSubject = new SubjectDBHelper(LoginActivity.this);
                dbDemoSubject.deleteAndCreateTable();

                ScoreDBHelper scoreDBHelper = new ScoreDBHelper(LoginActivity.this);
                scoreDBHelper.deleteAndCreateTable();

                EventDBHelper eventDBHelper = new EventDBHelper(LoginActivity.this);
                eventDBHelper.deletedAndCreateTable();


                Toast.makeText(LoginActivity.this, "Tạo dữ liệu mẫu thành công !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void gotoHome() {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        LoginActivity.this.startActivity(i);
    }

}
