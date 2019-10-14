package com.sanket.nhl.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sanket.nhl.Model.Person;
import com.sanket.nhl.Model.RosterItem;
import com.sanket.nhl.R;
import com.sanket.nhl.Utils.Common;
import com.sanket.nhl.View.PlayersDetailsActivity;

import java.util.List;


public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private List<RosterItem> personDetails;
    private Context context;

    public PlayerAdapter(Context context, List<RosterItem> personDetails) {
        this.context = context;
        this.personDetails = personDetails;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvplayerName.setText(personDetails.get(position).getPerson().getFullName());
        holder.tvplayerPosition.setText("Position : " + personDetails.get(position).getPosition().getName());
        holder.tvplayerJerseyNo.setText("Jersey No : #" + personDetails.get(position).getJerseyNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int playerID = personDetails.get(position).getPerson().getId();

                Intent intent = new Intent(context, PlayersDetailsActivity.class);
                intent.putExtra(Common.PLAYER_ID, "" + playerID);
                intent.putExtra(Common.PLAYER_NAME, personDetails.get(position).getPerson().getFullName());
                intent.putExtra(Common.PLAYER_POSITION, personDetails.get(position).getPosition().getName());
                intent.putExtra(Common.PLAYER_JERSEYNO, personDetails.get(position).getJerseyNumber());

                context.startActivity(intent);
             }
        });
    }

    @Override
    public int getItemCount() {
        return personDetails.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvplayerName;
        TextView tvplayerPosition;
        TextView tvplayerJerseyNo;


        ViewHolder(View itemView) {
            super(itemView);
            tvplayerName = itemView.findViewById(R.id.tvPlayerName);
            tvplayerPosition = itemView.findViewById(R.id.tvPosition);
            tvplayerJerseyNo = itemView.findViewById(R.id.tvJerseyNo);
        }
    }
}
