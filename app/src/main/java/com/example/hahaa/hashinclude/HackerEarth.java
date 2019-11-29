package com.example.hahaa.hashinclude;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class HackerEarth extends Fragment {
    public int i,x=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hacker_earth, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        for(i=0;i<100;i++)
            x++;
        TutorialData tutorialData = new TutorialData();
        final ArrayList<Tutorial> tuts = tutorialData.getTutorialdataHE();

        Adaptor adaptor = new Adaptor(getActivity(), tuts);
        listView.setAdapter(adaptor);
        for(i=0;i<100;i++)
            x++;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("hh", "hello you have clicked"+i+" "+l);
                String url = tuts.get(i).getUrl();
                Intent intent = new Intent(getActivity(), Browser.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
        return rootView;
    }
}