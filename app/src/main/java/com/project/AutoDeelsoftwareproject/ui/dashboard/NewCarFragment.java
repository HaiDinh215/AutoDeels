package com.project.AutoDeelsoftwareproject.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.AutoDeelsoftwareproject.R;

public class NewCarFragment extends Fragment {

    private NewCarViewModel newCarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newCarViewModel =
                new ViewModelProvider(this).get(NewCarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_newcar, container, false);

        return root;
    }
}