package com.example.mvvm_test_application.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentCocktailWebViewBinding;

public class CocktailWebView extends Fragment {

    private WebView webView;
    private static final String KEY_URL = "key_url";

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCocktailWebViewBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cocktail_web_view,container,false);
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(getArguments().getString(KEY_URL));
        return binding.getRoot();
    }

    public static Fragment newInstance(String url){
        Bundle bundle = new Bundle();
        CocktailWebView fragment = new CocktailWebView();
        bundle.putString(KEY_URL, url);
        fragment.setArguments(bundle);
        return fragment;
    }
}
