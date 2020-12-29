package com.example.mvvm_test_application.model;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.CocktailHolder> {
    private List<Cocktail> cocktails;

    public CocktailAdapter(List<Cocktail> cocktails){
        this.cocktails = cocktails;
    }

    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CocktailHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return cocktails.size();
    }

    public class CocktailHolder extends RecyclerView.ViewHolder{
        public CocktailHolder(@NonNull View itemView) {
            super(itemView);
        }


    }
}
