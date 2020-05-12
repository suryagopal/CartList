package com.example.recyclerViewSample.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.recyclerViewSample.R;
import com.example.recyclerViewSample.databinding.ActivityList2Binding;

public class ListActivity2 extends AppCompatActivity {
    ListActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        viewModel = ViewModelProviders.of(this).get(ListActivityViewModel.class);
        viewModel.init(this);
        ActivityList2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_list2);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();

    }
}
