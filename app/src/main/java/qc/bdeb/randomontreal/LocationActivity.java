package qc.bdeb.randomontreal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity implements LocationAdapter.ClickInterface {

    RecyclerView recyclerView;
    ArrayList<Location> locations;

    private String[] names={"Montreal Oryal Park Loop",
            "Olmsted Road Multi-Use Trail",
            "Ile de la Visitation On Nature Park Trail",
            "Cap-Saint-Jacques Nature Park",
            "René-Lévesque Park Loop",
            "Maisonneuve Park Loop",
            "Bord De Lac Pathway",
            "Chemin des Berges - Parc Arthur Therrien to Parc des Rapides",
            "Jacques-Bizard Loop",
            "Par La Fontaine"
    };
    private String[] detail={"- Montreal Montroyal Park Loop :Discover this 8.4-km loop trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 2 h 13 min to complete. This is a popular trail for birding, cross-country skiing, and mountain biking, but you can still enjoy some solitude during quieter times of day. The trail is open year-round and is beautiful to visit anytime. Dogs are welcome, but must be on a leash.",
            "-Olmsted Road Multi-Use Trail : Try this 6.6-km point-to-point trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 1 h 29 min to complete. This is a very popular area for birding, mountain biking, and trail running, so you'll likely encounter other people while exploring. The best times to visit this trail are March through November. Dogs are welcome, but must be on a leash.",
            "- Ile de la Visitation On Nature Park Trail: Discover this 6.9-km loop trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 1 h 23 min to complete. This is a popular trail for birding, cross-country skiing, and hiking, but you can still enjoy some solitude during quieter times of day. The trail is open year-round and is beautiful to visit anytime. Dogs are welcome, but must be on a leash.",
            "- Cap-Saint-Jacques Nature Park: Enjoy this 5.6-km loop trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 1 h 5 min to complete. This trail is great for cross-country skiing, road biking, and snowshoeing, and it's unlikely you'll encounter many other people while exploring. The trail is open year-round and is beautiful to visit anytime. Dogs are welcome, but must be on a leash.",
            "- René-Lévesque Park Loop: Get to know this 2.9-km loop trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 30 min to complete. This is a popular trail for fishing, road biking, and walking, but you can still enjoy some solitude during quieter times of day.",
            "- Maisonneuve Park Loop: Try this 4.7-km loop trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 53 min to complete. This trail is great for hiking, road biking, and trail running. Dogs are welcome, but must be on a leash.",
            "- Bord De Lac Pathway: Check out this 6.6-km out-and-back trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 1 h 10 min to complete. This trail is great for road biking, trail running, and walking, and it's unlikely you'll encounter many other people while exploring. Dogs are welcome, but must be on a leash.",
            "- Chemin des Berges - Parc Arthur Therrien to Parc des Rapides: Explore this 11.6-km out-and-back trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 2 h 4 min to complete. This is a popular trail for hiking, road biking, and snowshoeing, but you can still enjoy some solitude during quieter times of day. The trail is open year-round and is beautiful to visit anytime. Dogs are welcome, but must be on a leash.",
            "- Jacques-Bizard Loop: Discover this 4.5-km loop trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 50 min to complete. This trail is great for cross-country skiing, snowshoeing, and trail running, and it's unlikely you'll encounter many other people while exploring. Dogs are welcome, but must be on a leash.",
            "- Par La Fontaine: Discover this 4.5-km loop trail near Montréal, Quebec. Generally considered an easy route, it takes an average of 50 min to complete. This trail is great for cross-country skiing, snowshoeing, and trail running, and it's unlikely you'll encounter many other people while exploring. Dogs are welcome, but must be on a leash."
          };



    private int[] images={R.drawable.montroyal,
            R.drawable.olmsted,
            R.drawable.visitation,
            R.drawable.saintjacques,
            R.drawable.renelevesque,
            R.drawable.maisonneuve,
            R.drawable.pathway,
            R.drawable.berges,
            R.drawable.bizard,
            R.drawable.fontaine
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        recyclerView = findViewById(R.id.recycler_view);
        locations = new ArrayList<>();

        for(int i = 0; i < names.length; i ++){
            locations.add(new Location(names[i],images[i],detail[i]));
        }
//        locations.add(new Location("test", R.drawable.fontaine));
        LocationAdapter locationAdapter= new LocationAdapter(locations,this,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(locationAdapter);

    }

    @Override
    public void onItemClick(int postionOfTheLocation) {
        Toast.makeText(this, "Clicked "+locations.get(postionOfTheLocation).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,LocationDetailActivity.class);
        intent.putExtra("image",locations.get(postionOfTheLocation).getImage());
//        intent.putExtra("name",locations.get(postionOfTheLocation).getName());
        intent.putExtra("detail",locations.get(postionOfTheLocation).getDetail());
        startActivity(intent);

    }
}