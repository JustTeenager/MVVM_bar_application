package com.example.mvvm_test_application.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.utils.DownloaderService;
import com.example.mvvm_test_application.viewmodel.CocktailViewModel;
import com.example.mvvm_test_application.viewmodel.DrinkTypeViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements DrinkTypeViewModel.Callback, CocktailViewModel.Callback, CocktailAdapter.Callback,CocktailFragment.Callback, DownloaderService.UILoadingCommander {


    @Inject
    private DownloaderService downloaderService;
    @Inject
    private ProgressDialog progressDialog;

    @Inject
    private ServiceConnection connection;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        bindService(new Intent(this,DownloaderService.class),connection,BIND_AUTO_CREATE);
    }

    @Override
    public void onDrinkTypeClicked(int position) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,DrinkViewPagerFragment.newInstance(position))
                .addToBackStack(null).commit();
    }

    @Override
    public void openWebSite(String url) {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, CocktailWebView.newInstance(url))
                .addToBackStack(null).commit();
    }

    @Override
    public void openInformation() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CocktailFragment())
                .addToBackStack(null).commit();
    }

    @Override
    public void showDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.show();
            }
        });
    }

    @Override
    public void dismissDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void failDownloading() {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this, "Ошибка при загрузке,проверьте подключение к интернету", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    });

    }

    @Override
    public DownloaderService getDownloaderService() {
        return downloaderService;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
        downloaderService =null;
    }
}