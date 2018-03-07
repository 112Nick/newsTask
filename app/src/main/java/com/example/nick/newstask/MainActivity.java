package com.example.nick.newstask;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            ArticleListFragment list = new ArticleListFragment();
            transaction.add(R.id.container, list);
            transaction.commit();
            list.setOnArticleClickListener(new OnArticleClickListener() {
                @Override
                public void onArticleClick(Article article) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", article.getTitle());
                    bundle.putString("content", article.getContent());
                    bundle.putString("date", article.getDate().toString());
                    ArticleFragment articleFragment = new ArticleFragment();
                    articleFragment.setArguments(bundle);
                    final FragmentTransaction transaction2 = manager.beginTransaction();
                    transaction2.replace(R.id.container, articleFragment);
                    transaction2.addToBackStack(null);
                    transaction2.commit();
                }
            });
        } else {
            ArticleListFragment list = new ArticleListFragment();
            transaction.add(R.id.containerList, list);
            transaction.commit();
            list.setOnArticleClickListener(new OnArticleClickListener() {
                @Override
                public void onArticleClick(Article article) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", article.getTitle());
                    bundle.putString("content", article.getContent());
                    bundle.putString("date", article.getDate().toString());
                    ArticleFragment articleFragment = new ArticleFragment();
                    articleFragment.setArguments(bundle);
                    final FragmentTransaction transaction2 = manager.beginTransaction();
                    transaction2.add(R.id.containerArticle, articleFragment);
                    transaction2.commit();
                }
            });
        }



    }
}
