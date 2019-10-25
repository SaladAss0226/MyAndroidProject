package com.example.googlemap_pra

import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),OnMapReadyCallback {


    lateinit var mMap: GoogleMap
    private val REQUEST_PERMISSIONS = 1

    //權限要求結果
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(grantResults.isEmpty()) return

        when(requestCode){
            REQUEST_PERMISSIONS ->{
                for(result in grantResults)
                    if(result != PackageManager.PERMISSION_GRANTED)
                        finish()         //若使用者拒絕給予權限則關閉app
                    else{                       //連接mapFragment物件
                        val map = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
                        map.getMapAsync(this)
                    }

            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //檢查使用者是否已授權粗略定位權限
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED)
            //檢查使用者是否已授權精確定位權限
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_PERMISSIONS)
        else {  //連接mapFragment
            val map = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
            map.getMapAsync(this)
        }
    }

    override fun onMapReady(map: GoogleMap?) {
        //檢查使用者是否已授權粗略定位權限
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        )
        //檢查使用者是否已授權精確定位權限
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_PERMISSIONS
            )
        return

        //顯示目前位置與按鈕
        map?.isMyLocationEnabled = true

        //建立markerOption物件
        val marker = MarkerOptions()

        marker.position(LatLng(25.033611,121.565000))
        marker.title("台北101")
        marker.draggable(true)      //設定是否可拖曳
        map?.addMarker(marker)

        marker.position(LatLng(25.047924,121.517081))
        marker.title("台北車站")
        marker.draggable(true)
        map?.addMarker(marker)

        //建立PolylineOption物件
        val polylineOpt = PolylineOptions()
        //設定3個線段會通過的座標
        polylineOpt.add(LatLng(25.033611,121.565000))
        polylineOpt.add(LatLng(25.032728,121.565137))
        polylineOpt.add(LatLng(25.047924,121.517081))
        //設定線段顏色
        polylineOpt.color(Color.BLUE)
         val polyline = map?.addPolyline(polylineOpt)
        //線段寬度
        polyline?.width = 10f

        //移動鏡頭
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(25.034,121.545),13f))

    }
}

