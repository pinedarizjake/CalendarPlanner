package com.example.calendarplanner;

import java.util.ArrayList;
import java.util.Date;

public class Reminder {

    public static ArrayList<Reminder> reminderArrayList = new ArrayList<>();
    public static String REMINDER_EDIT_EXTRA = "reminderEdit";


    private int id;
    private String title;
    private String description;
    private Date deleted;


    public Reminder(int id, String title, String description, Date deleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deleted = deleted;
    }

    public Reminder(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        deleted = null;
    }

    public static Reminder getReminderForID(int passedReminderID)
    {
        for (Reminder reminder : reminderArrayList)
        {
          if(reminder.getId() == passedReminderID)
              return reminder;
        }
        return null;
    }

    public static ArrayList<Reminder> nonDeletedNotes()
    {
        ArrayList<Reminder> nonDeleted = new ArrayList<>();
        for(Reminder reminder : reminderArrayList)
        {
            if(reminder.getDeleted() == null)
                nonDeleted.add(reminder);
        }

        return nonDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
