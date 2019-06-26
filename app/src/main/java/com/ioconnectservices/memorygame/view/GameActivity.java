package com.ioconnectservices.memorygame.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ioconnectservices.memorygame.R;
import com.ioconnectservices.memorygame.databinding.ActivityGame1Binding;
import com.ioconnectservices.memorygame.databinding.ActivityGame2Binding;
import com.ioconnectservices.memorygame.databinding.ActivityGame3Binding;
import com.ioconnectservices.memorygame.viewmodel.GameViewModel;

public class GameActivity extends AppCompatActivity {

    private static final String GAME_TYPE = "type";

    private GameViewModel gameViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int gameType = getIntent().getIntExtra(GAME_TYPE, 1);
        ActivityGame1Binding activityGame1Binding;
        ActivityGame2Binding activityGame2Binding;
        ActivityGame3Binding activityGame3Binding;
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        switch (gameType) {
            case 1:
                activityGame1Binding = DataBindingUtil.setContentView(this, R.layout.activity_game_1);
                gameViewModel.init(4, 3);
                activityGame1Binding.setGameViewModel(gameViewModel);
                break;
            case 2:
                activityGame2Binding = DataBindingUtil.setContentView(this, R.layout.activity_game_2);
                gameViewModel.init(4, 4);
                activityGame2Binding.setGameViewModel(gameViewModel);
                break;
            case 3:
                activityGame3Binding = DataBindingUtil.setContentView(this, R.layout.activity_game_3);
                gameViewModel.init(4, 5);
                activityGame3Binding.setGameViewModel(gameViewModel);
                break;
        }
        setGameEndedListener();
    }

    private void setGameEndedListener() {
        gameViewModel.hasGameEnded().observe(this, this::onGameEnded);
    }

    public void onGameEnded(boolean value) {
        runOnUiThread(() -> Toast.makeText(GameActivity.this, getResources().getText(R.string.game_ended_text), Toast.LENGTH_SHORT).show());
    }
}
