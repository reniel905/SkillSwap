package com.example.skillswap.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skillswap.databinding.FragmentSkillCategoryBinding;
import com.example.skillswap.ui.adapters.ArtsAndCraftAdapter;
import com.example.skillswap.ui.adapters.BusinessAndFinanceAdapter;
import com.example.skillswap.ui.adapters.FitnessAndWellnessAdapter;
import com.example.skillswap.ui.adapters.LanguageAndCommunicationAdapter;
import com.example.skillswap.ui.adapters.TechnologyAndCodingAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillCategoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkillCategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillCategoryFragment newInstance(String param1, String param2) {
        SkillCategoryFragment fragment = new SkillCategoryFragment();
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

        FragmentSkillCategoryBinding binding = FragmentSkillCategoryBinding.inflate(getLayoutInflater());

        TechnologyAndCodingAdapter technologyAndCodingAdapter = new TechnologyAndCodingAdapter();
        binding.skillCategoryListTC.setAdapter(technologyAndCodingAdapter);
        binding.skillCategoryListTC.setLayoutManager(new LinearLayoutManager(getContext()));

        ArtsAndCraftAdapter artsAndCraftAdapter = new ArtsAndCraftAdapter();
        binding.skillCategoryListAC.setAdapter(artsAndCraftAdapter);
        binding.skillCategoryListAC.setLayoutManager(new LinearLayoutManager(getContext()));

        FitnessAndWellnessAdapter fitnessAndWellnessAdapter = new FitnessAndWellnessAdapter();
        binding.skillCategoryListFW.setAdapter(fitnessAndWellnessAdapter);
        binding.skillCategoryListFW.setLayoutManager(new LinearLayoutManager(getContext()));

        LanguageAndCommunicationAdapter languageAndCommunicationAdapter = new LanguageAndCommunicationAdapter();
        binding.skillCategoryListLC.setAdapter(languageAndCommunicationAdapter);
        binding.skillCategoryListLC.setLayoutManager(new LinearLayoutManager(getContext()));

        BusinessAndFinanceAdapter businessAndFinanceAdapter = new BusinessAndFinanceAdapter();
        binding.skillCategoryListBF.setAdapter(businessAndFinanceAdapter);
        binding.skillCategoryListBF.setLayoutManager(new LinearLayoutManager(getContext()));


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}