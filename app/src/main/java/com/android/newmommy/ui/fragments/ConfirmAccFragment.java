package com.android.newmommy.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.newmommy.R;
import com.android.newmommy.databinding.FragmentConfirmAccBinding;
import com.android.newmommy.databinding.FragmentWeeksBinding;


public class ConfirmAccFragment extends Fragment {

FragmentConfirmAccBinding binding;
    public ConfirmAccFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConfirmAccBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}