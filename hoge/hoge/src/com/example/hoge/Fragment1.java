package com.example.hoge;

import java.util.ArrayList;
import java.util.List;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class Fragment1 extends Fragment implements OnClickListener{
	
  List<CustomData> objects = new ArrayList<CustomData>();
  CustomAdapter customAdapter;
  Bitmap image;
  
  @Override
  public View onCreateView(
    LayoutInflater inflater,
    ViewGroup container,
    Bundle savedInstanceState) {
	  customAdapter = new CustomAdapter(getActivity(), 0, objects);
	  image = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
	  
      View v = inflater.inflate(R.layout.fragment1, container, false);

      Button addButton = (Button)v.findViewById(R.id.button1);
      addButton.setOnClickListener(this);
      
      ListView listView = (ListView)v.findViewById(R.id.listView1);
      listView.setAdapter(customAdapter);
      
      return v;
  }
  
  @Override
  public void onClick(View v){
	  switch(v.getId()){
	  case R.id.button1:
		  addItem();
		  break;
	  }
  }

  protected void addItem(){
      CustomData item = new CustomData();

      
	  item.setImageData(image);
	  item.setTextData("hoge");
	  objects.add(item);
	  customAdapter.notifyDataSetChanged();
	  
  }
  

  
  
}