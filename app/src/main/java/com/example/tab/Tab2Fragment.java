package com.example.tab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slidingdrawerwithtablayout.R;

public class Tab2Fragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_second_tab,
				container, false);

		// Inflate the layout for this fragment
		return rootView;
	}

	public static Tab2Fragment newInstance() {
		Tab2Fragment s = new Tab2Fragment();

		return s;
	}

}
