package com.android.newmommy.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.newmommy.R;
import com.android.newmommy.databinding.FragmentOnBoardingScreenBinding;
import com.android.newmommy.ui.adapters.OnBoardingRecyclerView;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;


public class OnBoardingScreenFragment extends Fragment {


     FragmentOnBoardingScreenBinding binding;
     OnBoardingRecyclerView onBoardingRecyclerView;
    public OnBoardingScreenFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initIndicator();
        initViewPagger();
        viewPagger2Scroll();
        binding.nextTxt.setOnClickListener(v -> {
            if (binding.nextTxt.getText().equals("Next"))
            binding.viewpaggersplash.setCurrentItem(binding.viewpaggersplash.getCurrentItem() + 1);
            else
                Navigation.findNavController(view).navigate(R.id.action_onBoardingScreen_to_signUpFragment);
        });

        binding.skipTxt.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_onBoardingScreen_to_signUpFragment));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentOnBoardingScreenBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
   void initViewPagger(){
        onBoardingRecyclerView=new OnBoardingRecyclerView(getContext());
        binding.viewpaggersplash.setAdapter(onBoardingRecyclerView);
   }

    @SuppressLint("ResourceAsColor")
    void initIndicator(){
        binding.indictor.setSliderColor(R.color.gray, R.color.white);
        binding.indictor.setSliderWidth(40F);
        binding.indictor.setSliderHeight(10f);
        binding.indictor.setSlideMode(IndicatorSlideMode.WORM);
        binding.indictor.setIndicatorStyle(IndicatorStyle.ROUND_RECT);
        binding.indictor.setPageSize(3);
        binding.indictor.notifyDataChanged();
    }
    void viewPagger2Scroll(){
        binding.viewpaggersplash.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                binding.indictor.onPageScrolled(position,positionOffset,positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position ==2 ){
                    binding.nextTxt.setText("Get Start");
                }else{
                    binding.nextTxt.setText("Next");
                }
                binding.indictor.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}