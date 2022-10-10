package com.example.firebasetextimagedatafetchingtorecyclerview;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.firebasetextimagedatafetchingtorecyclerview.Adapter.RecyclerDataAdapter;
import com.example.firebasetextimagedatafetchingtorecyclerview.databinding.ActivityMainBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private DatabaseReference databaseReference;
    private RecyclerDataAdapter myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference = FirebaseDatabase.getInstance().getReference().child("student");

        FirebaseRecyclerOptions<FirebaseResponseModel> options =
                new FirebaseRecyclerOptions.Builder<FirebaseResponseModel>()
                        .setQuery(databaseReference, FirebaseResponseModel.class)
                        .build();

        myadapters = new RecyclerDataAdapter(options);
        mainBinding.recyclerView.setAdapter(myadapters);

    }

    @Override
    public void onStart() {
        super.onStart();
        myadapters.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        myadapters.stopListening();
    }
}