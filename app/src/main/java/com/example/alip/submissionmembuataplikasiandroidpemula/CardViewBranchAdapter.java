package com.example.alip.submissionmembuataplikasiandroidpemula;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alip.submissionmembuataplikasiandroidpemula.models.Branch;

import java.util.ArrayList;

public class CardViewBranchAdapter extends RecyclerView.Adapter<CardViewBranchAdapter.CardViewViewHolder> {
    public CardViewBranchAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Branch> getListBranch() {
        return listBranch;
    }

    public void setListBranch(ArrayList<Branch> listBranch) {
        this.listBranch = listBranch;
    }

    private ArrayList<Branch> listBranch;

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_branch, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        Branch b = getListBranch().get(i);

        cardViewViewHolder.tvName.setText(b.getName());
        cardViewViewHolder.tvAddress.setText(b.getAddress());
        cardViewViewHolder.imgPhoto.setImageResource(b.getPhoto());
        cardViewViewHolder.btnDetail.setOnClickListener(new CustomOnClickListener(i, new CustomOnClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent detailIntent = new Intent(context, DetailActivity.class);
                detailIntent.putExtra("name", getListBranch().get(position).getName());
                detailIntent.putExtra("address", getListBranch().get(position).getAddress());
                detailIntent.putExtra("phone", getListBranch().get(position).getPhone());
                detailIntent.putExtra("email", getListBranch().get(position).getEmail());
                detailIntent.putExtra("photo", getListBranch().get(position).getPhoto());

                context.startActivity(detailIntent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListBranch().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvAddress;
        Button btnDetail;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvAddress = itemView.findViewById(R.id.tv_item_address);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
