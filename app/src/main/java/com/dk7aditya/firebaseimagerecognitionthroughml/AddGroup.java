package com.dk7aditya.firebaseimagerecognitionthroughml;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class AddGroup extends AppCompatActivity {
    private EditText editTextGroupName;
    private EditText editTextDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AddGroup);
        setContentView(R.layout.activity_add_group);
        editTextGroupName = findViewById(R.id.edit_text_group_name);
        editTextDescription = findViewById(R.id.edit_text_description);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_group_menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.check_item1:
                checkNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void checkNote() {
        String group_name = editTextGroupName.getText().toString();
        String description = editTextDescription.getText().toString();

        if (group_name.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a Group Name and Description", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Toast.makeText(this,"Working for now",Toast.LENGTH_SHORT).show();
            Intent intentToMain = new Intent(AddGroup.this, HomeActivity.class);
            intentToMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intentToMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentToMain);
            overridePendingTransition(0,0);
        }
        /*
        CollectionReference groupsRef = FirebaseFirestore.getInstance()
                .collection("Groups");
        groupsRef.add(new Group(group_name, description, count));
        Toast.makeText(this, "Group added", Toast.LENGTH_SHORT).show();
        finish();

         */
    }
}