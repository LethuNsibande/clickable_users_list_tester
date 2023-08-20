package com.example.clickable_users_list_tester;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import java.text.MessageFormat;

public class CustomDialogActivity extends Activity {
    Dialog dialog;
    AppCompatButton btnCustomDialog, btnDialogCancel, btnDialogAdd;
    ImageView imgDateSelection;
    EditText txtDialogCompletionDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        dialog = new Dialog(CustomDialogActivity.this);
        dialog.setContentView(R.layout.layout_add_task_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        txtDialogCompletionDate = dialog.findViewById(R.id.txtDialogCompletionDate);

        btnCustomDialog = findViewById(R.id.btnCustomDialog);
        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        imgDateSelection = dialog.findViewById(R.id.imgDialogDateSelection);
        imgDateSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDateDialog();
            }
        });

        btnDialogCancel = dialog.findViewById(R.id.btnDialogCancel);
        btnDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnDialogAdd = dialog.findViewById(R.id.btnDialogAdd);
        btnDialogAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(CustomDialogActivity.this, "Add button clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openDateDialog() {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                txtDialogCompletionDate.setText(MessageFormat.format("{0}/{1}/{2}", String.valueOf(year), String.valueOf(month + 1), day));
            }
        }, 2024, 01, 01);

        dialog.show();
    }
}
