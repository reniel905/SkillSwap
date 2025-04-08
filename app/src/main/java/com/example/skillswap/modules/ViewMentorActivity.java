package com.example.skillswap.modules;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.skillswap.R;
import com.example.skillswap.databinding.ActivityViewMentorBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ViewMentorActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        ActivityViewMentorBinding binding = ActivityViewMentorBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();

        String firstName = bundle.getString("mentorFirstName");
        String lastName = bundle.getString("mentorLastName");
        String middleName = bundle.getString("mentorMiddleName");
        String email = bundle.getString("mentorEmail");
        String phone = bundle.getString("mentorPhone");

        String fullName = firstName + " " + middleName + " " + lastName;

        binding.viewMentorName.setText(fullName);
        binding.viewMentorEmail.setText(email);
        binding.viewMentorPhone.setText(phone);

        Button requestSession = findViewById(R.id.viewMentorButtonRequestSession);
        requestSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(ViewMentorActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                builder.setView(inflater.inflate(R.layout.dialog_requestsession_preference, null))
                        .setPositiveButton("Send request", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                Toast.makeText(ViewMentorActivity.this, "Request sent", Toast.LENGTH_SHORT).show();
                                binding.viewMentorButtonRequestSession.setEnabled(false);

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create()
                        .show();

            }
        });

        binding.viewMentorButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ViewMentorActivity.this, MainMenuActivity.class));

            }
        });
    }
}