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
import com.android.newmommy.databinding.FragmentSignUpBinding;
import com.android.newmommy.model.UserInfo;
import com.android.newmommy.ui.viewmodel.SignUpViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SignUpFragment extends Fragment {

    FragmentSignUpBinding binding;
    SignUpViewModel signUpViewModel;
    UserInfo userInfo;
    public SignUpFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signUpViewModel=   new ViewModelProvider(this).get(SignUpViewModel.class);

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.inputTextEmail.getText().toString(),
                        password=binding.inputTextPassowrd.getText().toString(),
                        username=binding.inputTextUserName.getText().toString(),
                        mobile=binding.inputTextMobilePhone.getText().toString(),
                        dateOfBirth="1997-07-28",
                        dateOfPregenance=binding.inputTextPregDate.getText().toString();
                userInfo =new UserInfo(email, password, username, mobile, dateOfBirth, dateOfPregenance);
                signUpViewModel.register(userInfo);
                Navigation.findNavController(getView()).navigate(R.id.action_signUpFragment_to_signInFragment);

            }
        });

          signUpViewModel.userInfoLiveData.observe(getActivity(), new Observer<Boolean>() {
              @Override
              public void onChanged(Boolean aBoolean) {
                  if(aBoolean){
                      Navigation.findNavController(getView()).navigate(R.id.action_signUpFragment_to_signInFragment);
                  }
              }
          });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentSignUpBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}