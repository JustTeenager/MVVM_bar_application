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
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

public class DrinkViewPagerFragment extends Fragment {
    private static final String KEY_POSITION_TYPE_DRINK = "key_position_type_drink";

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
        FragmentDrinkViewPagerBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drink_view_pager,container,false);
        setUpViewPager(binding);
        return binding.getRoot();
    }

    private void setUpViewPager(FragmentDrinkViewPagerBinding binding) {
        int position = getArguments().getInt(KEY_POSITION_TYPE_DRINK);
        binding.drinkViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return CocktailListFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:{
                        return getActivity().getString(R.string.scotch);
                    }
                    case 1:{
                        return getActivity().getString(R.string.vodka);
                    }
                    case 2:{
                        return getActivity().getString(R.string.champagne);
                    }
                }
                return super.getPageTitle(position);
            }
        });
        binding.drinkViewPager.setCurrentItem(position);
        binding.typeDrinkTabLayout.setupWithViewPager(binding.drinkViewPager);
    }
}
