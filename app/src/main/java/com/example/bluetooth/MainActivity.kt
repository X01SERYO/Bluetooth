package com.example.bluetooth

import android.bluetooth.BluetoothAdapter
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    object Global {
        var imagenBluetooth: ImageView? = null
        var adaptadorBluetooth : BluetoothAdapter? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Global.imagenBluetooth = this.findViewById<ImageView>(R.id.imageView)
        Global.adaptadorBluetooth = BluetoothAdapter.getDefaultAdapter()
        if (Global.adaptadorBluetooth==null) {
            Global.imagenBluetooth!!.visibility = View.GONE
        }else {
            setImageBlue(Global.adaptadorBluetooth!!.isEnabled)
        }
    }

    fun setImageBlue(valor:Boolean){
        if(valor){
            textView.text="Activado"
        }else{
            textView.text="Desactivado"
        }
    }

    fun onClickImage(v:View){
        setEstadoBlue()
    }

    fun setEstadoBlue(){
        if(Global.adaptadorBluetooth!!.isEnabled){
            setImageBlue(false)
            Global.adaptadorBluetooth!!.disable()
        }else{
            setImageBlue(true)
            Global.adaptadorBluetooth!!.enable()
        }
    }
}