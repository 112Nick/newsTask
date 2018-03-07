package com.example.nick.newstask;

/**
 * Created by nick on 07.03.18.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


public class ArticleFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        View newsView =  inflater.inflate(R.layout.article_fragment, container, false);
        if (bundle != null) {
            String title = bundle.getString("title");
            String date = bundle.getString("date");
            String content = bundle.getString("content");

            TextView dateTxt = newsView.findViewById(R.id.date);
            TextView titleTxt = newsView.findViewById(R.id.title);
            TextView contentTxt = newsView.findViewById(R.id.contentText);
            dateTxt.setText(date);
            titleTxt.setText(title);
            contentTxt.setText(content);


        }

        return newsView;
    }
}