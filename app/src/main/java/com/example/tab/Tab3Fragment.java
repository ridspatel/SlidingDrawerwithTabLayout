package com.example.tab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slidingdrawerwithtablayout.R;

public class Tab3Fragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_third_tab,
				container, false);

		// Inflate the layout for this fragment
		return rootView;
	}

	public static Tab3Fragment newInstance() {
		Tab3Fragment s = new Tab3Fragment();

		return s;
	}

}
