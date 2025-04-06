package com.example.skillswap.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.skillswap.R;
import com.example.skillswap.databinding.FragmentListingBinding;
import com.example.skillswap.ui.adapters.ListingListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListingFragment newInstance(String param1, String param2) {
        ListingFragment fragment = new ListingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentListingBinding binding = FragmentListingBinding.inflate(getLayoutInflater());

        String[] SKILLS = {""};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(binding.getRoot().getContext(), android.R.layout.simple_dropdown_item_1line, SKILLS);
        AutoCompleteTextView listingSkill = (AutoCompleteTextView) binding.getRoot().findViewById(R.id.listingSkill);
        listingSkill.setAdapter(arrayAdapter);
        // Inflate the layout for this fragment

        ListingListAdapter listingListAdapter = new ListingListAdapter();
        binding.listingList.setAdapter(listingListAdapter);
        binding.listingList.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }
}