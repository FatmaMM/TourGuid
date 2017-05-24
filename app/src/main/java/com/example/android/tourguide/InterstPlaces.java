package com.example.android.tourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class InterstPlaces extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interst_places);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_interst_places, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int mColumnCount = 2;
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                View rootView = inflater.inflate(R.layout.fragment_interst_places, container, false);

                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
                ArrayList<HisPlace> hisPlaces = new ArrayList<>();

                hisPlaces.add(new HisPlace(getString(R.string.McDonald_name), getString(R.string.McDonald_address), R.drawable.mcdonals));
                hisPlaces.add(new HisPlace(getString(R.string.Welatain_name), getString(R.string.Welatain_address), R.drawable.welaten));
                hisPlaces.add(new HisPlace(getString(R.string.KFC_name), getString(R.string.KFC_address), R.drawable.kfc));
                hisPlaces.add(new HisPlace(getString(R.string.Pizza_Hut_name), getString(R.string.Pizza_Hut_address), R.drawable.pizzahut));
                hisPlaces.add(new HisPlace(getString(R.string.Basmatio_Chicken_name), getString(R.string.Basmatio_Chicken_address), R.drawable.basmatyo));
                hisPlaces.add(new HisPlace(getString(R.string.Cook_Door_name), getString(R.string.Cook_Door_address), R.drawable.cookdoor));
                hisPlaces.add(new HisPlace(getString(R.string.Bahia_Resturant_name), getString(R.string.Basmatio_Chicken_address), R.drawable.bahia));
                hisPlaces.add(new HisPlace(getString(R.string.Happy_Dolphin_name), getString(R.string.Happy_Dolphin_address), R.drawable.happydolphin));
                hisPlaces.add(new HisPlace(getString(R.string.Bondoka_name), getString(R.string.Bondoka_address), R.drawable.bondoka));
                hisPlaces.add(new HisPlace(getString(R.string.Momen_name), getString(R.string.Momen_address), R.drawable.momen));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(new HisPlaceAdapter(hisPlaces));
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mColumnCount));

                return rootView;

            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {

                View view = inflater.inflate(R.layout.fragment_restrants_list, container, false);
                ListView listView = (ListView) view.findViewById(R.id.list);


                final ArrayList<HisPlace> hisPlaces = new ArrayList<>();
                hisPlaces.add(new HisPlace(getString(R.string.Alexan_Abaskhiron_Palace_name), getString(R.string.Alexan_Abaskhiron_Palace_address), getString(R.string.Alexan_Abaskhiron_Palace_year), R.drawable.alexanabaskhironp, 1));
                hisPlaces.add(new HisPlace(getString(R.string.Mir_Monuments_name), getString(R.string.Mir_Monuments_address), getString(R.string.Mir_Monuments_year), R.drawable.mirpl, 2));
                hisPlaces.add(new HisPlace(getString(R.string.Saint_Mary_name)
                        , getString(R.string.Saint_Mary_address), getString(R.string.Saint_Mary_year), R.drawable.da, 3));
                hisPlaces.add(new HisPlace(getString(R.string.Assiut_Islamic_name), getString(R.string.Assiut_Islamic_address)
                        , getString(R.string.Assiut_Islamic_year), R.drawable.fouad, 4));

                HistoricalplaceAdapter Adapter = new HistoricalplaceAdapter(getActivity(), hisPlaces);
                listView.setAdapter(Adapter);

                return view;

            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                View rootView = inflater.inflate(R.layout.fragment_interst_places, container, false);

                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
                ArrayList<HisPlace> hisPlaces = new ArrayList<>();
                hisPlaces.add(new HisPlace(getString(R.string.San_Marion_name) + "", getString(R.string.San_Marion_address) + "", R.drawable.sunmarion));
                hisPlaces.add(new HisPlace(getString(R.string.Alfrdos_name) + "", getString(R.string.Alfrdos_address) + "", R.drawable.alfrdos));
                hisPlaces.add(new HisPlace(getString(R.string.Dandy_Park_name), getString(R.string.Dandy_Park_address), R.drawable.dandypark));
                hisPlaces.add(new HisPlace(getString(R.string.Armed_Forces_Club), getString(R.string.Armed_Forces_Club_address), R.drawable.armedforces));
                hisPlaces.add(new HisPlace(getString(R.string.DownTown_name), getString(R.string.DownTown_address), R.drawable.downtown));
                recyclerView.setAdapter(new HisPlaceAdapter(hisPlaces));
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                return rootView;
            } else {
                View rootView = inflater.inflate(R.layout.fragment_interst_places, container, false);
                RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
                ArrayList<HisPlace> hisPlaces = new ArrayList<>();
                hisPlaces.add(new HisPlace(getString(R.string.Cemex_name), getString(R.string.Cemex_address),getString(R.string.Cemex_phone), R.drawable.cemexhotel));
                hisPlaces.add(new HisPlace(getString(R.string.ArmedForces_name), getString(R.string.ArmedForces_address),getString(R.string.ArmedForces_phone), R.drawable.armedforce));
                hisPlaces.add(new HisPlace(getString(R.string.assiutel_name), getString(R.string.assiutel_addess),getString(R.string.assiutel_phone), R.drawable.assiutel));
                hisPlaces.add(new HisPlace(getString(R.string.Tut_name), getString(R.string.Tut_address),getString(R.string.Tut_phone), R.drawable.tut));
                hisPlaces.add(new HisPlace(getString(R.string.Opera_Hotel_name), getString(R.string.Opera_Hotel_address),getString(R.string.Oper_Hotel_phon), R.drawable.operhotel));
                recyclerView.setAdapter(new HisPlaceAdapter(hisPlaces));
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                return rootView;

            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.Historical_places) + "";

                case 1:
                    return getString(R.string.Resturants) + "";
                case 2:
                    return getString(R.string.parks) + "";
                case 3:
                    return getString(R.string.Hotels) + "";
            }
            return null;
        }
    }
}
