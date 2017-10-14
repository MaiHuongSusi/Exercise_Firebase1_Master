package com.bkdn.maihuong.exercise_firebase1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DiaryListActivity extends AppCompatActivity {
    private DatabaseReference journalCloudEndPoint;
    private DatabaseReference mDatabase;
     private ArrayList<JournalEntry> mlist;
    private ListView listView;
    private CustomListViewAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_list);
        mDatabase =  FirebaseDatabase.getInstance().getReference();
        journalCloudEndPoint = mDatabase.child("journalentris");
        //addInitialDataToFirebase();
        listView = (ListView) findViewById(R.id.lv);
        mlist =new ArrayList<JournalEntry>();
        adapter=new CustomListViewAdapter(this,R.layout.custom_listview,mlist);
        listView.setAdapter(adapter);
        journalCloudEndPoint.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot noteSnapshot: dataSnapshot.getChildren()){
                    JournalEntry note = noteSnapshot.getValue(JournalEntry.class);
                    int kt=0;
                    for(int i=0;i<mlist.size();i++)
                        if(mlist.get(i).getJournalId()==note.getJournalId()) { kt=1; break;}
                    if(kt==0)
                    {
                        mlist.add(note);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        //nhan lau vao item thi se xoa du lieu cua item do tren firebase va trong list
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                journalCloudEndPoint.child(mlist.get(i).getJournalId()).removeValue();//xoa du lieu cua item tren firebase
                mlist.remove(i);//xóa phần tử thứ i
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        //kich vao nut cheo thi se xoa du lieu cua item do tren firebase va trong list
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                ImageView imdelete=(ImageView) findViewById(R.id.imdelete);
                imdelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        journalCloudEndPoint.child(mlist.get(i).getJournalId()).removeValue();//xoa du lieu cua item tren firebase
                        mlist.remove(i);//xóa phần tử thứ i
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });*/
    }
//    private void addInitialDataToFirebase() {
//
//        List<JournalEntry> sampleJournalEntries = Data.getSampleJournalEntries();
//        for (JournalEntry journalEntry: sampleJournalEntries){
//            String key = journalCloudEndPoint.push().getKey();
//            journalEntry.setJournalId(key);
//            journalCloudEndPoint.child(key).setValue(journalEntry);
//        }
//    }
}

