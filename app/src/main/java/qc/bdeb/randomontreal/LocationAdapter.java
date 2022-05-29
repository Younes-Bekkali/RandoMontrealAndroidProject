package qc.bdeb.randomontreal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationRowHolder>{

    ArrayList<qc.bdeb.randomontreal.Location> locationsList;
    Context context;
    ClickInterface clickInterface;
    public LocationAdapter(ArrayList<Location>  locationsList, Context context, ClickInterface clickInterface) {
        this.context = context;
        this.locationsList = locationsList;
        this.clickInterface= clickInterface;
    }

    @NonNull
    @Override
    public LocationRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.locations_list,parent,false);

        return new LocationRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationRowHolder holder, int position) {
        holder.txtLocationName.setText(locationsList.get(position).getName());
        holder.imgLocation.setImageResource(locationsList.get(position).getImage());

    }



    @Override
    public int getItemCount() {
        return locationsList.size();
    }


    class LocationRowHolder extends RecyclerView.ViewHolder{
        TextView txtLocationName;
        ImageView imgLocation;
        public LocationRowHolder(@NonNull View itemView) {
            super(itemView);
            txtLocationName = itemView.findViewById(R.id.txt_location_name);
            imgLocation = itemView.findViewById(R.id.img_location);

            itemView.setOnClickListener((view) -> {
                clickInterface.onItemClick(getAdapterPosition());
            });
        }
    }

    interface ClickInterface{
        void onItemClick(int postionOfTheLocation);
    }
}
