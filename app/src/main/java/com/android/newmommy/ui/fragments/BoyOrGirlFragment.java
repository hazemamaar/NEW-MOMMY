package com.android.newmommy.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.newmommy.R;
import com.android.newmommy.databinding.FragmentBoyOrGirlBinding;
import com.android.newmommy.databinding.FragmentWeeksBinding;

public class BoyOrGirlFragment extends Fragment {

    FragmentBoyOrGirlBinding binding;
    public BoyOrGirlFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.action_boyOrGirlFragment_to_yourBoyNameFragment);
            }
        });
        binding.btnGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.action_boyOrGirlFragment_to_yourGirlNameFragment);
            }
        });
        binding.headOfApp.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).popBackStack();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoyOrGirlBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}