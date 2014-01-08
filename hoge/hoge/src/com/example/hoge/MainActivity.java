package com.example.hoge;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.app.Fragment;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    final ActionBar actionBar = getActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    actionBar.addTab(actionBar
      .newTab()
      .setText("生徒一覧")
      .setTabListener(
        new MainTabListener<Fragment1>(
          this,
          "f1",
          Fragment1.class
        )
      )
    );
    actionBar.addTab(actionBar
      .newTab()
      .setText("出席済み")
      .setTabListener(
        new MainTabListener<Fragment2>(
          this,
          "f2",
          Fragment2.class
        )
      )
    );
    actionBar.addTab(actionBar
    	      .newTab()
    	      .setText("未出席")
    	      .setTabListener(
    	        new MainTabListener<Fragment3>(
    	          this,
    	          "f3",
    	          Fragment3.class
    	        )
    	      )
    	    );
    }
    
  public static class MainTabListener<T extends Fragment> 
    implements TabListener {
    
    private Fragment fragment;
    private final Activity activity;
    private final String tag;
    private final Class<T> cls;
    
    public MainTabListener(
      Activity activity, String tag, Class<T> cls){
      this.activity = activity;
      this.tag = tag;
      this.cls = cls;
    }
      
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
      if(fragment == null){
        fragment = Fragment.instantiate(activity, cls.getName());
        ft.add(android.R.id.content, fragment, tag);
      }
      else{
        ft.attach(fragment);
      }      
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
      if(fragment != null){
        ft.detach(fragment);
      }      
    }
    }
}