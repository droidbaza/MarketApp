package com.droidbaza.market.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.droidbaza.market.adapters.CategoryAdapter;

import com.droidbaza.market.Contract;
import com.droidbaza.market.R;
import com.droidbaza.market.pojo.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by droidbaza on 25/11/19.
 */


public class CategoryFragment extends Fragment implements Contract.CategoryListener {


    private List<Category> cts = new ArrayList<>();

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        RecyclerView rv = v.findViewById(R.id.recyclerviewCategory);
        CategoryAdapter adapter = new CategoryAdapter(cts, getContext(), this);
        GridLayoutManager lm = new GridLayoutManager(getContext(), 2);

        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        getData();


    }

    private void getData() {

        cts.add(new Category(1, "All Cell Phones with Plans", R.drawable.cellphones,
                "((categoryPath.id=pcmcat209400050001))"));
        cts.add(new Category(2, "Desktop & All-in-One Computers", R.drawable.computers,
                "((categoryPath.id=abcat0501000))"));

        cts.add(new Category(3, "Digital Cameras", R.drawable.cameras,
                "((categoryPath.id=abcat0401000))"));
        cts.add(new Category(4, "Health,Fitness & Beauty", R.drawable.fitnes,
                "((categoryPath.id=pcmcat242800050021))"));

        cts.add(new Category(5, "Headphones", R.drawable.headphones,
                "((categoryPath.id=abcat0204000))"));
        cts.add(new Category(6, "Home Audio", R.drawable.home_audio,
                "((categoryPath.id=pcmcat241600050001))"));

        cts.add(new Category(7, "Home Automation & Security", R.drawable.security,
                "((categoryPath.id=pcmcat254000050002))"));
        cts.add(new Category(8, "IPad,Tablets & E-Readers", R.drawable.ipad,
                "((categoryPath.id=pcmcat209000050006))"));

        cts.add(new Category(9, "Laptops", R.drawable.laptop,
                "((categoryPath.id=abcat0502000))"));
        cts.add(new Category(10, "Nintendo 3DS", R.drawable.nintendo,
                "((categoryPath.id=pcmcat232900050000))"));

        cts.add(new Category(11, "PlayStation 4", R.drawable.ps,
                "((categoryPath.id=pcmcat295700050012))"));
        cts.add(new Category(12, "Portable & Wireles Speakers", R.drawable.wifi,
                "((categoryPath.id=pcmcat310200050004))"));

        cts.add(new Category(13, "PS Vita", R.drawable.vita,
                "((categoryPath.id=pcmcat243400050029))"));
        cts.add(new Category(14, "Ranges, Cooktops & Ovens", R.drawable.cooktop,
                "((categoryPath.id=abcat0904000))"));

        cts.add(new Category(15, "Refrigerators", R.drawable.refri,
                "((categoryPath.id=abcat0901000))"));
        cts.add(new Category(16, "Small Kitchen Appliances", R.drawable.kitchen,
                "((categoryPath.id=abcat0912000))"));

        cts.add(new Category(17, "TVs", R.drawable.tvs,
                "((categoryPath.id=abcat0101000))"));
        cts.add(new Category(18, "Washers & Dryers", R.drawable.dryers,
                "((categoryPath.id=abcat0910000))"));

        cts.add(new Category(19, "Wii U", R.drawable.wii,
                "((categoryPath.id=pcmcat273800050036))"));

    }

    @Override
    public void onCategoryClicked(Category category) {

        String args = category.getAttribute();

        CatalogFragment fragment = new CatalogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", args);
        fragment.setArguments(bundle);

        Objects.requireNonNull(getActivity())
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.cont, fragment)
                .addToBackStack(null)
                .commit();

    }
}
