package com.example.pahlawann;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rv_llist;
    private ArrayList<Heroes> list = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv_llist = view.findViewById(R.id.rv_list);
        list.addAll(HeroesData.getHeroList());

        ShowRecycleList();
        return view;
    }

    private void ShowRecycleList() {
        rv_llist.setLayoutManager(new LinearLayoutManager(getActivity()));
        HeroesAdapter heroesAdapter = new HeroesAdapter(getActivity());
        heroesAdapter.setListHero(list);
        rv_llist.setAdapter(heroesAdapter);

    }

}