package com.bkdn.maihuong.exercise_firebase1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Administrator on 12/10/2017.
 */

public class Data {
    public static List<JournalEntry> getSampleJournalEntries() {

        List<JournalEntry> journalEnrties = new ArrayList<>();

        //create the dummy journal
        JournalEntry journalEntry1 = new JournalEntry();
        journalEntry1.setTitle("DisneyLand Trip");
        journalEntry1.setContent
                ("We went to Disneyland today and we had a lot of photos!");
        Calendar calendar1 = GregorianCalendar.getInstance();
        journalEntry1.setDateModified(calendar1.getTimeInMillis());
        journalEnrties.add(journalEntry1);

        JournalEntry journalEntry2 = new JournalEntry();
        journalEntry2.setTitle("Gym Work Out");
        journalEntry2.setContent
                ("We do gym this morning and I met Jack.");
        Calendar calendar2 = GregorianCalendar.getInstance();
        journalEntry2.setDateModified(calendar1.getTimeInMillis());
        journalEnrties.add(journalEntry2);

        JournalEntry journalEntry3 = new JournalEntry();
        journalEntry3.setTitle("Blog Post Idea");
        journalEntry3.setContent
                ("I knew Blog Post Idea this evening!");
        Calendar calendar3 = GregorianCalendar.getInstance();
        journalEntry3.setDateModified(calendar1.getTimeInMillis());
        journalEnrties.add(journalEntry3);

        JournalEntry journalEntry4 = new JournalEntry();
        journalEntry4.setTitle("Cupcake Recipe");
        journalEntry4.setContent
                ("Amanda and I studied Cupcake Recipe.");
        Calendar calendar4 = GregorianCalendar.getInstance();
        journalEntry4.setDateModified(calendar1.getTimeInMillis());
        journalEnrties.add(journalEntry4);

        JournalEntry journalEntry5 = new JournalEntry();
        journalEntry5.setTitle("Notes from\nNoteworking Event");
        journalEntry5.setContent
                ("I worked very hard!");
        Calendar calendar5 = GregorianCalendar.getInstance();
        journalEntry5.setDateModified(calendar1.getTimeInMillis());
        journalEnrties.add(journalEntry5);

        return journalEnrties;
    }
}
