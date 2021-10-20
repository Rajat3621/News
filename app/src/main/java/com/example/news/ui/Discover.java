package com.example.news.ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.news.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Discover#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Discover extends Fragment {

    View view;
    String tag;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Discover() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Discover.
     */
    // TODO: Rename and change types and number of parameters
    public static Discover newInstance(String param1, String param2) {
        Discover fragment = new Discover();
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
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_discover, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayout layout=(LinearLayout) view.findViewById(R.id.layout1);
        LinearLayout layout2=(LinearLayout)view.findViewById(R.id.layout2);
        LinearLayout layout3=(LinearLayout)view.findViewById(R.id.layout3);
        LinearLayout layout4=(LinearLayout)view.findViewById(R.id.layout4);
        LinearLayout layout5=(LinearLayout)view.findViewById(R.id.layout5);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NewsFragment nextFrag=new NewsFragment();
                Bundle args=new Bundle();
                //  args.putInt("position",bCatArrayList.get(i).getCategoryId());
                args.putString("SearchName","business");
                nextFrag.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,nextFrag)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();

            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NewsFragment nextFrag=new NewsFragment();
                Bundle args=new Bundle();
                //  args.putInt("position",bCatArrayList.get(i).getCategoryId());
                args.putString("SearchName","food");
                nextFrag.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,nextFrag)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();

            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NewsFragment nextFrag=new NewsFragment();
                Bundle args=new Bundle();
                //  args.putInt("position",bCatArrayList.get(i).getCategoryId());
                args.putString("SearchName","fashion");
                nextFrag.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,nextFrag)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();

            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NewsFragment nextFrag=new NewsFragment();
                Bundle args=new Bundle();
                //  args.putInt("position",bCatArrayList.get(i).getCategoryId());
                args.putString("SearchName","movies");
                nextFrag.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,nextFrag)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();

            }
        });
        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NewsFragment nextFrag=new NewsFragment();
                Bundle args=new Bundle();
                //  args.putInt("position",bCatArrayList.get(i).getCategoryId());
                args.putString("SearchName","climate");
                nextFrag.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment,nextFrag)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();

            }
        });
    }


}
