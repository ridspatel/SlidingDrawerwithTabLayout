package com.example.slider;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slidingdrawerwithtablayout.R;

public class FriendsFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_friends, container,
				false);

		// Inflate the layout for this fragment
		return rootView;
	}

	public static FriendsFragment newInstance() {
		FriendsFragment s = new FriendsFragment();

		return s;
	}

}
