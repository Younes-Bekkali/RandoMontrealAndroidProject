package qc.bdeb.randomontreal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EditBucketListActivity extends AppCompatActivity {
    EditText edtTitle, edtDescription;

    Button btnCancel, btnSave;

    LinearLayout linearLayout;//to hide the button edit in the dialogue
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bucket_list);


        final Intent intent = getIntent();

        linearLayout = findViewById(R.id.btn_holder);
        edtDescription = findViewById(R.id.edt_edit_descrption);
        edtTitle = findViewById(R.id.edt_edit_title);

        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BucketListElement bucketListElement = new BucketListElement(edtTitle.getText().toString(), edtDescription.getText().toString());
                bucketListElement.setId(intent.getIntExtra("id", 1));
                if (new BucketListElementHandler(EditBucketListActivity.this).update(bucketListElement)) {
                    Toast.makeText(EditBucketListActivity.this, "Element updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditBucketListActivity.this, "Failed updating", Toast.LENGTH_SHORT).show();
                }
                onBackPressed();
            }
        });
        edtDescription.setText(intent.getStringExtra("description"));
        edtTitle.setText(intent.getStringExtra("title"));






    }//end of onCreate
}//End of the class