package com.example.android.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.android.affirmations.adapter.ItemAdapter
import com.example.android.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inisialisasi data
        val myDataSet = Datasource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataSet)
        // Setelan dibawah ini hanya diperlukan untuk meningkatkan performa.
        // Gunakan setelan ini jika Anda mengetahui bahwa perubahan dalam content tidak mengubah ukuran dari layout RecyclerView.
        recyclerView.setHasFixedSize(true)
    }
}