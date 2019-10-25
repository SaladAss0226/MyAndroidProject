package com.example.goolemap_pra02

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    //設定一個移動地圖鏡頭的方法
    private fun moveMap(place:LatLng){
        val cameraPosition = CameraPosition.Builder().target(place)
            .zoom(17f)
            .build()
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))   //用動畫來移動鏡頭
    }

    //設定一個輸入經緯及標題就可以標記位置的方法
    private fun adMarkr(place:LatLng,title:String,context:String){
        val markerOptions = MarkerOptions()
        markerOptions.position(place)
            .title(title)
            .snippet(context)
        mMap.addMarker(markerOptions)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val place = LatLng(25.033408,121.564099)
        moveMap(place)                  //呼叫上面設好的方法來移動鏡頭
        adMarkr(place,"hey,I'm here!!","Leon's house")

        //建立PolylineOption物件
        val polylineOpt = PolylineOptions()
        //設定3個線段會通過的座標
        polylineOpt.add(LatLng(25.033611,121.565000))
        polylineOpt.add(LatLng(25.032728,121.565137))
        polylineOpt.add(LatLng(25.047924,121.517081))
        //設定線段顏色
        polylineOpt.color(Color.BLUE)
        val polyline = mMap.addPolyline(polylineOpt)
        //線段寬度
        polyline?.width = 10f


        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
