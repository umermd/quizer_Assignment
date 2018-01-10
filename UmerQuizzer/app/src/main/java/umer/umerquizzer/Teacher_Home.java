package umer.umerquizzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Teacher_Home extends AppCompatActivity {

    Button cQuiz,vQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__home);

        cQuiz=findViewById(R.id.cQuiz);
        vQuiz=findViewById(R.id.vQuiz);

    }

    public void createQuiz(View v){
        boolean check=true;


            Toast notEnoughData= Toast.makeText(Teacher_Home.this,"That's all folks", Toast.LENGTH_SHORT);
            notEnoughData.show();


    }
    public void viewQuiz(View v){
        boolean check=true;


        Toast notEnoughData= Toast.makeText(Teacher_Home.this,"That's all folks", Toast.LENGTH_SHORT);
        notEnoughData.show();


    }
}
