package com.example.miwok;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private  int colorResourceID;

    public WordAdapter (Context context, ArrayList<Word> words, int colorResourceID){
        super(context,0,words);
        this.colorResourceID = colorResourceID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
    Word currentWord = getItem(position);
        TextView miwok = listItemView.findViewById(R.id.miwok_text_view);
        miwok.setText(currentWord.getMiwokWord());

        TextView english = listItemView.findViewById(R.id.english_text_view);
        english.setText(currentWord.getEnglishWord());

        ImageView image = listItemView.findViewById(R.id.image);
        if (currentWord.getImageID()==0){
            image.setVisibility(View.GONE);
        }else {
            image.setImageResource(currentWord.getImageID());
            image.setVisibility(View.VISIBLE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),colorResourceID);
        textContainer.setBackgroundColor(color);
        return listItemView;


    }
}
