package com.team41.boromi;

import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.team41.boromi.adapters.PagerAdapter;
import com.team41.boromi.book.BorrowedFragment;
import com.team41.boromi.book.MapFragment;
import com.team41.boromi.book.OwnedFragment;
import com.team41.boromi.book.SearchFragment;
import com.team41.boromi.book.SettingsFragment;
import com.team41.boromi.models.Book;
import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

  private static final String LAYOUT_PARAM1 = "LayoutID";
  private static final String DATA_PARAM2 = "Data";
  private static final String MSG_PARAM3 = "Msg";
  private ViewPager2 viewPager2;
  private PagerAdapter pagerAdapter;
  private TabLayout tabLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_book);

    Toolbar toolbar = (Toolbar) findViewById(R.id.book_toolbar);
    setSupportActionBar(toolbar);

    tabLayout = findViewById(R.id.tabs_main);
    viewPager2 = findViewById(R.id.view_pager_main);
    TabItem tabBorrow = findViewById(R.id.tab_borrowed_books);
    TabItem tabOwned = findViewById(R.id.tab_owned_books);
    TabItem tabSearch = findViewById(R.id.tab_search);
    TabItem tabMap = findViewById(R.id.tab_location);
    TabItem tabSettings = findViewById(R.id.tab_settings);

    // Add fragments for each tab
    pagerAdapter = new PagerAdapter(getSupportFragmentManager(), getLifecycle());
    pagerAdapter
        .addFragment(new Pair<Class<? extends Fragment>, Bundle>(OwnedFragment.class, null));
    pagerAdapter
        .addFragment(new Pair<Class<? extends Fragment>, Bundle>(BorrowedFragment.class, null));
    pagerAdapter
        .addFragment(new Pair<Class<? extends Fragment>, Bundle>(SearchFragment.class, null));
    pagerAdapter.addFragment(new Pair<Class<? extends Fragment>, Bundle>(MapFragment.class, null));
    pagerAdapter
        .addFragment(new Pair<Class<? extends Fragment>, Bundle>(SettingsFragment.class, null));

    // configure viewpager2 and initialize page adapter
    viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    viewPager2.setOffscreenPageLimit(tabLayout.getTabCount());
    viewPager2.setUserInputEnabled(false);
    viewPager2.setAdapter(pagerAdapter);

    tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
      @Override
      public void onTabSelected(Tab tab) {
        viewPager2.setCurrentItem(tab.getPosition());
      }

      @Override
      public void onTabUnselected(Tab tab) {

      }

      @Override
      public void onTabReselected(Tab tab) {

      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.toolbar_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.toolbar_add:
        // TODO add toolbar add logic
        return true;
      case R.id.toolbar_scan:
        // TODO add toolbar scan logic
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }


  public Bundle setupBundle(int layout, ArrayList<Book> data, String messsge) {
    Bundle bundle = new Bundle();
    bundle.putInt(LAYOUT_PARAM1, layout);
    bundle.putSerializable(DATA_PARAM2, data);
    bundle.putString(MSG_PARAM3, messsge);
    return bundle;
  }
}
