package com.example.mvvm_test_application.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.viewmodel.CocktailItemViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailViewModel;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

public class MainActivity extends AppCompatActivity implements DrinkTypeViewModel.Callback, CocktailViewModel.Callback, CocktailAdapter.Callback {

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

    @Override
    public void openWebSite(String url) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, CocktailWebView.newInstance(url))
                .addToBackStack(null).commit();
    }

    @Override
    public void openInformation() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CocktailFragment())
                .addToBackStack(null).commit();
    }
}