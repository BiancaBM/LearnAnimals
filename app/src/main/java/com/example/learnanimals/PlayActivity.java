package com.example.learnanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Field;

public class PlayActivity extends AppCompatActivity {

    public QuestionLibrary questionLibrary = new QuestionLibrary();
    private TextView scoreView;
    private TextView questionView;
    private ImageButton choiceImage1;
    private ImageButton choiceImage2;
    private ImageButton choiceImage3;

    private int score = 0;
    private int questionIndex = -1;
    private int questionCount = questionLibrary.GetQuestionCount();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        scoreView = findViewById(R.id.resultView);
        questionView = findViewById(R.id.questionView);

        choiceImage1 = findViewById(R.id.choice1);
        choiceImage2 = findViewById(R.id.choice2);
        choiceImage3 = findViewById(R.id.choice3);

        updateQuestion();

        choiceImage1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(isTheEndOfGame())  {
                    finish();
                    return;
                }

                String question = questionLibrary.GetQuestion(questionIndex);
                if(question == questionLibrary.GetChoice(questionIndex,0)){
                    updateScore();
                }

                updateQuestion();
            }
        });

        choiceImage2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(isTheEndOfGame()){
                    finish();
                    return;
                }

                String question = questionLibrary.GetQuestion(questionIndex);
                if(question == questionLibrary.GetChoice(questionIndex,1)){
                    updateScore();
                }

                updateQuestion();
            }
        });

        choiceImage3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(isTheEndOfGame())  {
                    finish();
                    return;
                }

                String question = questionLibrary.GetQuestion(questionIndex);
                if(question == questionLibrary.GetChoice(questionIndex,2)){
                    updateScore();
                }

                updateQuestion();
            }
        });
    }

    private boolean isTheEndOfGame() {
        if(questionIndex  >= questionCount - 1) {
            Intent result = new Intent(this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            result.putExtras(b);
            startActivity(result);

            return true;
        }

        return false;
    }

    private void updateScore() {
        score = score + 1;
        scoreView.setText("Score: " + score);
    }

    private void updateQuestion(){
        questionIndex = questionIndex + 1;

        String question = questionLibrary.GetQuestion(questionIndex);
        questionView.setText(question);

        String choice1 = questionLibrary.GetChoice(questionIndex, 0);
        String choice2 = questionLibrary.GetChoice(questionIndex, 1);
        String choice3 = questionLibrary.GetChoice(questionIndex, 2);

        int choiceId1 = getResId(choice1, R.mipmap.class);
        int choiceId2 = getResId(choice2, R.mipmap.class);
        int choiceId3 = getResId(choice3, R.mipmap.class);

        choiceImage1.setImageResource(choiceId1);
        choiceImage2.setImageResource(choiceId2);
        choiceImage3.setImageResource(choiceId3);
    }

    private int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
