package com.example.mvvm_test_application.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentCocktailBinding;
import com.example.mvvm_test_application.model.Cocktail;
import com.example.mvvm_test_application.utils.DownloaderService;
import com.example.mvvm_test_application.viewmodel.CocktailViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailDataViewModel;

import java.util.concurrent.ExecutionException;

public class CocktailFragment extends Fragment implements DownloaderService.ImageGetting {
    private FragmentCocktailBinding binding;
    private Callback mCallback;

    @Override
    public void getImage(final Drawable drawable) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                binding.photoCocktail.setImageDrawable(drawable);
            }
        });
    }

    public interface Callback{
        DownloaderService getService();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCallback= (Callback) context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cocktail, container, false);
        final CocktailViewModel model = new CocktailViewModel();
        CocktailDataViewModel controller = ViewModelProviders.of(getActivity()).get(CocktailDataViewModel.class);
        controller.getLiveData().observe(this, new Observer<Cocktail>() {
            @Override
            public void onChanged(Cocktail cocktail) {
                model.setCocktail(cocktail);
                try {
                    Log.d("loadImage","starting");
                    Log.d("imgURL:",cocktail.getUrlImage());
                    mCallback.getService().downloadImage(cocktail.getUrlImage(), (DownloaderService.UILoadingCommander) getActivity(),CocktailFragment.this);
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
                //Glide.with(CocktailFragment.this).load(cocktail.getUrlImage()).into(binding.photoCocktail);
            }
        });
        model.setCallback((CocktailViewModel.Callback) getActivity());
        binding.setViewModel(model);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCallback = null;
    }
}
