package com.engsoft.robsonsouza.androidstudiosgc_puc.viewmodels;

import android.app.Application;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.engsoft.robsonsouza.androidstudiosgc_puc.services.UserLoginTask;
import com.engsoft.robsonsouza.androidstudiosgc_puc.viewmodels.interfaces.IMainActivityAccess;
import com.engsoft.robsonsouza.androidstudiosgc_puc.R;

public class MainActivityViewModel extends BaseObservable {

    // Private fields ---------------------------------------------------------

    private IMainActivityAccess access;

    public MainActivityViewModel(IMainActivityAccess access) {

        this.access = access;
    }

}
