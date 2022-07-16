package com.android.newmommy.ui.fragments;

import static androidx.navigation.Navigation.findNavController;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.newmommy.R;
import com.android.newmommy.databinding.FragmentWeeksBinding;
import com.android.newmommy.ui.viewmodel.WeeksViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class WeeksFragment extends Fragment {
    int t;
    WeeksViewModel weeksViewModel;
    FragmentWeeksBinding binding;
    List<String> stringsList;
    public WeeksFragment() {

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        weeksViewModel.liveData.observe(getActivity(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                stringsList=strings;

            }
        });
        String str=binding.inputTextLayoutNum.getText().toString();
        try{
            t = Integer.parseInt(str);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stringsList.size()>0){
                   String stringWeek=stringsList.get(t);
                    NavDirections action = WeeksFragmentDirections.actionWeeksFragmentToShowDataFragment(stringWeek);
                    Navigation.findNavController(getView()).navigate(action);

                }

//                WeeksFragmentD.ActionHomeFragToShowCompleteProduct action =
//                ProductFragmentDirections.actionHomeFragToShowCompleteProduct(productModel);
//                findNavController(getView()).navigate((NavDirections) action);
            }
        });


       binding.plus.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if(t<33)
                t++;
             else
                 Toast.makeText(getContext(), "Can't Increment", Toast.LENGTH_SHORT).show();
             binding.inputTextLayoutNum.setText(String.valueOf(t));
         }
     });
       binding.min.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(t>1) {
                   t--;
               }else{
                   Toast.makeText(getContext(), "Can't Decrement", Toast.LENGTH_SHORT).show();
               }
               binding.inputTextLayoutNum.setText(String.valueOf(t));
           }
       });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentWeeksBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    void initViewModel(){
        weeksViewModel= new ViewModelProvider(this).get(WeeksViewModel.class);
        weeksViewModel.getWeeks();
    }
}