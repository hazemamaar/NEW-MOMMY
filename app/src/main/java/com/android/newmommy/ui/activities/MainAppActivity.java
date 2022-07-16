package com.android.newmommy.ui.activities;

import android.os.Bundle;

import com.android.newmommy.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.newmommy.databinding.ActivityMainAppBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainAppActivity extends AppCompatActivity {

    NavController navController;
    private NavHostFragment navHostFragment;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainAppBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainAppBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

        navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.frag_host_pro);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }

}