package com.ioconnectservices.memorygame.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<Integer> gameSelectedLiveData = new MutableLiveData<>();

    public void onGameTypeSelected(int type) {
        gameSelectedLiveData.setValue(type);
    }
}
