package com.example.mvvm_test_application.model.dagger_models;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.view.CocktailListFragment;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextAndCallbacksModule.class)
public class FragmentPagerAdapterModule {

    private FragmentManager manager;

    public FragmentPagerAdapterModule(FragmentManager manager){
        this.manager=manager;
    }

    @Provides
    public FragmentPagerAdapter provideFragmentPagerAdapter(final FragmentActivity acivity) {
        return new FragmentPagerAdapter(manager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
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
                switch (position) {
                    case 0: {
                        return acivity.getString(R.string.scotch);
                    }
                    case 1: {
                        return acivity.getString(R.string.vodka);
                    }
                    case 2: {
                        return acivity.getString(R.string.champagne);
                    }
                }
                return super.getPageTitle(position);
            }
        };
    }
}
