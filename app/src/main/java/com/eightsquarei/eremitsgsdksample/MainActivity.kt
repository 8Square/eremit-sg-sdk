package com.eightsquarei.eremitsgsdksample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.m1remit.EremitSdk
import com.app.m1remit.model.enum_type.Env
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startSdkButton.setOnClickListener {
            EremitSdk.Builder()
                .apiKey("api_key_here")
                .env(Env.UAT)
                .build().start(this)
        }
    }
}