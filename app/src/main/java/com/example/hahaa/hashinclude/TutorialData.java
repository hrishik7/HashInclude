package com.example.hahaa.hashinclude;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class TutorialData {

    ArrayList<Tutorial> tutorialdata;
    ArrayList<Tutorial> tutorialdataHE;
    String[] head, desc, ur, site;
    public int q,x=0;
    private final int MAX_TUT = 1000;
    private int t, u, n;
    String constUrlHE;

    TutorialData()
    {
        tutorialdata = new ArrayList<>();
        tutorialdataHE = new ArrayList<>();
        head = new String[MAX_TUT];
        desc = new String[MAX_TUT];
        ur = new String[MAX_TUT];
        for(q=0;q<100;q++)
            x++;
        site = new String[MAX_TUT];
        t = 20; u = 10;
        constUrlHE = "https://www.hackerearth.com/practice/notes/";
    }

    public void initializeStringHE()
    {
        head[0] = "Array And Strings Code Monk";
        head[1] = "Sorting Code Monk";
        head[2] = "Searching Code Monk";
        head[3] = "Stacks and Queues";
        head[4] = "Number Theory 1";
        head[5] = "Number Theory II";
        head[6] = "Graph Theory Part I";
        head[7] = "Graph Theory Part II";
        head[8] = "Dynamic Programming I";
        head[9] = "Bit Manipulation";

        for(int i = 0; i<u; i++)
        {
            String temp[] = head[i].toLowerCase().split(" ");
            int l = temp.length;
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<l;j++) sb.append(temp[j]).append("-");
            String s = sb.toString();
            ur[i] = constUrlHE + s.substring(0, s.length()-1) + "/";
            site[i] = "Hackerearth";
        }
        for(q=0;q<100;q++)
            x++;

        desc[0] = "An array is a sequential collection of " +
                "variables of same data type which can be " +
                "accessed using an integer as index, that generally starts from 0.";
        desc[1] = "Sorting is a process of arranging items in ascending or descending order." +
                " This process can be implemented via many different algorithms." +
                "Following is the list of sorting algorithms which";
        desc[2] = "Searching is one of the most fundamental problems " +
                "in Computer Science. It is the " +
                "process of finding a particular item in a collection of items.";
        desc[3] = "We deal with data all the time, so how we store, organise or group our data, matters."+
                "Data Structures are tools which are used to store data " +
                "in a structured way in computer to use it efficiently. ";
        desc[4] = "Problems in competitive programming which involve " +
                "Mathematics are are usually about number theory, or geometry. ";
        desc[5] = "Problems in competitive programming which " +
                "involve Mathematics are are usually about number theory, or geometry.";
        desc[6] = "What is a graph? Do we use it a lot of times? Let’s think of an example: " +
                "Facebook. The humongous network of you, your friends, " +
                "family, their friends and their friends e";
        desc[7] = "We will start with one of the most studied and very interesting " +
                "problem in graph theory - finding shortest paths between vertices.";
        desc[8] = "The image above says a lot about Dynamic Programming. So, is repeating " +
                "the things for which you already have the answer, a good thing ? ";
        desc[9] = "Working on bytes, or data types comprising of bytes like ints, floats, " +
                "doubles or even data structures which stores large " +
                "amount of bytes is normal for a programmer.";
    }


    public ArrayList<Tutorial> getTutorialdataHE()
    {
        initializeStringHE();
        int i;

        for(i=0;i<u;i++)
        {
            x++;
            tutorialdataHE.add(new Tutorial(head[i], desc[i], ur[i], site[i]));
        }
        return tutorialdataHE;
    }


}
