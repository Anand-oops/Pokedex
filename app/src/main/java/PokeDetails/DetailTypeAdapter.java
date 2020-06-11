package PokeDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.pokedex.R;

import java.util.List;

public class DetailTypeAdapter extends RecyclerView.Adapter<DetailTypeAdapter.MyViewHolder> {
    Context context;
    List<Type> pokeTypes;

    public DetailTypeAdapter(Context context, List<Type> pokeTypes) {
        this.context = context;
        this.pokeTypes = pokeTypes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.type_item, parent, false);
        return new DetailTypeAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.pokeType.setText(pokeTypes.get(position).getType().getName().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return pokeTypes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pokeType;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pokeType = itemView.findViewById(R.id.pokeType);
        }
    }
}

