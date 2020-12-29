package com.example.mvvm_test_application.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

public class MainActivity extends AppCompatActivity implements DrinkTypeViewModel.Callback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = createFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }

    public Fragment createFragment(){
        return DrinkTypeFragment.newInstance();
    }

    @Override
    public void onDrinkTypeClicked(int position) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,DrinkViewPagerFragment.newInstance(position))
                .addToBackStack(null).commit();
    }
}