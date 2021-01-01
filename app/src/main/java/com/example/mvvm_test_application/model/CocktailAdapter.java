package com.example.mvvm_test_application.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.ItemCocktailBinding;
import com.example.mvvm_test_application.viewmodel.CocktailItemViewModel;

import java.util.List;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.CocktailHolder> {
    private List<Cocktail> cocktails;
    private Context mContext;

    public CocktailAdapter(List<Cocktail> cocktails,Context context){
        this.mContext=context;
        this.cocktails = cocktails;
    }

    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCocktailBinding bindable=DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_cocktail,parent,false);
        return new CocktailHolder(bindable);
    }

    @Override
    public void onBindViewHolder(@NonNull CocktailHolder holder, int position) {
        holder.bind(cocktails.get(position));
    }

    @Override
    public int getItemCount() {
        return cocktails.size();
    }

    public class CocktailHolder extends RecyclerView.ViewHolder{

        private ItemCocktailBinding  mBinding;
        private Cocktail mCocktail;

        public CocktailHolder(ItemCocktailBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
            mBinding.setViewModel(new CocktailItemViewModel());
        }

        private void bind(Cocktail cocktail){
            this.mCocktail=cocktail;
            mBinding.getViewModel().setCocktail(mCocktail);
            mBinding.executePendingBindings();
        }

    }
}
