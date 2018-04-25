package com.example.kcruz.seriesapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SeriesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SeriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeriesFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    /*View view;
    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    LinearLayoutManager lManager;*/
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String  mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerSeries;
    ArrayList<Serie> seriesList;

    public SeriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeriesFragment newInstance(String param1, String param2) {
        SeriesFragment fragment = new SeriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        // genera instance
        seriesList = new ArrayList<>();
        recyclerSeries = view.findViewById(R.id.recycler_series_Id); //no s usa findView directamente sino que se usa la vista como intermediario
        recyclerSeries.setLayoutManager(new LinearLayoutManager(getContext()));//indicando que tipo de recycler se necesita

        prepareSeries();

        SeriesAdapter adapter = new SeriesAdapter(seriesList);
        recyclerSeries.setAdapter(adapter);
        /*series = new ArrayList<>();
        rv = ;
        rv.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lManager);

        prepareSeries();

        adapter = new SeriesAdapter(series);
        rv.setAdapter(adapter);*/
        // Inflate the layout for this fragment
        return view;
    }

    public void prepareSeries(){
        String TAG = "Mensaje";
        /*informacion quemada de los cardview, al usar base de datos esto es lo unico que cambia
        * porque se pone con la notacion de sql lite*/
        seriesList.add(new Serie("Flash","13", R.drawable.flash, "TV show created by Robert"));
        seriesList.add(new Serie("The Walking Dead","13", R.drawable.twd, "TV show created by Robert"));
        seriesList.add(new Serie("Breaking bad","13", R.drawable.bbad, "TV show created by Vince Gilligan"));
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
