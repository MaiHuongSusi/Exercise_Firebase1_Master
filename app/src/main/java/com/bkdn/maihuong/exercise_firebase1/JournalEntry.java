package com.bkdn.maihuong.exercise_firebase1;

/**
 * Created by Administrator on 12/10/2017.
 */

public class JournalEntry {
    private String journalId;
    private String title;
    private String content;
    private long dateCreated;
    private long dateModified;


    public JournalEntry(String journalId, String title, String content, long dateCreated, long dateModified, String tagId, String tagName) {
        this.journalId = journalId;
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public JournalEntry() {
    }

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public long getDateModified() {
        return dateModified;
    }

    public void setDateModified(long dateModified) {
        this.dateModified = dateModified;
    }
}
