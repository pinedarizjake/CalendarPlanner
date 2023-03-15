package com.example.calendarplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ReminderAdapter extends ArrayAdapter<Reminder>
{
    public ReminderAdapter(Context context, List<Reminder> reminders)
    {
        super(context, 0, reminders);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Reminder reminder = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.reminder_cell, parent, false);

        TextView title = convertView.findViewById(R.id.cellTitle);
        TextView desc = convertView.findViewById(R.id.cellDesc);

        title.setText(reminder.getTitle());
        desc.setText(reminder.getDescription());

        return convertView;

    }


}
