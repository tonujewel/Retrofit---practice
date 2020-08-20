package com.jewel.retrofitpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.jewel.retrofitpractice.R;
import com.jewel.retrofitpractice.model.AlbumDM;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.CustomViewHolder> {

    private Context context;
    private List<AlbumDM> albumDMS;

    public PhotoAdapter(Context context, List<AlbumDM> albumDMS) {
        this.context = context;
        this.albumDMS = albumDMS;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        if (albumDMS.get(position).getId() != null) {
            holder.songID.setText(albumDMS.get(position).getId()+"");
        }
        if (albumDMS.get(position).getTitle() != null) {
            holder.title.setText(albumDMS.get(position).getTitle()+"");
        }
        if (albumDMS.get(position).getUrl() != null) {
            holder.songURL.setText(albumDMS.get(position).getUrl()+"");
        }
        if (albumDMS.get(position).getThumbnailurl() != null) {
            Picasso.get().load(albumDMS.get(position).getThumbnailurl()).into(holder.image);
        }

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return albumDMS.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView image;
        private AppCompatTextView songID, title, songURL;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            songID = itemView.findViewById(R.id.songID);
            title = itemView.findViewById(R.id.title);
            songURL = itemView.findViewById(R.id.songURL);
        }
    }

}
