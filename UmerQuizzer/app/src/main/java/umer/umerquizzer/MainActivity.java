package umer.umerquizzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Username,Password;
    Button teacherLogin,studentLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username=findViewById(R.id.userName);
        Password=findViewById(R.id.Password);

        teacherLogin=findViewById(R.id.TloginButton);
        studentLogin=findViewById(R.id.SloginButton);
    }

    public void Instructor_Login(View v){
        boolean check=true;
        if(Username.getText().toString().equals("")||Password.getText().toString().equals("")){

            Toast notEnoughData= Toast.makeText(MainActivity.this,"Empty fields!", Toast.LENGTH_SHORT);
            notEnoughData.show();
            check=false;
        }
        else if(Username.getText().toString().equals("UmerTeacher")||Password.getText().toString().equals("12345")){
            check=true;
            Toast valid=Toast.makeText(MainActivity.this,"Validated", Toast.LENGTH_SHORT);
            valid.show();
            Intent TeacherHome=new Intent(MainActivity.this,Teacher_Home.class);
            MainActivity.this.startActivity(TeacherHome);
        }

        else if(Username.getText().toString().equals("MinahilTeacher")||Password.getText().toString().equals("12345")){
            check=true;
            Toast valid=Toast.makeText(MainActivity.this,"Validated", Toast.LENGTH_SHORT);
            valid.show();

            Intent TeacherHome=new Intent(MainActivity.this,Teacher_Home.class);
            MainActivity.this.startActivity(TeacherHome);
        }

    }

    public void Student_Login(View v){
        boolean check=true;
        if(Username.getText().toString().equals("")||Password.getText().toString().equals("")){

            Toast notEnoughData= Toast.makeText(MainActivity.this,"Empty fields!", Toast.LENGTH_SHORT);
            notEnoughData.show();
            check=false;
        }
        else if(Username.getText().toString().equals("UmerStudent")||Password.getText().toString().equals("12345")){
            check=true;
            Toast valid=Toast.makeText(MainActivity.this,"Validated", Toast.LENGTH_SHORT);
            valid.show();
            Intent StudentHome=new Intent(MainActivity.this,Student_Home.class);
            MainActivity.this.startActivity(StudentHome);
        }

        else if(Username.getText().toString().equals("MinahilStudent")||Password.getText().toString().equals("12345")){
            check=true;
            Toast valid=Toast.makeText(MainActivity.this,"Validated", Toast.LENGTH_SHORT);
            valid.show();

            Intent StudentHome=new Intent(MainActivity.this,Teacher_Home.class);
            MainActivity.this.startActivity(StudentHome);
        }

    }
}
