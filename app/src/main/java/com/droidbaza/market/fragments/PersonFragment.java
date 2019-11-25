package com.droidbaza.market.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidbaza.market.R;

/**
 * Created by droidbaza on 25/11/19.
 */


public class PersonFragment extends Fragment {


    public static PersonFragment newInstance() {
        return new PersonFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_person, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {


    }
}
