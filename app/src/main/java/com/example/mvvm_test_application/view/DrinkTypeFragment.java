package com.example.mvvm_test_application.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentDrinkTypeBinding;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

public class DrinkTypeFragment extends Fragment {

    public static DrinkTypeFragment newInstance(){
        return new DrinkTypeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final FragmentDrinkTypeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drink_type,container,false);
        binding.setViewModel(new DrinkTypeViewModel((DrinkTypeViewModel.Callback) getActivity()));
        return binding.getRoot();
    }


}
