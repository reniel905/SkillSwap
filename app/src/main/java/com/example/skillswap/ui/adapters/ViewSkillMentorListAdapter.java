package com.example.skillswap.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillswap.R;
import com.example.skillswap.models.Mentor;
import com.example.skillswap.modules.ViewMentorActivity;
import com.example.skillswap.repo.Data;

import java.util.ArrayList;

public class ViewSkillMentorListAdapter extends RecyclerView.Adapter<ViewSkillMentorListAdapter.ViewHolder> {

    ArrayList<Mentor> mentors = Data.mentors;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mentorName;
        private final ImageView mentorImage;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mentorName = itemView.findViewById(R.id.mentorName);
            mentorImage = itemView.findViewById(R.id.mentorCardImage);

        }

        public TextView getMentorName() {
            return mentorName;
        }

        public ImageView getMentorImage() {
            return mentorImage;
        }
    }

    @NonNull
    @Override
    public ViewSkillMentorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mentor_list_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewSkillMentorListAdapter.ViewHolder holder, int position) {

        holder.getMentorName().setText(mentors.get(position).getFirstName());
        holder.getMentorImage().setImageResource(R.drawable.default_avatar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("mentorFirstName", mentors.get(position).getFirstName());
                bundle.putString("mentorLastName", mentors.get(position).getLastName());
                bundle.putString("mentorMiddleName", mentors.get(position).getMiddleName());
                bundle.putString("mentorEmail", mentors.get(position).getEmail());
                bundle.putString("mentorPhone", mentors.get(position).getPhone());

                Intent intent = new Intent(holder.itemView.getContext(), ViewMentorActivity.class);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mentors.size();
    }
}
