package com.ibra.moviesseries.ui;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.ViewPagerAdapter;
import com.ibra.moviesseries.fragment.CastFragment;
import com.ibra.moviesseries.fragment.InfoFragment;
import com.ibra.moviesseries.fragment.SimilarFragment;
import com.ibra.moviesseries.fragment.VideoFragment;
import com.ibra.moviesseries.retrofit.show.Show;
import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();



    @BindView(R.id.tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    public Show show;
    public String type;

    private Fragment[]fragments = {new InfoFragment(),new CastFragment(),new VideoFragment(),new SimilarFragment()};
    private String[]tabNames = {"INFO","CAST","VIDEOS","SIMILAR"};

    private ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        // get show detail
        Intent intent = getIntent();
        if (intent != null && intent.getParcelableExtra("show") != null) {
            show = intent.getParcelableExtra("show");
            type = intent.getStringExtra("type");

        }

        // setup toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(show.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // setup viewpager
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments,tabNames,type);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}


