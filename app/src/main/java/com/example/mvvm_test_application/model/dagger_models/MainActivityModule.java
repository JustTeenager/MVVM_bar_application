package com.example.mvvm_test_application.model.dagger_models;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.utils.DownloaderService;
import com.example.mvvm_test_application.view.DrinkTypeFragment;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextAndCallbacksModule.class)
public class MainActivityModule {

    private DownloaderService downloaderService = new DownloaderService();
    private ProgressDialog dialog;


    @Provides
    public ServiceConnection provideServiceConnection(final FragmentActivity activity){
        return new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("tut_downloader", "tut");
                downloaderService =((DownloaderService.DownloadBinder) service).getService();
                try {
                    downloaderService.downloadAllCocktails((DownloaderService.UILoadingCommander) activity);
                    Fragment fragment = activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                    if (fragment == null){
                        fragment = DrinkTypeFragment.newInstance();
                        activity.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    @Provides
    public DownloaderService provideDownloaderService(){
        return downloaderService;
    }

    @Provides
    public ProgressDialog provideProgressDialog(FragmentActivity context){
        dialog =new ProgressDialog(context);
        dialog.setTitle(context.getString(R.string.loading_title));
        dialog.setCancelable(false);
        return dialog;
    }
}
