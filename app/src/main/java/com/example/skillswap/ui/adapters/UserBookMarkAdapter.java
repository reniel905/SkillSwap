package com.example.skillswap.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillswap.R;
import com.example.skillswap.models.Skill;
import com.example.skillswap.repo.Data;

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

    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }
}
