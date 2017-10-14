package com.bkdn.maihuong.exercise_firebase1;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 27/09/2017.
 */

public class CustomListViewAdapter extends ArrayAdapter<JournalEntry> {
        private Activity activity;
        private int idLayout;
        private ArrayList<JournalEntry> list;

        public CustomListViewAdapter(Activity activity, int idLayout, ArrayList<JournalEntry> list) {
                super(activity, idLayout, list);
                this.activity = activity;
                this.idLayout = idLayout;
                this.list = list;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                JournalEntry journalEntry = getItem(position);
                LayoutInflater inflater = activity.getLayoutInflater();
                convertView = inflater.inflate(idLayout,null);
                TextView title =(TextView) convertView.findViewById(R.id.tvTitle);
                title.setText(list.get(position).getTitle());
                TextView date =(TextView) convertView.findViewById(R.id.tvDate);
                String displayDate = new SimpleDateFormat("MMM dd, yyyy").format(new Date(journalEntry.getDateModified()));
                date.setText(displayDate);

                ImageView imageView=(ImageView) convertView.findViewById(R.id.imgAvt) ;
                String firstLetter = journalEntry.getTitle().substring(0, 1);
                ColorGenerator generator = ColorGenerator.MATERIAL;
                int color = generator.getRandomColor();
                TextDrawable drawable = TextDrawable.builder()
                        .buildRound(firstLetter, color);
                imageView.setImageDrawable(drawable);
                return convertView;
        }

}