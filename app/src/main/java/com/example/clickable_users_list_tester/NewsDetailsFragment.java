package com.example.clickable_users_list_tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class NewsDetailsFragment extends Fragment implements View.OnClickListener {
    private TextView newsHeading;
    private ImageView imageResourceID;
    AppCompatButton btnAdd, btnDelete, btnNotes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_details, container, false);

        imageResourceID = view.findViewById(R.id.imageView);
        newsHeading = view.findViewById(R.id.titleTextView);

        btnAdd = view.findViewById(R.id.btnAddTask);
        btnDelete = view.findViewById(R.id.btnDeleteUser);
        btnNotes = view.findViewById(R.id.btnNotes);

        Bundle args = getArguments();
        if (args != null) {
            String userName = args.getString("userName");
            int userImageResource = args.getInt("userImage");

            newsHeading.setText(userName);
            imageResourceID.setImageResource(userImageResource);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        /*
        switch(v.getId()){
            case R.id.btnAddTask:
                AddTaskFragment addTaskFragment = new AddTaskFragment();
                openFragment(addTaskFragment);
                break;
            case R.id.btnNotes:
                ClientNotesFragment clientNotesFragment = new ClientNotesFragment();
                openFragment(clientNotesFragment);
                break;
            case R.id.btnDeleteUser:
                DeleteClientFragment deleteClientFragment = new DeleteClientFragment();
                openFragment(deleteClientFragment);
                break;
        }

         */
    }

    public void openFragment(Fragment _fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, _fragment)
                .addToBackStack(null)
                .commit();
    }
}
