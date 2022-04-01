package com.example.android.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// instance objek dari class Afirmation akan dibuat di class Datasource
data class Affirmation(
    @StringRes val stringResourceId : Int,
    @DrawableRes val imageResourceId : Int) {
    // setiap instance Affirmation akan berisi 1 ID teks afirmasi dan 1 ID gambar afirmasi.
    // anotasi (@...) berguna untuk peringatan saat memasukkan parameter agar tdk tertukar antara res string dan drawable, karena parameternya sm sm Int


}