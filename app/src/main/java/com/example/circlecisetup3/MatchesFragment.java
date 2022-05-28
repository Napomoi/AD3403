package com.example.circlecisetup3;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        List<Matches> matchesList = new ArrayList<>();
        matchesList.add(new Matches(getString(R.string.Eddie_Cicotte), getString(R.string.What_Eddie_Said), true, "https://i.imgur.com/zYyha9n.jpg"));
        matchesList.add(new Matches(getString(R.string.Shoeless_Joe), getString(R.string.What_Joe_said), false, "https://i.imgur.com/XgbZdeA.jpeg"));
        matchesList.add(new Matches(getString(R.string.Happy_Felsch), getString(R.string.What_Happy_said), false, "https://i.imgur.com/MU2dD8E.jpeg"));
        matchesList.add(new Matches(getString(R.string.Chick_Gandil), getString(R.string.What_Chick_said), false, "https://i.imgur.com/0OXyb26.jpeg"));
        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        MatchesRecyclerViewAdapter adapter = new MatchesRecyclerViewAdapter(matchesList);
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.small_grid_spacing);
        recyclerView.addItemDecoration(new MatchesItemDecoration(largePadding, smallPadding));
        return view;
    }
}