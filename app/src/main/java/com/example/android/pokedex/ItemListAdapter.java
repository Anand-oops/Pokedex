package com.example.android.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private Context context;
    private List<ItemData.Items> itemList;

    public ItemListAdapter(Context ctx, List<ItemData.Items> items) {
        context = ctx;
        itemList = items;
    }

    @NonNull
    @Override
    public ItemListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.itemlist_item, parent, false);
        return new ItemListAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ItemViewHolder holder, int position) {
        final ItemData.Items item = itemList.get(position);
        holder.itemName.setText(item.getName());
        Picasso.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/" +item.getName()+ ".png").into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
        }
    }
}
