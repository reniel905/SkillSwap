package com.example.skillswap.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillswap.R;
import com.example.skillswap.models.Skill;
import com.example.skillswap.repo.Data;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class UserBookMarkAdapter extends RecyclerView.Adapter<UserBookMarkAdapter.ViewHolder> {


    ArrayList<Skill> bookmarks = Data.bookmarkedSkills;

    public static class ViewHolder extends RecyclerView.ViewHolder{


        private final TextView skillName;
        private final ImageView skillImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            skillName = itemView.findViewById(R.id.skillNameBookmark);
            skillImage = itemView.findViewById(R.id.skillImageBookmark);
        }

        public TextView getSkillName() {
            return skillName;
        }

        public ImageView getSkillImage() {
            return skillImage;
        }
    }

    @NonNull
    @Override
    public UserBookMarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_bookmark, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserBookMarkAdapter.ViewHolder holder, int position) {


        holder.getSkillName().setText(bookmarks.get(position).getName());
        holder.getSkillImage().setImageResource(bookmarks.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = LayoutInflater.from(v.getContext()).inflate(R.layout.dialog_viewskill, null, false );


                ImageButton addToBookMark = view.findViewById(R.id.viewSkillButtonBookmark);

                RecyclerView viewSkillMentorList = view.findViewById(R.id.viewSkillMentorList);
                ViewSkillMentorListAdapter viewSkillMentorListAdapter = new ViewSkillMentorListAdapter();
                viewSkillMentorList.setAdapter(viewSkillMentorListAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                viewSkillMentorList.setLayoutManager(linearLayoutManager);

                addToBookMark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (!Data.bookmarkedSkills.contains(bookmarks.get(position))){

                            Data.bookmarkedSkills.add(bookmarks.get(position));
                        } else {

                            Toast.makeText(v.getContext(), "Skill already added to favorites.", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

                ImageView viewSkillImage = view.findViewById(R.id.viewSkillImage);
                viewSkillImage.setImageResource(bookmarks.get(position).getImage());

                TextView viewSkillName = view.findViewById(R.id.viewSkillName);
                viewSkillName.setText(bookmarks.get(position).getName());

                TextView viewSkillDescription = view.findViewById(R.id.viewSkillDescription);
                viewSkillDescription.setText(bookmarks.get(position).getDescription());

                TextView viewSkillLevel = view.findViewById(R.id.viewSkillLevel);
                viewSkillLevel.setText(bookmarks.get(position).getLevel());

                MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(v.getContext());
                dialogBuilder.setView(view)
                        .create()
                        .show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }
}
