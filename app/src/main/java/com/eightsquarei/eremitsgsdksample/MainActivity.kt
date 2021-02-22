package com.eightsquarei.eremitsgsdksample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eightsquarei.sgsdk.EremitSdk
import com.eightsquarei.sgsdk.model.enum_type.Env
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