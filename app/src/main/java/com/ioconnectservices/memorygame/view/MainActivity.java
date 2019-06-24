package com.ioconnectservices.memorygame.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ioconnectservices.memorygame.R;
import com.ioconnectservices.memorygame.databinding.ActivityMainBinding;
import com.ioconnectservices.memorygame.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String GAME_TYPE = "type";

    private static final int GAME_TYPE_1 = 1;
    private static final int GAME_TYPE_2 = 2;
    private static final int GAME_TYPE_3 = 3;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        activityMainBinding.setMainViewModel(mainViewModel);
        setGameSelectedListener();
    }

    private void setGameSelectedListener() {
        mainViewModel.gameSelectedLiveData.observe(this, this::onBoardSizeSelected);
    }

    public void onBoardSizeSelected(int size) {
        Intent launchGameIntent = new Intent(MainActivity.this, GameActivity.class);
        switch (size) {
            case 0:
                launchGameIntent.putExtra(GAME_TYPE, GAME_TYPE_1);
                break;
            case 1:
                launchGameIntent.putExtra(GAME_TYPE, GAME_TYPE_2);
                break;
            case 2:
                launchGameIntent.putExtra(GAME_TYPE, GAME_TYPE_3);
                break;
        }
        startActivity(launchGameIntent);
    }
}
