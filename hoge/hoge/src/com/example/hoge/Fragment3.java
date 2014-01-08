package com.example.hoge;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragment3 extends Fragment {
	
	ListView listView;

	
	static List<String> dataList = new ArrayList<String>();
	static ArrayAdapter<String> adapter;
  
  @Override
  public View onCreateView(
    LayoutInflater inflater,
    ViewGroup container,
    Bundle savedInstanceState) {
	dataList.add("hoge");
	adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,dataList);
	listView = new ListView(getActivity());
	listView.setAdapter(adapter);
	return listView;
//    return inflater.inflate(R.layout.fragment1, container, false);
  }
  
}