package com.example.learnanimals;

public class QuestionLibrary {

    private String mQuestions [] = {
            "leu",
            "girafa",
            "caine",
            "leopard",
            "antilopa",
            "pisica"
    };

    private String mChoices [][] = {
            {"leu", "leopard", "tigru"},
            {"antilopa", "girafa", "zebra"},
            {"caine", "pisica", "hamster"},
            {"leu", "caine", "leopard"},
            {"pisica", "zebra", "antilopa"},
            {"hamster", "zebra", "pisica"}
    };

    public int GetQuestionCount(){
        return mQuestions.length;
    }

    public String GetQuestion(int index){
        return mQuestions[index];
    }

    public String GetChoice(int questionIndex, int index){
        return mChoices[questionIndex][index];
    }
}
