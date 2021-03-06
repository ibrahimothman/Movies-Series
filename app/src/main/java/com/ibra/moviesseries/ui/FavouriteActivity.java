package com.ibra.moviesseries.ui;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.ibra.moviesseries.R;
import com.ibra.moviesseries.adapter.FavouriteAdapter;
import com.ibra.moviesseries.data.Contract;
import com.ibra.moviesseries.retrofit.show.Show;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        LoaderManager.LoaderCallbacks<Cursor>{

    private static final int FAV_LOADER = 2;
    private static final String TAG = FavouriteActivity.class.getSimpleName();
    @BindView(R.id.fav_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.progress_bar_fav)
    ProgressBar mProgressBar;
    @BindView(R.id.fav_main_layout)
    RelativeLayout layout;

    RecyclerView.LayoutManager layoutManager;
    FavouriteAdapter favouriteAdapter;
    List<Show> showList = new ArrayList<>();
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.fav_activity_title));
        toolbar.setTitleTextColor(Color.WHITE);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // setup favourite recycler view
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        favouriteAdapter = new FavouriteAdapter(this,showList);
        mRecyclerView.setAdapter(favouriteAdapter);

        // setup recycler swip
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Show deletedShow = favouriteAdapter.getShow(viewHolder.getAdapterPosition());
                final int deletedIndex = viewHolder.getAdapterPosition();
                itemId = (int) viewHolder.itemView.getTag();
                favouriteAdapter.remove(deletedIndex);
                showSnackbar(deletedShow,deletedIndex);

            }
        };

        new ItemTouchHelper(callback).attachToRecyclerView(mRecyclerView);
        getSupportLoaderManager().initLoader(FAV_LOADER,null,this);


    }

    private void deleteFromDb() {
        getContentResolver().delete(ContentUris.withAppendedId(Contract.FavEntry.CONTENT_URI,itemId),null,null);
        Log.d(TAG,"id is "+itemId);
    }

    private void showSnackbar(final Show show,final int position) {
        Snackbar snackbar = Snackbar.make(layout,"Are you sure",Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // undo
                favouriteAdapter.restore(show,position);
            }
        });
        snackbar.addCallback(new Snackbar.Callback() {

            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                //see Snackbar.Callback docs for event details
                if(event == BaseTransientBottomBar.BaseCallback.DISMISS_EVENT_TIMEOUT){
                    // delete from db
                    deleteFromDb();
                }

            }

            @Override
            public void onShown(Snackbar snackbar) {

            }
        });

        snackbar.show();
    }




        @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Intent searchIntent = new Intent(this,SearchActivity.class);
            startActivity(searchIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id == R.id.nav_movies){
            Intent movieIntent = new Intent(this,HomeActivity.class);
            startActivity(movieIntent);
        }else if(id == R.id.nav_tvshow){
            Intent SeriesIntent = new Intent(this,SeriesActivity.class);
            startActivity(SeriesIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new CursorLoader(this, Contract.FavEntry.CONTENT_URI,null,null,null, Contract.FavEntry.TIME);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        if(data != null){
            mProgressBar.setVisibility(View.INVISIBLE);
            showList.clear();
            data.moveToFirst();
            do {
                Show show = new Show();
                show.setMovieId(data.getInt(data.getColumnIndex(Contract.FavEntry._ID)));
                show.setMovieOverview(data.getString(data.getColumnIndex(Contract.FavEntry.OVERVIEW_COL)));
                show.setMoviePoster(data.getString(data.getColumnIndex(Contract.FavEntry.POSTER_COL)));
                show.setMovieVoteAverage(data.getInt(data.getColumnIndex(Contract.FavEntry.RATE_COL)));
                show.setTitle(data.getString(data.getColumnIndex(Contract.FavEntry.TITLE_COL)));
                show.setReleaseDate(data.getString(data.getColumnIndex(Contract.FavEntry.RELEASE_DATE_COL)));
                showList.add(show);
            }while (data.moveToNext());

            favouriteAdapter.swipCursor(showList);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }



}