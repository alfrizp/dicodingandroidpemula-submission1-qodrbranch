package com.example.alip.submissionmembuataplikasiandroidpemula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alip.submissionmembuataplikasiandroidpemula.models.Branch;
import com.example.alip.submissionmembuataplikasiandroidpemula.models.BranchData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBranch;
    private ArrayList<Branch> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBranch = findViewById(R.id.rv_branch);
        rvBranch.setHasFixedSize(true);

        BranchData branchData = new BranchData();
        list.addAll(branchData.getListData());
        getSupportActionBar().setTitle("List Cabang QODR");
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvBranch.setLayoutManager(new LinearLayoutManager(this));
        CardViewBranchAdapter cardViewPresidentAdapter = new CardViewBranchAdapter(this);
        cardViewPresidentAdapter.setListBranch(list);
        rvBranch.setAdapter(cardViewPresidentAdapter);
    }
}
