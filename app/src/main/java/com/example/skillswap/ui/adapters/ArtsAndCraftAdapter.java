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
import com.example.skillswap.logic.Categorizer;
import com.example.skillswap.logic.Favorites;
import com.example.skillswap.models.Skill;
import com.example.skillswap.repo.Data;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class ArtsAndCraftAdapter extends RecyclerView.Adapter<ArtsAndCraftAdapter.ViewHolder> {

    private ArrayList<Skill> skills = Categorizer.Arts();

    public static class ViewHolder extends RecyclerView.ViewHolder{


        private final TextView skillName;
        private final TextView description;
        private final TextView level;
        private final TextView time;
        private final ImageView image;
        private final ImageView bookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            skillName = itemView.findViewById(R.id.skillName);
            description = itemView.findViewById(R.id.skillDescription);
            level = itemView.findViewById(R.id.skillLevel);
            time = itemView.findViewById(R.id.skillLearningTime);
            image = itemView.findViewById(R.id.skillImage);
            bookmark = itemView.findViewById(R.id.bookmarkButton);

        }

        public ImageView getImage() {
            return image;
        }

        public TextView getSkillName() {
            return skillName;
        }

        public TextView getDescription() {
            return description;
        }

        public TextView getLevel() {
            return level;
        }

        public TextView getTime() {
            return time;
        }

        public ImageView getBookmark() {
            return bookmark;
        }
    }

    @NonNull
    @Override
    public ArtsAndCraftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_skillcategory_skill, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtsAndCraftAdapter.ViewHolder holder, int position) {

        holder.getImage().setImageResource(skills.get(position).getImage());
        holder.getSkillName().setText(skills.get(position).getName());
        holder.getDescription().setText(skills.get(position).getDescription());
        holder.getLevel().setText(skills.get(position).getLevel());
        holder.getTime().setText(String.valueOf(skills.get(position).getSkillTime()) + "h");

        if (!skills.get(position).isBookmarked()){


            holder.getBookmark().setImageResource(R.drawable.outline_bookmark_border_24);


        } else {


            holder.getBookmark().setImageResource(R.drawable.baseline_bookmark_24);

        }

        holder.getBookmark().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!skills.get(position).isBookmarked()){

                    holder.getBookmark().setImageResource(R.drawable.baseline_bookmark_24);
                    Favorites.add(skills.get(position));
                    skills.get(position).setBookmarked(true);
                    Toast.makeText(v.getContext(), "Skill added to favorites.", Toast.LENGTH_SHORT).show();

                } else {

                    holder.getBookmark().setImageResource(R.drawable.outline_bookmark_border_24);
                    Favorites.remove(skills.get(position));
                    skills.get(position).setBookmarked(false);


                }

            }
        });

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


                        if (!Data.bookmarkedSkills.contains(skills.get(position))){

                            Data.bookmarkedSkills.add(skills.get(position));
                        } else {

                            Toast.makeText(v.getContext(), "Skill already added to favorites.", Toast.LENGTH_SHORT).show();

                        }

                    }
                });




                ImageView viewSkillImage = view.findViewById(R.id.viewSkillImage);
                viewSkillImage.setImageResource(skills.get(position).getImage());

                TextView viewSkillName = view.findViewById(R.id.viewSkillName);
                viewSkillName.setText(skills.get(position).getName());

                TextView viewSkillDescription = view.findViewById(R.id.viewSkillDescription);
                viewSkillDescription.setText(skills.get(position).getDescription());

                TextView viewSkillLevel = view.findViewById(R.id.viewSkillLevel);
                viewSkillLevel.setText(skills.get(position).getLevel());

                MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(v.getContext());
                dialogBuilder.setView(view)
                        .create()
                        .show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return skills.size();
    }
}
