package PokeDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.pokedex.R;

import java.util.List;

public class DetailStatAdapter extends RecyclerView.Adapter<DetailStatAdapter.StatViewHolder> {
    Context context;
    List<Stat> pokeStats;

    public DetailStatAdapter(Context context, List<Stat> pokeStats) {
        this.context = context;
        this.pokeStats = pokeStats;
    }

    @NonNull
    @Override
    public StatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.stat_item, parent, false);
        return new DetailStatAdapter.StatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatViewHolder holder, int position) {
        holder.pokeStat.setText(pokeStats.get(position).getStat().getName());
        holder.pokeDetailStat.setText(String.valueOf(pokeStats.get(position).getBaseStat()));
        holder.progressBar.setProgress(pokeStats.get(position).getBaseStat());

    }

    @Override
    public int getItemCount() {
        return pokeStats.size();
    }

    public class StatViewHolder extends RecyclerView.ViewHolder {
        TextView pokeStat, pokeDetailStat;
        ProgressBar progressBar;

        public StatViewHolder(@NonNull View itemView) {
            super(itemView);
            pokeStat = itemView.findViewById(R.id.pokeStat);
            progressBar = itemView.findViewById(R.id.progressBar);
            pokeDetailStat = itemView.findViewById(R.id.pokeDetailStat);
        }
    }
}
