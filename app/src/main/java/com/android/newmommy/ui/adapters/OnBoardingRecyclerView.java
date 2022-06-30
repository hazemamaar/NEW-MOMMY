package com.android.newmommy.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.android.newmommy.R;
import com.android.newmommy.databinding.OnBoardingRowBinding;

import java.util.List;

public class OnBoardingRecyclerView extends RecyclerView.Adapter<OnBoardingRecyclerView.OnBoardingViewHolder> {

    Context context;

      int [] photoArray={
       R.drawable.photo1,
              R.drawable.photo2,
              R.drawable.photo3
      };
      int []descriptionArray={
              R.string.des_1,
              R.string.des_2,
              R.string.des_3
      };
      int[] titleArray={
              R.string.title_1,
              R.string.title_2,
              R.string.title_3
      };
    public OnBoardingRecyclerView(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new OnBoardingViewHolder(OnBoardingRowBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {
       holder.binding.imgBoarding.setImageResource(photoArray[position]);
       holder.binding.desc.setText(descriptionArray[position]);
       holder.binding.title.setText(titleArray[position]);
    }

    @Override
    public int getItemCount() {
        return photoArray.length;
    }

    class OnBoardingViewHolder extends RecyclerView.ViewHolder {

        OnBoardingRowBinding binding;
        public OnBoardingViewHolder(OnBoardingRowBinding binding) {
            super(binding.getRoot());
             this.binding=binding;
        }
    }
}
