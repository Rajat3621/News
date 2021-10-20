package com.example.news.ui;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.news.Adapter.RecyclerAdapter;
import com.example.news.Models.BannerDetails;
import com.example.news.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFeed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFeed extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view;
    private String serverurl= "http://192.168.29.195/mlv/"+"topFeed.php";
    private ArrayList<BannerDetails> bannerdata=new ArrayList<BannerDetails>();
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ProgressDialog progressDialog;

    public MyFeed() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyFeed.
     */
    // TODO: Rename and change types and number of parameters
    public static MyFeed newInstance(String param1, String param2) {
        MyFeed fragment = new MyFeed();
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
        view =inflater.inflate(R.layout.fragment_my_feed, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerAdapter=new RecyclerAdapter(this,bannerdata);
        recyclerView.setAdapter(recyclerAdapter);

        cfetch();
    }
    private void cfetch()
    {
        progressDialog= ProgressDialog.show(MyFeed.this.getActivity(),"","Please Wait",true);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, serverurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        progressDialog.dismiss();
                        Log.e("status",response);
                        bannerdata.clear();
                        Log.e("j","gr");
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("results");
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject results = jsonArray.getJSONObject(i);
                                String s = results.getString("title");
                                String url=results.getString("url");
                                JSONArray jsonArray1=results.getJSONArray("media");
                                JSONObject jsonObject1=jsonArray1.getJSONObject(0);
                                JSONArray jsonArray2=jsonObject1.getJSONArray("media-metadata");
                                JSONObject jsonObject2=jsonArray2.getJSONObject(0);
                                String img=jsonObject2.getString("url");
                                //String img = results.getString("thumbnail_standard");
                                BannerDetails bannerDetails = new BannerDetails(i,s,img,url);
                                bannerdata.add(bannerDetails);
                            }
                            recyclerAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",error.getMessage()+"");
                progressDialog.dismiss();
                Toast.makeText(MyFeed.this.getActivity(),"Connection Time Out!",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this.getActivity());
        queue.add(stringRequest);
    }
}