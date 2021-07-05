package com.example.s1122207_s1094387_iiatimd_app;

import android.util.Log;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;


public class FetchMedicineRequest {
    public final static String MEDICINE_URL = "http://127.0.0.1:8000/api/medicines";

       public static  JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, MEDICINE_URL, null,
                        response -> Log.d("onResponse", response.toString()),
                        error    -> Log.e("Fetch error",
                                        "Something somewhere went terribly wrong while " +
                                                "fetching the medicines array from the API.")
                );

}
