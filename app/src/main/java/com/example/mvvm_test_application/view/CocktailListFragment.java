package com.example.mvvm_test_application.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.FragmentCocktailListBinding;
import com.example.mvvm_test_application.model.Cocktail;
import com.example.mvvm_test_application.model.CocktailAdapter;
import com.example.mvvm_test_application.viewmodel.CocktailListViewModel;

import java.util.ArrayList;
import java.util.List;

public class CocktailListFragment extends Fragment {

    private static final String KEY_POSITION_TYPE_DRINK = "key_position_type_drink";

    public static CocktailListFragment newInstance(int position){
        CocktailListFragment fragment = new CocktailListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_POSITION_TYPE_DRINK, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCocktailListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cocktail_list,container,false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Cocktail> list = generateCocktailList();
        binding.recyclerView.setAdapter(new CocktailAdapter(list,getActivity()));
        binding.setViewModel(new CocktailListViewModel());
        binding.getViewModel().setTitle(setUpCocktailName());
        return binding.getRoot();
    }

    //TODO фильтровать коктейли
    private List<Cocktail> generateCocktailList() {
        List<Cocktail> list=new ArrayList<>();
        list.add(new Cocktail("Blood Mary",40,"Водка и томатный сок",true,"vodka"));
        return list;
    }

    private String setUpCocktailName(){
        int position = getArguments().getInt(KEY_POSITION_TYPE_DRINK);
        switch (position){
            case 0:{
                return getActivity().getString(R.string.scotch);
            }
            case 1:{
                return getActivity().getString(R.string.vodka);
            }
            case 2:{
                return getActivity().getString(R.string.champagne);
            }
            default:
                return "неизвестно";
        }
    }
}
