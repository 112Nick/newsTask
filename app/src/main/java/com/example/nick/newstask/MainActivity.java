package com.example.nick.newstask;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        ArticleListFragment list = new ArticleListFragment();
        transaction.add(R.id.container, list);
        transaction.commit();
        list.setOnArticleClickListener(new OnArticleClickListener() {
            @Override
            public void onArticleClick(Article article) {
                transaction.replace(R.id.container, new ArticleFragment());
                transaction.commit();
            }
        });

    }
}
