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

public class DetailAbilityAdapter extends RecyclerView.Adapter<DetailAbilityAdapter.AbilityViewHolder> {
    Context context;
    List<Ability> pokeAbilityList;

    public DetailAbilityAdapter(Context context, List<Ability> pokeAbilityList) {
        this.context = context;
        this.pokeAbilityList = pokeAbilityList;
    }

    @NonNull
    @Override
    public AbilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ability_item, parent, false);
        return new DetailAbilityAdapter.AbilityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AbilityViewHolder holder, int position) {
        holder.pokeAbility.setText(pokeAbilityList.get(position).getAbility().getName());

    }

    @Override
    public int getItemCount() {
        return pokeAbilityList.size();
    }

    public class AbilityViewHolder extends RecyclerView.ViewHolder {
        TextView pokeAbility;

        public AbilityViewHolder(@NonNull View itemView) {
            super(itemView);
            pokeAbility = itemView.findViewById(R.id.pokeDetailAbility);
        }
    }
}

