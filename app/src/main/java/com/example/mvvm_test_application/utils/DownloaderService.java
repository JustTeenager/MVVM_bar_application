package com.example.mvvm_test_application.utils;

import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.example.mvvm_test_application.model.Cocktail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;

public class DownloaderService extends Service {

    @Inject
     private  ExecutorService mService;
    @Inject
     private RetrofitSingleton retrofitSingleton;

    public class DownloadBinder extends Binder{
        private final DownloaderService service;
        public DownloadBinder(DownloaderService service){
            this.service=service;
        }
        public DownloaderService getService(){return service;}
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public interface UILoadingCommander {
        void showDialog();
        void dismissDialog();
        void failDownloading();
    }

    public interface ImageGetting{
        void getImage(Drawable drawable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mService.shutdown();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new DownloadBinder(this);
    }

    public void downloadAllCocktails(final UILoadingCommander commander) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                commander.showDialog();
                Future<List<Cocktail>> future=mService.submit(new Callable<List<Cocktail>>() {
                    @Override
                    public List<Cocktail> call() {
                        try {
                            List<Cocktail> list=retrofitSingleton.getCocktailsApi().getCocktails().execute().body();
                            commander.dismissDialog();
                            return list;
                        } catch (IOException e) {
                            e.printStackTrace();
                            commander.failDownloading();
                        }
                        return new ArrayList<>();
                    }
                });
                try {
                    RetrofitSingleton.setCocktailsList(future.get());
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                    commander.failDownloading();
                }
            }
        }).start();
    }

    public void downloadImage(final String url, final UILoadingCommander commander, final ImageGetting getting) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                commander.showDialog();
                Future<Drawable> future = mService.submit(new Callable<Drawable>() {
                    @Override
                    public Drawable call() throws Exception {
                        return Glide.with(getBaseContext()).asDrawable().load(url).submit().get();
                    }
                });
                try {
                    getting.getImage(future.get());
                    commander.dismissDialog();
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                    commander.failDownloading();
                }
            }
        }).start();
    }
}
