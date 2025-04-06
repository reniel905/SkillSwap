package com.example.skillswap.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.skillswap.R;
import com.example.skillswap.databinding.FragmentRegisterBinding;
import com.example.skillswap.logic.DatabaseLoader;
import com.example.skillswap.logic.Validator;
import com.example.skillswap.models.Credential;
import com.example.skillswap.models.Mentor;
import com.example.skillswap.repo.Data;
import com.example.skillswap.repo.DatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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


        String firstName;
        String lastName;
        String middleName;
        String email;
        String phone;

        FragmentRegisterBinding binding = FragmentRegisterBinding.inflate(getLayoutInflater());


        binding.registerPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if(!Validator.isPasswordCorrect(s.toString())){

                    binding.registerPasswordLayout.setError("Password must be more than 8 characters.");

                } else {

                    binding.registerPasswordLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.registerPasswordRepeat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!Validator.isPasswordMatched(binding.registerPassword.getText().toString(),
                        binding.registerPasswordRepeat.getText().toString())){

                    binding.registerPasswordRepeatLayout.setError("Password do not match.");

                } else {

                    binding.registerPasswordRepeatLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.registerEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!Validator.isEmailCorrect(s.toString())){

                    binding.registerEmailLayout.setError("Invalid email.");

                } else {

                    binding.registerEmailLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.registerButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if (
                        Validator.isFieldEmpty(binding.registerNameFirst.getText().toString()) ||
                                Validator.isFieldEmpty(binding.registerNameLast.getText().toString()) ||
                                Validator.isFieldEmpty(binding.registerNameMiddle.getText().toString()) ||
                                Validator.isFieldEmpty(binding.registerPhone.getText().toString()) ||
                                Validator.isFieldEmpty(binding.registerEmail.getText().toString()) ||
                                Validator.isFieldEmpty(binding.registerPassword.getText().toString()) ||
                                Validator.isFieldEmpty(binding.registerPasswordRepeat.getText().toString())

                ){

                    Toast.makeText(getContext(), "Please fill all empty fields.", Toast.LENGTH_SHORT).show();

                } else {

                    DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
                    databaseHelper.insertUser(new Mentor(binding.registerNameFirst.getText().toString(),
                            binding.registerNameLast.getText().toString(),
                            binding.registerNameMiddle.getText().toString(),
                            binding.registerEmail.getText().toString(),
                            binding.registerPhone.getText().toString(),
                            new Credential(binding.registerEmail.getText().toString(),
                                    binding.registerPassword.getText().toString()
                                    )
                            ));

                    DatabaseLoader databaseLoader = new DatabaseLoader(getContext());
                    databaseLoader.loadMentors();

                    Toast.makeText(getContext(), Data.mentors.get(0).toString(), Toast.LENGTH_SHORT).show();

                }

            }
        });




        return binding.getRoot();
    }
}