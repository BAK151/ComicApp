package com.demo.comicapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.comicapp.databinding.FragmentHomeBinding;
import com.demo.comicapp.databinding.FragmentLikeBinding;
import com.demo.comicapp.databinding.FragmentOfflineBinding;


public class OfflineFragment extends Fragment {
    private FragmentOfflineBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOfflineBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}