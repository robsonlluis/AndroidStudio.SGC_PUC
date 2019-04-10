package com.engsoft.robsonsouza.androidstudiosgc_puc.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.engsoft.robsonsouza.androidstudiosgc_puc.R;
import com.engsoft.robsonsouza.androidstudiosgc_puc.databinding.ActivityMainBinding;
import com.engsoft.robsonsouza.androidstudiosgc_puc.viewmodels.MainActivityViewModel;
import com.engsoft.robsonsouza.androidstudiosgc_puc.viewmodels.interfaces.IMainActivityAccess;

public class MainActivity extends AppCompatActivity implements IMainActivityAccess {

    // Private fields ---------------------------------------------------------

    private ActivityMainBinding binding;

    private MainActivityViewModel viewModel;

    // Protected methods ------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new MainActivityViewModel(this);
        binding.setViewModel(viewModel);
    }
}