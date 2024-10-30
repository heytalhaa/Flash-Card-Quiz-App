package com.example.quizapp.ui.mainactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityMainBinding;
import com.example.quizapp.ui.quizactivity.BasicQuizActivity;
import com.example.quizapp.ui.quizactivity.ComputerQuizActivity;
import com.example.quizapp.ui.quizactivity.DifficultQuizActivity;
import com.example.quizapp.ui.quizactivity.EnglishQuizActivity;
import com.example.quizapp.ui.quizactivity.HistoryQuizActivity;
import com.example.quizapp.ui.quizactivity.MathQuizActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.easyCard.setOnClickListener(view -> {
            startActivity(new Intent(this, BasicQuizActivity.class));
        });
        binding.difficultCard.setOnClickListener(view -> {
            startActivity(new Intent(this, DifficultQuizActivity.class));
        });
        binding.computerCard.setOnClickListener(view -> {
            startActivity(new Intent(this, ComputerQuizActivity.class));
        });
        binding.englishCard.setOnClickListener(view -> {
            startActivity(new Intent(this, EnglishQuizActivity.class));
        });
        binding.mathCard.setOnClickListener(view -> {
            startActivity(new Intent(this, MathQuizActivity.class));
        });
        binding.historyCard.setOnClickListener(view -> {
            startActivity(new Intent(this, HistoryQuizActivity.class));
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}