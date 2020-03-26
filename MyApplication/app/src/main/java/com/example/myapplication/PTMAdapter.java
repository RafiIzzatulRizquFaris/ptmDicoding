package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PTMAdapter extends RecyclerView.Adapter<PTMAdapter.ListViewHolder>    {

    private ArrayList<PTM> listPTM;

    PTMAdapter(ArrayList<PTM> list) {
        this.listPTM = list;
    }


    private OnItemClickCallBack onItemClickCallBack;


    void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack=onItemClickCallBack;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ptm, viewGroup,false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        PTM ptm = listPTM.get(position);
        Glide.with(holder.itemView.getContext())
                .load(ptm.getImg())
                .apply(new RequestOptions().override(55,55))
                .into(holder.logoUniv);
        holder.nama.setText(ptm.getNama());
        holder.desc.setText(ptm.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked(listPTM.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPTM.size();
    }




    static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView logoUniv;
        TextView nama,desc;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);

            logoUniv = itemView.findViewById(R.id.logoPtm);
            nama = itemView.findViewById(R.id.namaPtm);
            desc = itemView.findViewById(R.id.deskripsi);
        }
    }

    public interface OnItemClickCallBack {
        void onItemClicked(PTM data);
    }
}
