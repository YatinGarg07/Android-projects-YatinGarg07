package com.example.android.miwokapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter <E> extends ArrayAdapter<Word> {


    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects) {

        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentWord= getItem(position);
        View listItemView=convertView;
        if(listItemView==null){
        listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent ,false);
        }
        TextView defaultTextView= (TextView) listItemView.findViewById(R.id.Eng_Trans);

        defaultTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTextView =(TextView) listItemView.findViewById(R.id.Miwok_trans);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        return listItemView;
        }
    }

