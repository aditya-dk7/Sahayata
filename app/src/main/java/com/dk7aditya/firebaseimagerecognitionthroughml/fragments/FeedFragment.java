package com.dk7aditya.firebaseimagerecognitionthroughml.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dk7aditya.firebaseimagerecognitionthroughml.R;
import com.dk7aditya.firebaseimagerecognitionthroughml.adapters.FeedListRecyclerAdapter;
import com.dk7aditya.firebaseimagerecognitionthroughml.models.FeedList;
import com.dk7aditya.firebaseimagerecognitionthroughml.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class FeedFragment extends Fragment implements FeedListRecyclerAdapter.OnFeedNameListener {

    private ArrayList <FeedList> mFeedList = new ArrayList<>();
    private FeedList mFeedListArray;
    private FeedListRecyclerAdapter mFeedListRecyclerAdapter;
    private RecyclerView mRecyclerViewFeed;
    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        mRecyclerViewFeed = view.findViewById(R.id.recyclerViewFeedList);
        initFeedRecyclerView();
        insertFakeNews();
        return view;
    }
    private void insertFakeNews(){
        mFeedList.clear();
        mFeedListArray = new FeedList();
        for(int i=0; i<3; ++i) {
            mFeedListArray.setImageNewsTitle("NEWS TITLE");
            mFeedListArray.setImageNewsDescription("NEWS DESCRIPTION");
            mFeedListArray.setImageNewsUrl("https://static.toiimg.com/thumb/msid-81680552,width-1070,height-580,imgsize-127229,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg");
            mFeedList.add(mFeedListArray);
        }
    }
    private void initFeedRecyclerView(){
        LinearLayoutManager linearLayoutManagerFeed = new LinearLayoutManager(getContext());
        mRecyclerViewFeed.setLayoutManager(linearLayoutManagerFeed);
        VerticalSpacingItemDecorator itemDecoratorFeed = new VerticalSpacingItemDecorator(10);
        mRecyclerViewFeed.addItemDecoration(itemDecoratorFeed);
        mFeedListRecyclerAdapter = new FeedListRecyclerAdapter (mFeedList, FeedFragment.this);
        mRecyclerViewFeed.setAdapter(mFeedListRecyclerAdapter);
    }

    @Override
    public void onFeedNameClick(int position) {
        Toast.makeText(getContext(), "Position: " + (position+1), Toast.LENGTH_SHORT).show();
    }
}