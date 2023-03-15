package com.example.calendarplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class ReminderDetailActivity extends AppCompatActivity {

    private EditText titleEditText, descEditText;
    private Button deletedButton;

    private Reminder selectedReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_detail);
        initWidgets();
        checkForEditNote();
    }

    private void initWidgets()
    {
        titleEditText = findViewById(R.id.titleEditText);
        descEditText = findViewById(R.id.descriptionEditText);
        deletedButton = findViewById(R.id.deletedReminderButton);
    }

    private void checkForEditNote()
    {
        Intent previousIntent = getIntent();

        int passedReminderID = previousIntent.getIntExtra(Reminder.REMINDER_EDIT_EXTRA, -1);
        selectedReminder = Reminder.getReminderForID(passedReminderID);

        if (selectedReminder != null)
        {
            titleEditText.setText(selectedReminder.getTitle());
            descEditText.setText(selectedReminder.getDescription());
        }
        else
        {
            deletedButton.setVisibility(View.INVISIBLE);
        }
    }

    public void saveReminder(View view)
    {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        String title = String.valueOf(titleEditText.getText());
        String desc = String.valueOf(descEditText.getText());

        if(selectedReminder == null)
        {
            int id = Reminder.reminderArrayList.size();
            Reminder newNote = new Reminder(id, title, desc);
            Reminder.reminderArrayList.add(newNote);
            sqLiteManager.addNoteToDatabase(newNote);
        }
        else
        {
            selectedReminder.setTitle(title);
            selectedReminder.setDescription(desc);
            sqLiteManager.updateNoteInDB(selectedReminder);
        }

        finish();
    }


    public void deleteReminder(View view)
    {
        selectedReminder.setDeleted(new Date());
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.updateNoteInDB(selectedReminder);
        finish();
    }
}
