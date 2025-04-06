package com.example.skillswap.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.skillswap.R;
import com.example.skillswap.databinding.FragmentUserBinding;
import com.example.skillswap.models.LoggedInUser;
import com.example.skillswap.ui.adapters.UserBookMarkAdapter;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
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

        FragmentUserBinding binding = FragmentUserBinding.inflate(getLayoutInflater());

        View view = inflater.inflate(R.layout.fragment_user, container, false);
        Button userButtonEditSkillSet = view.findViewById(R.id.userButtonEditSkillSet);


        binding.userName.setText(LoggedInUser.mentor.getFirstName() + " " + LoggedInUser.mentor.getMiddleName() + " " + LoggedInUser.mentor.getLastName());
        binding.userEmail.setText(LoggedInUser.mentor.getEmail());
        binding.userContact.setText(LoggedInUser.mentor.getPhone());


        UserBookMarkAdapter userBookMarkAdapter = new UserBookMarkAdapter();
        binding.userBookmarkList.setAdapter(userBookMarkAdapter);
        binding.userBookmarkList.setLayoutManager(new LinearLayoutManager(getContext()));

        userButtonEditSkillSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
                LayoutInflater inflater2 = requireActivity().getLayoutInflater();
                builder.setView(inflater2.inflate(R.layout.dialog_skillset_edit, null))
                        .setPositiveButton("Save changes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Save changes
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Close dialog
                            }
                        });
                builder.create();
                builder.show();
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}