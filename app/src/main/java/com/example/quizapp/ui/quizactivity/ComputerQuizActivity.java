package com.example.quizapp.ui.quizactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizapp.R;
import com.example.quizapp.data.QuestionsItem;
import com.example.quizapp.databinding.ActivityComputerQuizBinding;
import com.example.quizapp.databinding.ActivityEnglishQuizBinding;
import com.example.quizapp.ui.resultactivity.ResultActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerQuizActivity extends AppCompatActivity {
    private ActivityComputerQuizBinding binding;
    List<QuestionsItem> questionsItems;
    int currentQuestions = 0;
    int correct =0, wrong= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityComputerQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        loadAllQuestions();
        Collections.shuffle(questionsItems);
        setQuestionScreen(currentQuestions);

        binding.aanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer1().equals(questionsItems.get(currentQuestions).getCorrect())) {
                    correct++;
                    binding.aanswer.setBackgroundResource(R.color.green);
                    binding.aanswer.setTextColor(getApplicationContext().getColor(R.color.white));
                }else {
                    wrong++;
                    binding.aanswer.setBackgroundResource(R.color.red);
                    binding.aanswer.setTextColor(getApplicationContext().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            binding.aanswer.setBackgroundResource(R.color.white);
                            binding.aanswer.setTextColor(getApplicationContext().getColor(R.color.text_secondery_color));

                        }
                    }, 500);
                }else {
                    Intent intent = new Intent(ComputerQuizActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        binding.banswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer2().equals(questionsItems.get(currentQuestions).getCorrect())) {
                    correct++;
                    binding.banswer.setBackgroundResource(R.color.green);
                    binding.banswer.setTextColor(getApplicationContext().getColor(R.color.white));
                }else {
                    wrong++;
                    binding.banswer.setBackgroundResource(R.color.red);
                    binding.banswer.setTextColor(getApplicationContext().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            binding.banswer.setBackgroundResource(R.color.white);
                            binding.banswer.setTextColor(getApplicationContext().getColor(R.color.text_secondery_color));

                        }
                    }, 500);
                }else {
                    Intent intent = new Intent(ComputerQuizActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        binding.canswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer3().equals(questionsItems.get(currentQuestions).getCorrect())) {
                    correct++;
                    binding.canswer.setBackgroundResource(R.color.green);
                    binding.canswer.setTextColor(getApplicationContext().getColor(R.color.white));
                }else {
                    wrong++;
                    binding.canswer.setBackgroundResource(R.color.red);
                    binding.canswer.setTextColor(getApplicationContext().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            binding.canswer.setBackgroundResource(R.color.white);
                            binding.canswer.setTextColor(getApplicationContext().getColor(R.color.text_secondery_color));

                        }
                    }, 500);
                }else {
                    Intent intent = new Intent(ComputerQuizActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        binding.danswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getAnswer4().equals(questionsItems.get(currentQuestions).getCorrect())) {
                    correct++;
                    binding.danswer.setBackgroundResource(R.color.green);
                    binding.danswer.setTextColor(getApplicationContext().getColor(R.color.white));
                }else {
                    wrong++;
                    binding.danswer.setBackgroundResource(R.color.red);
                    binding.danswer.setTextColor(getApplicationContext().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            binding.danswer.setBackgroundResource(R.color.white);
                            binding.danswer.setTextColor(getApplicationContext().getColor(R.color.text_secondery_color));

                        }
                    }, 500);
                }else {
                    Intent intent = new Intent(ComputerQuizActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int currentQuestions) {
        binding.quizText.setText(questionsItems.get(currentQuestions).getQuestions());
        binding.aanswer.setText(questionsItems.get(currentQuestions).getAnswer1());
        binding.banswer.setText(questionsItems.get(currentQuestions).getAnswer2());
        binding.canswer.setText(questionsItems.get(currentQuestions).getAnswer3());
        binding.danswer.setText(questionsItems.get(currentQuestions).getAnswer4());
    }

    private void loadAllQuestions() {
        questionsItems = new ArrayList<>();
        String jsonquiz = loadJsonFromAssets("computerquestion.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questions = jsonObject.getJSONArray("computerquestion");
            for (int i = 0; i <questions.length(); i++){
                JSONObject question = questions.getJSONObject(i);

                String questionsString = question.getString("question");
                String answer1String = question.getString("answer1");
                String answer2String = question.getString("answer2");
                String answer3String = question.getString("answer3");
                String answer4String = question.getString("answer4");
                String correctString = question.getString("correct");

                questionsItems.add(new QuestionsItem(questionsString, answer1String, answer2String, answer3String, answer4String, correctString));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    private String loadJsonFromAssets(String assetsName){
        String json = "";
        try{
            InputStream inputStream = getAssets().open(assetsName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
}