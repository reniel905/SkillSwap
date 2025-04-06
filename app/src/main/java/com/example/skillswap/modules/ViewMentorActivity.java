package com.example.skillswap.modules;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.skillswap.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ViewMentorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_mentor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button requestSession = findViewById(R.id.viewMentorButtonRequestSession);
        requestSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getBaseContext());
                LayoutInflater inflater = getLayoutInflater();
                builder.setView(inflater.inflate(R.layout.dialog_requestsession_preference, null))
                        .setPositiveButton("Send request", null)
                        .setNegativeButton("Cancel", null);
                builder.create().show();

            }
        });
    }
}