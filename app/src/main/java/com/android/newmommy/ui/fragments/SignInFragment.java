package com.android.newmommy.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.newmommy.R;
import com.android.newmommy.databinding.FragmentSignInBinding;
import com.android.newmommy.model.UserInfo;
import com.android.newmommy.ui.viewmodel.SignInViewModel;
import com.android.newmommy.ui.viewmodel.SignUpViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SignInFragment extends Fragment {
    SignInViewModel signInViewModel;
    FragmentSignInBinding binding;
    UserInfo userInfo;
    public SignInFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signInViewModel=   new ViewModelProvider(this).get(SignInViewModel .class);
        binding.btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.inputTextEmail.getText().toString(),
                        password=binding.inputTextPassowrd.getText().toString();
               userInfo =new UserInfo(email,password);
               signInViewModel.login(userInfo);
                Navigation.findNavController(getView()).navigate(R.id.action_signInFragment_to_mainAppActivity);
            }
        });
        signInViewModel.userInfoLiveData.observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    Navigation.findNavController(getView()).navigate(R.id.action_signInFragment_to_mainAppActivity);
                    Toast.makeText(getContext(), "Done SignIn", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.action_signInFragment_to_signUpFragment2);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding =FragmentSignInBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}