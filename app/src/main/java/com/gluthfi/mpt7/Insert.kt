package com.gluthfi.mpt7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_insert.*
import org.json.JSONArray

class Insert : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        saveBtn.setOnClickListener {
            var namaMhs = namaInput.text.toString()
            var noMhs= noInput.text.toString()
            var alamatMhs = alamatInput.text.toString()

            postkeserver(namaMhs, noMhs, alamatMhs)

            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }

        backInsert.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun postkeserver(data1:String, data2:String, data3:String) {
        AndroidNetworking.post("http://192.168.0.90/lat_mahasiswa/insert.php")
            .addBodyParameter("nama_mahasiswa", data1)
            .addBodyParameter("no_mahasiswa", data2)
            .addBodyParameter("alamat_mahasiswa", data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                    Log.i("Uji Coba", "Sukses")
                    Toast.makeText(applicationContext,"Berhasil insert!", Toast.LENGTH_LONG).show()
                }

                override fun onError(anError: ANError?) {
                    Log.i("Uji Coba", "Mandul")
                }
            })
    }
}
