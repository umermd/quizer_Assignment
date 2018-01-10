package umer.umerquizzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Student_Home extends AppCompatActivity {

    Button attQuiz,Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        attQuiz=findViewById(R.id.attQuiz);
        Score=findViewById(R.id.Score);
    }

    public void attemptQuiz(View v){
        boolean check=true;


        Toast notEnoughData= Toast.makeText(Student_Home.this,"That's all folks", Toast.LENGTH_SHORT);
        notEnoughData.show();


    }
    public void Score(View v){
        boolean check=true;


        Toast notEnoughData= Toast.makeText(Student_Home.this,"That's all folks", Toast.LENGTH_SHORT);
        notEnoughData.show();


    }
}
