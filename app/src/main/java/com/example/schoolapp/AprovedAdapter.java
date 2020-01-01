package com.example.schoolapp;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class AprovedAdapter extends RecyclerView.Adapter <AprovedAdapter.AprovedViewHolder> {

    Context context;
    private final LinkedList<Student> students_AprovedList;


    private LayoutInflater mInflater;

    public AprovedAdapter(LinkedList<Student> students_aprovedList, Context context) {
        students_AprovedList = students_aprovedList;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);


    }



    @NonNull
    @Override
    public AprovedAdapter.AprovedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.student_grades , parent, false);

        return new AprovedViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull AprovedAdapter.AprovedViewHolder holder, int position) {
        Student student = students_AprovedList.get(position);
        holder.nameTV.setText(student.getName());
        holder.teste1TV.setText(student.getTeste1());
        holder.teste2TV.setText(student.getTeste2());

    }

    @Override
    public int getItemCount() {
        return students_AprovedList.size();
    }

    class AprovedViewHolder extends RecyclerView.ViewHolder implements  View.OnCreateContextMenuListener{
        public TextView nameTV, teste1TV,teste2TV;
        final AprovedAdapter mAdapter;


        public AprovedViewHolder(@NonNull View itemView, AprovedAdapter aprovedAdapter) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.et_nomeC);
            teste1TV = itemView.findViewById(R.id.et_teste1);
            teste2TV = itemView.findViewById(R.id.et_teste2);
            this.mAdapter = aprovedAdapter;

            itemView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }
    }


}
