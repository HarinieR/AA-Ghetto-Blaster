package com.harinie.aaghettoblaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FirebaseStorage mStorageRef;
    private StorageReference moviesRef;

    private ProgressBar progressBar;

    private List<Movie> movies;

    private String[] myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialising the views
        getViews();

        // Get the instance of the storage bucket
        mStorageRef = FirebaseStorage.getInstance();

        // Create a reference for the storage bucket
        moviesRef = mStorageRef.getReferenceFromUrl(Constants.STORAGE_PATH_URL);

        movies = new ArrayList<>();

        // TODO : query the movie names from the database and save it as array
        // and show them in latest movies order
        myDataset = getResources().getStringArray(R.array.movieNames);


        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getViews(){
        mRecyclerView = findViewById(R.id.recycler_view);
    }

}
