package com.project.AutoDeelsoftwareproject.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UsedCarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UsedCarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}