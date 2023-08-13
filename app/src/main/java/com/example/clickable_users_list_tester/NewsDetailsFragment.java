package com.example.clickable_users_list_tester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NewsDetailsFragment extends Fragment {
    private TextView newsHeading;
    private ImageView imageResourceID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_details, container, false);

        imageResourceID = view.findViewById(R.id.imageView);
        newsHeading = view.findViewById(R.id.titleTextView);

        Bundle args = getArguments();
        if (args != null) {
            String userName = args.getString("userName");
            int userImageResource = args.getInt("userImage");

            newsHeading.setText(userName);
            imageResourceID.setImageResource(userImageResource);
        }

        return view;
    }
}
