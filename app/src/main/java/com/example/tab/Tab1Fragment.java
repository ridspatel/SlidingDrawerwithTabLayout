package com.example.tab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slidingdrawerwithtablayout.R;

public class Tab1Fragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_first_tab,
				container, false);

		// Inflate the layout for this fragment
		return rootView;
	}

	public static Tab1Fragment newInstance() {
		Tab1Fragment s = new Tab1Fragment();

		return s;
	}

}
