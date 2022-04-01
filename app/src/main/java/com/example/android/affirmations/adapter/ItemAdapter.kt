package com.example.android.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.affirmations.R
import com.example.android.affirmations.model.Affirmation

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // RecyclerView.Adapter merupakan class abstrak, dan harus menerapkan method abstraknya disini

//    RecyclerView tidak berinteraksi langsung dengan tampilan item,
//    namun berkaitan dengan ViewHolders.
//    ViewHolder mewakili tampilan item list tunggal di RecyclerView,
//    dan dapat digunakan kembali jika memungkinkan.

    // Menentukan class di dalam class lain disebut membuat class bertingkat.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    // method ini dipanggil utk membuat view holder baru untuk RecyclerView (saat tidak ada holder tampilan yang ada yang dapat digunakan kembali)
    // (dipanggil oleh layout manager)
    // Parameter parent = ViewGroup tempat dilampirkannya tampilan item list baru sebagai turunan dari RecyclerView
    // Parameter viewType, menjadi penting saat ada beberapa jenis tampilan item dalam RecyclerView yang sama
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // membuat view baru
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    // Method ini dipanggil untuk mengganti isi tampilan item list
    // (dipanggil oleh layout manager)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        // memperbarui semua tampilan yang dirujuk oleh view holer agar mencerminkan data yang benar untuk item ini.
        // Tetapkan teks TextView untuk menampilkan string Affirmation bagi item ini.
        // karena ID merupakan integer, dan yg hrs ditampilkan adalah String, maka gunakan getString()
        // getString() mrpkn method pada class Resources, yg instance Resources diperoleh melalui "context"
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    // return size dari dataset (dipanggil oleh layout manager)
    override fun getItemCount() = dataset.size
}