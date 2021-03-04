package com.project.AutoDeelsoftwareproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.AutoDeelsoftwareproject.R;

public class UsedCarFragment extends Fragment {

    private UsedCarViewModel usedCarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        usedCarViewModel =
                new ViewModelProvider(this).get(UsedCarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_usedcar, container, false);

        return root;
    }
}