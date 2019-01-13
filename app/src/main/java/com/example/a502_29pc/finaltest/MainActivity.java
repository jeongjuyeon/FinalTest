package com.example.a502_29pc.finaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.a502_29pc.finaltest.adapters.StoreAdapter;
import com.example.a502_29pc.finaltest.datas.Store;
import com.example.a502_29pc.finaltest.utils.ConnectServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    ListView storeListView;
    List<Store> storeList = new ArrayList<Store>();
    StoreAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        mAdapter = new StoreAdapter(mContext, storeList);
        storeListView.setAdapter(mAdapter);

        getStoreFromServer();

    }


    void getStoreFromServer() {

        ConnectServer.getRequestCompany(mContext, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                Log.d("택배사목록", json.toString());

                try {
                    int code = json.getInt("code");

                    if (code == 200) {
                        JSONObject data = json.getJSONObject("data");
                        JSONArray store = data.getJSONArray("company");

                        for (int i = 0; i < store.length(); i++) {
                            JSONObject storeJson = store.getJSONObject(i);

                            Store storeObject = Store.getStoreFromJson(storeJson);
                            storeList.add(storeObject);
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAdapter.notifyDataSetChanged();

                            }
                        });


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }




    @Override
    public void bindViews() {

        storeListView = findViewById(R.id.storeListView);

    }
}
