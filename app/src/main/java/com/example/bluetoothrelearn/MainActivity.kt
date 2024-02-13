package com.example.bluetoothrelearn

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityManagerCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    final val REQEST_BLUETOOTH = 2
    private final val tag = "BLUETOOTH APP"
    final val REQUEST_PERMISSIONS = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION,android.Manifest.permission.BLUETOOTH,android.Manifest.permission.BLUETOOTH_ADVERTISE,android.Manifest.permission.BLUETOOTH_CONNECT,android.Manifest.permission.BLUETOOTH_SCAN,android.Manifest.permission.BLUETOOTH_ADMIN)
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sdkNumber = Build.VERSION.SDK_INT
        if (sdkNumber < Build.VERSION_CODES.S){
            Log.e(tag,"OREO")
        }else if ( sdkNumber < Build.VERSION_CODES.TIRAMISU ){
            Log.e(tag, "S")
        }else{
            Log.e(tag,"TIRAMISU")
        }
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            Log.e(tag, "GRANTED")
        }else{
            Log.e(tag, "NOT GRANTED")
            ActivityCompat.requestPermissions(this,REQUEST_PERMISSIONS,REQEST_BLUETOOTH)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }
}