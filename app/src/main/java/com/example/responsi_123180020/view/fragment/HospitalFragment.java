package com.example.responsi_123180020.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi_123180020.R;
import com.example.responsi_123180020.adapter.RsAdapter;
import com.example.responsi_123180020.model.rsrujukan.DataItem;
import com.example.responsi_123180020.view.viewmodel.CovidViewModel;

import java.util.List;


public class HospitalFragment extends Fragment {

    private RsAdapter rsAdapter;
    private RecyclerView rv_Rsrujukan;
    private CovidViewModel covidViewModel;

    public HospitalFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view,  Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        rsAdapter = new RsAdapter (getContext());
        rsAdapter.notifyDataSetChanged();

        rv_Rsrujukan = view.findViewById(R.id.rv_rsrujukan);
        rv_Rsrujukan.setLayoutManager(new LinearLayoutManager(getContext()));

        covidViewModel = new ViewModelProvider(this).get(CovidViewModel.class);
        covidViewModel.setRsrujukan();
        covidViewModel.getData().observe(getViewLifecycleOwner(),getRs);

        rv_Rsrujukan.setAdapter(rsAdapter);
    }
    private Observer<List<DataItem>> getRs = new Observer<List<DataItem>>() {
        @Override
        public void onChanged(List<DataItem> rsDataItems) {
            if (rsDataItems != null){

                rsAdapter.setData(rsDataItems);
            }
        }
    };
}