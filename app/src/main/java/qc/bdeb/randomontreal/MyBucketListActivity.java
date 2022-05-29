package qc.bdeb.randomontreal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MyBucketListActivity extends AppCompatActivity {
ImageButton imageButton;
ArrayList<BucketListElement> bucketListElements;
RecyclerView recyclerView;
BucketListAdapter bucketListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bucket_list);
        setWidgets();
//        imageButton = findViewById(R.id.img_add);
        //to be fixed
        recyclerView = findViewById(R.id.recyclerBucketList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyBucketListActivity.this));

        ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                new BucketListElementHandler(MyBucketListActivity.this).delete(bucketListElements.get(viewHolder.getAdapterPosition()).getId());
                bucketListElements.remove(viewHolder.getAdapterPosition());
                bucketListAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);









        loadBucketList();


    }

    private void setWidgets() {
        imageButton = findViewById(R.id.img_add);

    }

    public ArrayList<BucketListElement> readBucketList(){
        ArrayList<BucketListElement> bucketListElements = new BucketListElementHandler(this).readBucketList();
        return bucketListElements;
    }
//load data with animation
    //open the edit dialog
    public void loadBucketList(){
        bucketListElements = readBucketList();
        bucketListAdapter = new BucketListAdapter(bucketListElements, this, new BucketListAdapter.ItemClicked() {
            @Override
            public void onClick(int postion, View view) {
                editBucletListElements(bucketListElements.get(postion).getId(),view);
            }
        });
        recyclerView.setAdapter(bucketListAdapter);
    }

    //Edit Elements
    //Send element to ToEditBucketListActivity
    private void editBucletListElements(int elementId, View view) {
        BucketListElementHandler bucketListElementHandler = new BucketListElementHandler(this);

        BucketListElement bucketListElement = bucketListElementHandler.readOneBucketListElement(elementId);

        Intent intentToEditBucketListActivity = new Intent(this, EditBucketListActivity.class);
        intentToEditBucketListActivity.putExtra("title", bucketListElement.getTitle());
        intentToEditBucketListActivity.putExtra("description", bucketListElement.getDescription());
        intentToEditBucketListActivity.putExtra("id", bucketListElement.getId());
        //Animation
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, ViewCompat.getTransitionName(view));
        startActivityForResult(intentToEditBucketListActivity, 1, optionsCompat.toBundle());

    }


    public void onAdd(View view) {
        LayoutInflater inflater = (LayoutInflater) MyBucketListActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LayoutInflater inflater = MyBucketListActivity.this.getLayoutInflater();
        View viewBucketListInput = inflater.inflate(R.layout.bucketlist_input, null, false);
        EditText editTtile = viewBucketListInput.findViewById(R.id.edt_title);
        EditText editDescription = viewBucketListInput.findViewById(R.id.edt_description);

        new AlertDialog.Builder(MyBucketListActivity.this)
                .setView(viewBucketListInput)
                .setTitle("Add a bucketList element")
                .setPositiveButton("Add", (dialogInterface, i) -> {
                    String title = editTtile.getText().toString();
                    String description = editDescription.getText().toString();
                    BucketListElement bucketListElement = new BucketListElement(title, description);

                    boolean isInserted = new BucketListElementHandler(MyBucketListActivity.this).create(bucketListElement);
                    if (isInserted) {
                        Toast.makeText(MyBucketListActivity.this, "Element saved", Toast.LENGTH_SHORT).show();
                        loadBucketList();
                    } else {
                        Toast.makeText(MyBucketListActivity.this, "Unable to save the Element", Toast.LENGTH_SHORT).show();
                    }
                    dialogInterface.cancel();

                }).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            loadBucketList();
        }
    }
}//end of the class