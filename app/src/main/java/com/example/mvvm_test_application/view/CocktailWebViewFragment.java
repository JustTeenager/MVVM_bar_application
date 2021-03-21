package com.example.mvvm_test_application.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvvm_test_application.databinding.FragmentCocktailWebViewBinding;
import com.example.mvvm_test_application.model.components.DaggerFragmentWebViewComponent;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.ContextAndCallbacksModule;

import javax.inject.Inject;

public class CocktailWebViewFragment extends Fragment {

    private static final String KEY_URL = "key_url";

    @Inject
    FragmentCocktailWebViewBinding binding;

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cocktail_web_view,container,false);
        DaggerFragmentWebViewComponent.builder().bindingModule(new BindingModule(container)).contextAndCallbacksModule(new ContextAndCallbacksModule(getActivity()))
                .build().inject(this);
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(getArguments().getString(KEY_URL));
        return binding.getRoot();
    }

    public static Fragment newInstance(String url){
        Bundle bundle = new Bundle();
        CocktailWebViewFragment fragment = new CocktailWebViewFragment();
        bundle.putString(KEY_URL, url);
        fragment.setArguments(bundle);
        return fragment;
    }
}
