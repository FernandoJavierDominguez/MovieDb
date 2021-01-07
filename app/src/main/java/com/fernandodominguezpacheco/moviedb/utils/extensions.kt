package com.fernandodominguezpacheco.moviedb.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.IOException


fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun RecyclerView.ViewHolder.toast(message: String) = itemView.context.toast(message)

/*fun ViewGroup.inflate(@LayoutRes layoutRes: Int) : View = LayoutInflater
        .from(context)
        .inflate(R.layout.view_media_item, this ,false)*/

fun ImageView.loadUrl(url : String){
    Glide.with(this).load(url).into(this)
}

inline fun <reified T : Activity> Context.startActivity(vararg pairs: Pair<String, Any?>){

    val intent = Intent(this, T::class.java).apply {
        putExtras(bundleOf(*pairs))
    }
    startActivity(intent)
}

fun <T> LifecycleOwner.observer(liveData: LiveData<T>, observer: (T) -> Unit ){
    liveData.observe(this, Observer(observer))
}

fun Context.getJsonDataFromAsset(fileName: String): String? {
    val jsonString: String
    try {
        jsonString = this.assets.open(fileName).bufferedReader().use { it.readText() }
        Log.d("REGIONES",jsonString)
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        Log.e("REGIONES","Error En regiones", ioException)
        return null
    }
    return jsonString
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {

    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(this, vmFactory).get()
}

