package com.example.create_user;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;




public class Other {

    private static Other instance;
    private RequestQueue queue;
    private static Context context;

    private Other(Context context ){
    context = context;
    queue = getRequestQueue();
    }

    public static synchronized Other getInstance(Context context){
        if(instance == null){
            instance = new Other (context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue()
    {
        if(queue == null)
        {
            queue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return queue;
    }


    public <T> void add_request(Request<T> request){
        queue.add(request);
    }

}
