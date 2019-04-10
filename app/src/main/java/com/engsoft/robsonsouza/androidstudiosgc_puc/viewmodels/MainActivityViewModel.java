package com.engsoft.robsonsouza.androidstudiosgc_puc.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.engsoft.robsonsouza.androidstudiosgc_puc.viewmodels.interfaces.IMainActivityAccess;

public class MainActivityViewModel extends BaseObservable {

    // Private fields ---------------------------------------------------------

    private IMainActivityAccess access;

    public MainActivityViewModel(IMainActivityAccess access) {

        this.access = access;
    }
}
