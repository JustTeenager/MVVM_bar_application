package com.example.mvvm_test_application.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentCocktailListBinding;
import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.model.components.DaggerCocktailListComponent;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.CocktailAdapterModule;
import com.example.mvvm_test_application.model.dagger_models.ContextAndCallbacksModule;
import com.example.mvvm_test_application.utils.RetrofitSingleton;

import javax.inject.Inject;

public class CocktailListFragment extends Fragment {

    private static final String KEY_POSITION_TYPE_DRINK = "key_position_type_drink";
    @Inject
    FragmentCocktailListBinding binding;
    @Inject
    CocktailAdapter adapter;

    public static CocktailListFragment newInstance(int position) {
        CocktailListFragment fragment = new CocktailListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_POSITION_TYPE_DRINK, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DaggerCocktailListComponent.builder().bindingModule(new BindingModule(container)).contextAndCallbacksModule(new ContextAndCallbacksModule(getActivity()))
                .cocktailAdapterModule(new CocktailAdapterModule(getArguments().getInt(KEY_POSITION_TYPE_DRINK)))
                .build().inject(this);
        Log.d("tut_holder", getActivity().toString());
        //binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cocktail_list, container, false);
        //position = getArguments().getInt(KEY_POSITION_TYPE_DRINK);
        generateAndSetupCocktailAdapter();
        return binding.getRoot();
    }

    private void generateAndSetupCocktailAdapter() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(adapter);
    }
}
