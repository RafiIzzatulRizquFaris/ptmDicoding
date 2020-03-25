package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PTMAdapter extends RecyclerView.Adapter<PTMAdapter.ListViewHolder>    {

    private ArrayList<PTM> listPTM;

    public PTMAdapter(ArrayList<PTM> list) {
        this.listPTM = list;
    }


    private OnItemClickCallBack onItemClickCallBack;


    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
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
        final Context mcontext = holder.itemView.getContext();
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
        holder.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, About.class);
                mcontext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPTM.size();
    }




    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView logoUniv;
        TextView nama,desc;
        Button btnMenu;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            logoUniv = (ImageView) itemView.findViewById(R.id.logoPtm);
            nama = (TextView) itemView.findViewById(R.id.namaPtm);
            desc = (TextView) itemView.findViewById(R.id.deskripsi);
            btnMenu = (Button) itemView.findViewById(R.id.menu);
        }
    }

    public interface OnItemClickCallBack {
        void onItemClicked(PTM data);
    }
}
