package com.example.mvvm_test_application.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvvm_test_application.databinding.ItemCocktailBinding;
import com.example.mvvm_test_application.model.components.DaggerCocktailAdapterComponent;
import com.example.mvvm_test_application.model.components.DaggerCocktailHolderComponent;
import com.example.mvvm_test_application.model.dagger_models.BindingModule;
import com.example.mvvm_test_application.model.dagger_models.ContextAndCallbacksModule;
import com.example.mvvm_test_application.model.dagger_models.ViewModelsModule;
import com.example.mvvm_test_application.viewmodel.CocktailItemViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailDataViewModel;

import java.util.List;

import javax.inject.Inject;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.CocktailHolder> {
    private List<Cocktail> cocktails;
    @Inject
    ItemCocktailBinding bindable;
    @Inject
    Callback callback;

    public CocktailAdapter(List<Cocktail> cocktails){
        this.cocktails = cocktails;
    }

    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DaggerCocktailAdapterComponent.builder().bindingModule(new BindingModule(parent))
                .contextAndCallbacksModule(new ContextAndCallbacksModule((FragmentActivity) parent.getContext()))
                .build().inject(this);
        Log.d("tut", String.valueOf(bindable == null));
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
        CocktailItemViewModel model;
        @Inject
        CocktailDataViewModel controller;

        public CocktailHolder(ItemCocktailBinding binding) {
            super(binding.getRoot());
            //Log.d("tut_holder", binding.getActivity().toString());
            DaggerCocktailHolderComponent.builder().contextAndCallbacksModule(new ContextAndCallbacksModule((FragmentActivity) binding.getRoot().getContext()))
                    .build().inject(this);
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