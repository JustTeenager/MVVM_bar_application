package com.example.mvvm_test_application.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_test_application.R;
import com.example.mvvm_test_application.databinding.ItemCocktailBinding;
import com.example.mvvm_test_application.view.MainActivity;
import com.example.mvvm_test_application.viewmodel.CocktailItemViewModel;
import com.example.mvvm_test_application.viewmodel.CocktailDataViewModel;

import java.util.List;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.CocktailHolder> {
    private List<Cocktail> cocktails;
    private FragmentActivity activity;
    private Callback callback;

    public CocktailAdapter(List<Cocktail> cocktails, FragmentActivity activity){
        this.activity =activity;
        this.cocktails = cocktails;
        callback = (Callback) activity;
    }

    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCocktailBinding bindable=DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_cocktail,parent,false);
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

        private ItemCocktailBinding  mBinding;
        private Cocktail mCocktail;

        public CocktailHolder(ItemCocktailBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
            mBinding.setViewModel(new CocktailItemViewModel());
            binding.itemClick.setOnClickListener(this);
        }

        private void bind(Cocktail cocktail){
            this.mCocktail=cocktail;
            mBinding.getViewModel().setCocktail(mCocktail);
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            CocktailDataViewModel controller = ViewModelProviders.of(activity).get(CocktailDataViewModel.class);
            controller.setLiveData(mCocktail);
            callback.openInformation();
        }
    }

    public interface Callback{
        void openInformation();
    }
}
