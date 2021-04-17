package com.dk7aditya.firebaseimagerecognitionthroughml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.dk7aditya.firebaseimagerecognitionthroughml.models.FirebaseUserListItem;
import com.dk7aditya.firebaseimagerecognitionthroughml.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.List;

public class GetAllUsersForGroupActivity extends AppCompatActivity implements FirebaseUserNameAdapter.OnUserListClickListener{
    private FirebaseUserNameAdapter mFirebaseUserNameAdapter;
    private static final String TAG = "GetAllUsersForGroupActivity";
    private RecyclerView mRecyclerViewList;
    private ArrayList<FirebaseUserListItem> mFirebaseUserListItem = new ArrayList<>();
    private FirebaseUserListItem mAddUserNameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AddGroup);
        setContentView(R.layout.activity_get_all_users_for_group);
        mRecyclerViewList = findViewById(R.id.listActiveUsersFromFirebaseRecyclerView);
        fillExampleList();
        setUpRecyclerView();
    }
    private void fillExampleList() {
        for(int i=0; i<5; ++i) {
            mAddUserNameList = new FirebaseUserListItem();
            mAddUserNameList.setText1(String.valueOf(i));
            mFirebaseUserListItem.add(mAddUserNameList);
            //mFirebaseUserNameAdapter.notifyDataSetChanged();
        }
        for(int i=6; i<11; ++i) {
            mAddUserNameList = new FirebaseUserListItem();
            mAddUserNameList.setText1(String.valueOf(i));
            mFirebaseUserListItem.add(mAddUserNameList);
            //mFirebaseUserNameAdapter.notifyDataSetChanged();
        }
    }
    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManagerGetUsers = new LinearLayoutManager(this);
        mRecyclerViewList.setLayoutManager(linearLayoutManagerGetUsers);
        VerticalSpacingItemDecorator itemDecoratorFeed = new VerticalSpacingItemDecorator(10);
        mRecyclerViewList.addItemDecoration(itemDecoratorFeed);
        mFirebaseUserNameAdapter = new FirebaseUserNameAdapter(mFirebaseUserListItem, GetAllUsersForGroupActivity.this);
        mRecyclerViewList.setAdapter(mFirebaseUserNameAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_group_list_firebase, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //if(!newText.isEmpty())
                mFirebaseUserNameAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.checkToMakeGroup) {
            getUsersToMakeGroup();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void getUsersToMakeGroup(){
        ArrayList<String> finalListOfSelectedUsers = mFirebaseUserNameAdapter.getListOfSelectedUsers();
        Toast.makeText(this, finalListOfSelectedUsers.toString(),Toast.LENGTH_SHORT).show();
        Intent addActivityIntent = new Intent(GetAllUsersForGroupActivity.this, AddGroup.class);
        addActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        addActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(addActivityIntent);

    }
    @Override
    public void onUserListClick(int position) {
        //Toast.makeText(this, "Position: " + (position+1), Toast.LENGTH_SHORT).show();
    }
}