package com.example.responsi_123180020.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi_123180020.R;
import com.example.responsi_123180020.adapter.DataAdapter;
import com.example.responsi_123180020.model.datakasus.ContentItem;
import com.example.responsi_123180020.view.viewmodel.CovidViewModel;

import java.util.Collections;
import java.util.List;


public class DataFragment extends Fragment {

    private DataAdapter dataAdapter;
    private RecyclerView rv_datakasus;
    private CovidViewModel covidViewModel;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataAdapter = new DataAdapter(getContext());
        dataAdapter.notifyDataSetChanged();

        rv_datakasus = view.findViewById(R.id.rv_datakasus);
        rv_datakasus.setLayoutManager(new LinearLayoutManager(getContext()));

        covidViewModel = new ViewModelProvider(this).get(CovidViewModel.class);
        covidViewModel.setCovid();
        covidViewModel.getKasus().observe(getViewLifecycleOwner(),getKasus);

        rv_datakasus.setAdapter(dataAdapter);
    }
    private Observer<List<ContentItem>> getKasus = new Observer<List<ContentItem>>() {
        @Override
        public void onChanged(List<ContentItem> kasusCovidItem) {
            if (kasusCovidItem != null){
                Collections.reverse(kasusCovidItem);
                dataAdapter.setData(kasusCovidItem);
            }
        }
    };
}