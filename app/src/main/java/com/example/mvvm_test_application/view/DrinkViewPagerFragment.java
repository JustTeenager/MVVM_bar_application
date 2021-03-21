package com.example.mvvm_test_application.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentDrinkViewPagerBinding;
import com.example.mvvm_test_application.model.components.DaggerDrinkViewPagerComponent;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.ContextAndCallbacksModule;
import com.example.mvvm_test_application.model.dagger_models.FragmentPagerAdapterModule;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

import javax.inject.Inject;


public class DrinkViewPagerFragment extends Fragment {
    private static final String KEY_POSITION_TYPE_DRINK = "key_position_type_drink";

    @Inject
    FragmentDrinkViewPagerBinding binding;
    @Inject
    FragmentPagerAdapter adapter;

    public static DrinkViewPagerFragment newInstance(int position){
        DrinkViewPagerFragment drinkViewPagerFragment = new DrinkViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_POSITION_TYPE_DRINK, position);
        drinkViewPagerFragment.setArguments(bundle);
        return drinkViewPagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drink_view_pager,container,false);
        DaggerDrinkViewPagerComponent.builder().bindingModule(new BindingModule(container)).contextAndCallbacksModule(new ContextAndCallbacksModule(getActivity()))
                .fragmentPagerAdapterModule(new FragmentPagerAdapterModule(getFragmentManager())).build().inject(this);
        setUpViewPager();
        return binding.getRoot();
    }

    private void setUpViewPager() {
        int position = getArguments().getInt(KEY_POSITION_TYPE_DRINK);
        binding.drinkViewPager.setAdapter(adapter);
        binding.drinkViewPager.setCurrentItem(position);
        binding.typeDrinkTabLayout.setupWithViewPager(binding.drinkViewPager);
    }
}
