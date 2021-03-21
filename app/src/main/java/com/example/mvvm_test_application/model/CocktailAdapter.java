package com.example.mvvm_test_application.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvvm_test_application.databinding.ItemCocktailBinding;
import com.example.mvvm_test_application.viewmodel.CocktailItemViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailDataViewModel;

import java.util.List;

import javax.inject.Inject;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.CocktailHolder> {
    private List<Cocktail> cocktails;
    @Inject
    private  ItemCocktailBinding bindable;
    @Inject
    private Callback callback;

    public CocktailAdapter(List<Cocktail> cocktails){
        this.cocktails = cocktails;
    }

    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // =DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_cocktail,parent,false);
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

    public class CocktailHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ItemCocktailBinding binding;
        private Cocktail cocktail;
        @Inject
        private CocktailItemViewModel model;
        @Inject
        private CocktailDataViewModel controller;

        public CocktailHolder(ItemCocktailBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
            this.binding.setViewModel(model);
            binding.itemClick.setOnClickListener(this);
        }

        private void bind(Cocktail cocktail){
            this.cocktail =cocktail;
            binding.getViewModel().setCocktail(this.cocktail);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            controller.setLiveData(cocktail);
            callback.openInformation();
        }
    }

    public interface Callback{
        void openInformation();
    }
}