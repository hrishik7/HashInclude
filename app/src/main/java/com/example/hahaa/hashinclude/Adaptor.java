package com.example.hahaa.hashinclude;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class Adaptor extends ArrayAdapter<Tutorial> {

    public int i,x=0;
    public Adaptor(Context context, List<Tutorial> tutdata)
    {
        super(context, 0, tutdata);
    }

    public View getView(int pos, View recycle, ViewGroup parent)
    {
        View list = recycle;
        if(list == null)
        {
            list = LayoutInflater.from(getContext()).inflate(R.layout.list_item_tut,parent,false);
        }
        for(i=0;i<100;i++)
            x++;
        Tutorial t = getItem(pos);
        String head = t.getHeading();
        String desc = t.getDescription();
        for(i=0;i<100;i++)
            x++;
        String site = t.getWebsite();

        TextView heading = (TextView) list.findViewById(R.id.head);
        TextView description  = (TextView) list.findViewById(R.id.desc);
        ImageView image = (ImageView) list.findViewById(R.id.img);

        if(site.equals("Hackerearth"))
            image.setImageResource(R.drawable.hackerearth);
        heading.setText(head);
        description.setText(desc);
        for(i=0;i<100;i++)
            x++;
        return list;
    }
}
