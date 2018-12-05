package asha.dshm.asha2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import asha.dshm.asha2.Adapters.FormChoiceAdapter;

public class ActivityChoice extends AppCompatActivity
        implements FormChoiceAdapter.ListItemClickListener {

    private static final int NUM_FORM_ITEMS = 10;
    private RecyclerView mFormChoiceList;
    private FormChoiceAdapter adapter;
    private List<SubActivityDetails> albumList;
    static String lan = "en_US";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ac);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        initCollapsingToolbar();

        mFormChoiceList = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new FormChoiceAdapter(albumList, NUM_FORM_ITEMS, this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mFormChoiceList.setHasFixedSize(true);
        mFormChoiceList.setLayoutManager(mLayoutManager);
        mFormChoiceList.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        mFormChoiceList.setItemAnimator(new DefaultItemAnimator());
        mFormChoiceList.setAdapter(adapter);
        prepareAlbums();

        Intent intent = getIntent();
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String lan = settings.getString("LANG", "en");
        Configuration config = getBaseContext().getResources().getConfiguration();
        if (!Locale.getDefault().toString().equals(lan)) {

            System.out.println("not changed to  " + lan);
            setLangRecreate(lan);

        }

        String lang = settings.getString("LANG", lan);
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang)) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setLangRecreate(String langval) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        Locale locale = new Locale(langval);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);


        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
//                R.drawable.sanitation,
//                R.drawable.senior,
//                R.drawable.malnourished,
//                R.drawable.child,
//                R.drawable.child,
//                R.drawable.birth,
//                R.drawable.child,
//                R.drawable.cataract,
//                R.drawable.child,
//                R.drawable.blindness,
//                R.drawable.immunization
        };

        albumList.add(new SubActivityDetails(R.string.Act1, 1, covers[0]));
        albumList.add(new SubActivityDetails(R.string.Act2, 2, covers[1]));
        albumList.add(new SubActivityDetails(R.string.Act3, 3, covers[2]));
        albumList.add(new SubActivityDetails(R.string.Act4, 4, covers[3]));
        albumList.add(new SubActivityDetails(R.string.Act5, 5, covers[4]));
        albumList.add(new SubActivityDetails(R.string.Act6, 6, covers[5]));
        albumList.add(new SubActivityDetails(R.string.Act7, 7, covers[6]));
        albumList.add(new SubActivityDetails(R.string.Act8, 8, covers[7]));
        adapter.notifyDataSetChanged();
    }

    /**
     * handling each item click of the recycler view
     *
     * @param clickedListItem
     */
    @Override
    public void onListItemClick(View v,int clickedListItem) {

        Intent intent;
        switch(clickedListItem){
            case 0: {
                intent = new Intent(ActivityChoice.this, FillChoice.class);
                startActivity(intent);
                break;
            }
//            case 1: {
//                intent = new Intent(ActivityChoice.this, Form2.class);
//                startActivity(intent);
//                break;
//            }
//            case 2: {
//                intent = new Intent(ActivityChoice.this, Form3.class);
//                startActivity(intent);
//                break;
//            }
//            case 3: {
//                intent = new Intent(ActivityChoice.this, Form4.class);
//                startActivity(intent);
//                break;
//            }
        }
    }




    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}




