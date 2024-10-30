package com.example.quizapp.ui.resultactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityResultBinding;
import com.example.quizapp.ui.mainactivity.MainActivity;

public class ResultActivity extends AppCompatActivity {
    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int correct = getIntent().getIntExtra("correct", 0);
        int wrong = getIntent().getIntExtra("wrong", 0);
        int score = correct * 5;

        binding.correctScore.setText(""+ correct);
        binding.wrongScore.setText(""+ wrong);
        binding.resultScore.setText(""+ score);

        if (correct >= 0 && correct <= 2) {
            binding.resultInfo.setText("You have to take the test again");
            binding.resultImage.setImageResource(R.drawable.round_sentiment_dissatisfied_24);
        } else if (correct >= 3 && correct <= 5) {
            binding.resultInfo.setText("You have to try a little more");
            binding.resultImage.setImageResource(R.drawable.round_sentiment_neutral_24);
        } else if (correct >= 6 && correct <= 8) {
            binding.resultInfo.setText("You are pretty good");
            binding.resultImage.setImageResource(R.drawable.round_sentiment_satisfied_24);
        } else {
            binding.resultInfo.setText("You are very good congratulations");
            binding.resultImage.setImageResource(R.drawable.round_sentiment_satisfied_24);
        }

        binding.returnHome.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}