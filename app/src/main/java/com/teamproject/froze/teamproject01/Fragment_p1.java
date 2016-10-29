package com.teamproject.froze.teamproject01;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_p1 extends Fragment {

    private OnFragmentInteractionListener mListener;
    boolean clicktoFrag2=false;
    int FragmentNumber = 1;

    public Fragment_p1() {
        // Required empty public constructor
    }

    public static Fragment_p1 newInstance(String param1, String param2) {
        Fragment_p1 fragment = new Fragment_p1();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_p1, container, false);

        return view;
    }

/*    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(int fragNum);

    }
}
