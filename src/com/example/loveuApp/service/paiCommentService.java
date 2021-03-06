package com.example.loveuApp.service;

import android.content.Context;
import android.util.Log;
import com.example.loveuApp.bean.paiCommentModel;
import com.example.loveuApp.listener.Listener;
import com.example.loveuApp.model.PaiCommentModel;
import com.example.loveuApp.model.PaiModel;
import com.example.loveuApp.util.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.apache.http.Header;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dy on 2016/7/26.
 */
public class paiCommentService {

    public void get(Context context, String url, RequestParams params, Listener listener){
        HttpRequest.get(context, url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.i("information",new String(bytes));
                PaiCommentModel models=new Gson().fromJson(new String(bytes),PaiCommentModel.class);
                listener.onSuccess(models);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.i("information",new String(bytes));
                //List<paiCommentModel> model=new Gson().fromJson(new String(bytes),new TypeToken<LinkedList<paiCommentModel>>(){}.getType());
                listener.onFailure("网络请求失败");
            }
        });
    }

    public void post(Context context, String url, RequestParams params, Listener listener){
        HttpRequest.post(context, url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                PaiCommentModel models=new Gson().fromJson(new String(bytes),PaiCommentModel.class);
                listener.onSuccess(models);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                paiCommentModel model=new Gson().fromJson(new String(bytes),paiCommentModel.class);
                listener.onFailure("网络请求失败");
            }
        });
    }

}
