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

public class MainActivity extends AppCompatActivity implements DrinkTypeViewModel.Callback, CocktailViewModel.Callback, CocktailAdapter.Callback,CocktailFragment.Callback, DownloaderService.UILoadingCommander {

    private final ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService=((DownloaderService.DownloadBinder) service).getService();
            try {
                mService.downloadAllCocktails(MainActivity.this);
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if (fragment == null){
                    fragment = createFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private DownloaderService mService;
    private ProgressDialog mDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mDialog=new ProgressDialog(this);
        mDialog.setTitle(getString(R.string.loading_title));
        mDialog.setCancelable(false);
        bindService(new Intent(this,DownloaderService.class),mConnection,BIND_AUTO_CREATE);
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
                mDialog.show();
            }
        });
    }

    @Override
    public void dismissDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mDialog.dismiss();
            }
        });
    }

    @Override
    public void failDownloading() {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this, "Ошибка при загрузке,проверьте подключение к интернету", Toast.LENGTH_SHORT).show();
            mDialog.dismiss();
        }
    });

    }

    @Override
    public DownloaderService getService() {
        return mService;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
        mService=null;
    }
}