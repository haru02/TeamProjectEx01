package com.teamproject.froze.teamproject01;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_p2 extends Fragment {

    private OnFragmentInteractionListener_p2 mListener;
    boolean clicktoFrag3=false;
    int FragmentNumber = 2;

    public Fragment_p2() {
        // Required empty public constructor
    }


    public static Fragment_p2 newInstance(String param1, String param2) {
        Fragment_p2 fragment = new Fragment_p2();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_p2, container, false);


        return view;
    }


/*    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener_p2) {
            mListener = (OnFragmentInteractionListener_p2) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    public interface OnFragmentInteractionListener_p2 {

        public void onFragmentInteraction_p2(int fragNum);

    }
}
