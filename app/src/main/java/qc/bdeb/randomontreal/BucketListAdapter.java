package qc.bdeb.randomontreal;

import android.content.Context;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.BucketListElementHolder> {
ArrayList<BucketListElement> bucketListElements;
Context context;
ItemClicked itemClicked;
ViewGroup parent;
public BucketListAdapter(ArrayList<BucketListElement> bucketListElementArrayList, Context context,ItemClicked itemClicked){
    bucketListElements = bucketListElementArrayList;
    this.context = context;
    this.itemClicked = itemClicked;


}

    @NonNull
    @Override
    public BucketListElementHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.bucketlist_holder,parent,false);
    this.parent = parent;
        return new BucketListElementHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketListElementHolder holder, int position) {
    holder.title.setText(bucketListElements.get(position).getTitle());
        holder.description.setText(bucketListElements.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return bucketListElements.size();
    }

    class BucketListElementHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView description;
        ImageView imgBucketListElementEdit;
        public BucketListElementHolder(@NonNull View itemView) {
            super(itemView);
        title=itemView.findViewById(R.id.txtBucketListElementTitle);
        description=itemView.findViewById(R.id.txtBucketListElementDescription);
        imgBucketListElementEdit=itemView.findViewById(R.id.imgBucketListElementEdit);
        //Annimation
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(description.getMaxLines() == 1){
                    description.setMaxLines(Integer.MAX_VALUE);
                }else{
                    description.setMaxLines(1);
                }
                TransitionManager.beginDelayedTransition(parent);
            }
        });

        imgBucketListElementEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClicked.onClick(getAdapterPosition(),itemView);
            }
        });

        }
    }

    //Update Bucket List Element

    interface ItemClicked{
        void onClick(int postion, View view);
    }



}//End of class
