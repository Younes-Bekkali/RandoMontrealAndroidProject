package qc.bdeb.randomontreal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtPassword, txtUserName;
    private TextView txtMessage;
    private Intent NavigateToNavigationIntent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidgets();
//        startActivity(new Intent(MainActivity.this, NavigationActivity.class));
    }

    private void setWidgets() {
        txtPassword = findViewById(R.id.txtPassword);
        txtUserName = findViewById(R.id.txtUserName);
        txtMessage = findViewById(R.id.lblMessage);

    }

    public void onLogin(View view) {
        StringBuilder sb = new StringBuilder();
        String RefUserName = "admin";
        String RefPassword = "admin";

//        Toast.makeText(MainActivity.this, "Login button ok", Toast.LENGTH_SHORT).show();
//        sb.append("Bonjour, ");
//        sb.append("\nLogin button ok");
        txtMessage.setText(sb.toString());

        String userName = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();

        sb.append("\nuserName: ");
        sb.append(userName);
        sb.append("\npassword: ");
        sb.append(password);


//        startActivity(new Intent(MainActivity.this, NavigationActivity.class));
        if (userName.equals(RefUserName) && password.equals(RefPassword)) {
//            if(true){
            sb.append("\nLogin ok");
            Toast.makeText(MainActivity.this, "Login ok", Toast.LENGTH_SHORT).show();
            txtMessage.setText(sb.toString());
//            NavigateToNavigationIntent = new Intent(MainActivity.this, NavigationActivity.class);
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
        } else {
            sb.append("\nLogin failed");
            Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            txtMessage.setText(sb.toString());
        }

        clearFields();
    }


    private void clearFields() {
        txtUserName.setText("");
        txtPassword.setText("");
//        txtMessage.setText("");
    }
}