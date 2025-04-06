package com.example.btl_qlsv.Classroom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_qlsv.R;
import com.example.btl_qlsv.helpers.Alert;
import com.example.btl_qlsv.models.Student;

import java.lang.ref.WeakReference;

public class ClassroomIndividualActivity extends AppCompatActivity {

    public static WeakReference<ClassroomIndividualActivity> weakActivity;

    TextView studentFamilyName, studentFirstName, studentGradeName, studentBirthday, studentGender, contentAlert;
    Button buttonGoBack, buttonUpdate, buttonDelete, buttonAlertConfirmation, buttonAlertCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_individual);

        weakActivity = new WeakReference<>(ClassroomIndividualActivity.this);
        setControl();

        setScreen();
        setEvent();
    }

    public static ClassroomIndividualActivity getmInstanceActivity() {
        return weakActivity.get();
    }

    private void setControl()
    {
        studentFamilyName = findViewById(R.id.studentFamilyName);
        studentFirstName = findViewById(R.id.studentFirstName);

        studentGradeName = findViewById(R.id.gradeName);
        studentBirthday = findViewById(R.id.birthday);

        buttonGoBack = findViewById(R.id.individualButtonGoBack);
        buttonUpdate = findViewById(R.id.individualButtonUpdate);
        buttonDelete = findViewById(R.id.individualButtonDelete);

        studentGender = findViewById(R.id.gender);
    }


    private void setScreen()
    {
        /*Step 1*/
        Student student = (Student) getIntent().getSerializableExtra("student");

        String familyName = student.getFamilyName();
        String firstName = student.getFirstName();
        String birthday = student.getBirthday();
        String gradeName = student.getGradeName();

        /*Step 2*/
        studentFamilyName.setText(familyName);
        studentFirstName.setText(firstName);
        studentBirthday.setText(birthday);
        studentGradeName.setText(gradeName);

        if( student.getGender() == 0 )
        {
            studentGender.setText("Nam");
        }
        else
        {
            studentGender.setText("Nữ");
        }
    }

    private void setEvent()
    {

        Student student = (Student) getIntent().getSerializableExtra("student");


        buttonDelete.setOnClickListener(view -> triggerPopupWindow(view, student));
        buttonUpdate.setOnClickListener(view -> {
            Intent intent = new Intent(ClassroomIndividualActivity.this, ClassroomUpdateActivity.class);
            intent.putExtra("updatedStudent",student );
            startActivity((intent));
        });
        buttonGoBack.setOnClickListener( view ->{
            finish();
        });
    }


    @SuppressLint("ClickableViewAccessibility")
    private void triggerPopupWindow(View view, Student student)
    {
        /*Step 1*/
        // khởi tạo alert
        Alert alert = new Alert(ClassroomIndividualActivity.this);


        /*Step 2*/
        alert.confirm();

        /*Step 3*/
        alert.showAlert(R.string.deleteStudent, R.drawable.info_icon);

        /*Step 6*/
        alert.btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassroomActivity.getmInstanceActivity().deleteStudent(student);
                finish();
            }
        });

        alert.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.dismiss();
            }
        });
    }



    public void updateStudent(Student student)
    {
        studentFamilyName.setText( student.getFamilyName() );
        studentFirstName.setText( student.getFirstName() );
        studentBirthday.setText( student.getBirthday() );
        studentGradeName.setText( student.getGradeName() );

        if( student.getGender() == 0 )
        {
            studentGender.setText("Nam");
        }
        else
        {
            studentGender.setText("Nữ");
        }
    }
}