package com.leandro1995.healthypet.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.leandro1995.healthypet.HealthyPetPreferences
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.datastore.HealthyPetSerializable
import com.leandro1995.healthypet.model.entity.Injection
import com.leandro1995.healthypet.model.entity.Pet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import kotlin.coroutines.CoroutineContext

val Context.healthyPetDataStore: DataStore<HealthyPetPreferences> by dataStore(
    fileName = Setting.DATA_STORE_HEALTHY_PET, serializer = HealthyPetSerializable()
)

fun lifecycleScope(activity: Activity, method: suspend () -> Unit) {

    (activity as AppCompatActivity).lifecycleScope.launch {

        activity.repeatOnLifecycle(Lifecycle.State.CREATED) {

            method()
        }
    }
}

fun viewLifecycleOwner(fragment: Fragment, method: suspend () -> Unit) {

    fragment.viewLifecycleOwner.apply {

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.CREATED) {

                method()
            }
        }
    }
}

infix fun String.putString(activity: Activity) = activity.intent.getStringExtra(this)

infix fun String.putInt(activity: Activity) = activity.intent.getIntExtra(this, -1)

@Suppress("UNCHECKED_CAST")
infix fun String.putPetArrayList(activity: Activity) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

        activity.intent.getParcelableArrayListExtra(this, Pet::class.java)
    } else {

        @Suppress(
            "DEPRECATION"
        ) activity.intent.getSerializableExtra(this) as ArrayList<Pet>
    }

infix fun String.putPet(activity: Activity) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

        activity.intent.getSerializableExtra(this, Pet::class.java)
    } else {

        @Suppress("DEPRECATION") activity.intent.getSerializableExtra(this) as Pet
    }

infix fun Intent.putString(key: String) = this.getStringExtra(key)

infix fun Intent.putPet(key: String) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

    this.getSerializableExtra(key, Pet::class.java)
} else {

    @Suppress("DEPRECATION") this.getSerializableExtra(key) as Pet
}

infix fun Intent.putInjection(key: String) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

        this.getSerializableExtra(key, Injection::class.java)
    } else {

        @Suppress("DEPRECATION") this.getSerializableExtra(key) as Injection
    }

@SuppressLint("SimpleDateFormat")
fun Long.dateFormat(format: String, isCalendar: Boolean = true): String {

    val date = Date(this)

    val calendar = Calendar.getInstance()
    calendar.time = date

    if (isCalendar) {

        calendar.add(Calendar.DAY_OF_MONTH, 1)
    }

    return SimpleDateFormat(format).format(calendar.time.time)
}

@SuppressLint("SimpleDateFormat")
infix fun String.dateFormat(format: String): Long {

    return SimpleDateFormat(format).parse(this)!!.time
}

fun coroutineScope(context: CoroutineContext, method: suspend () -> Unit) {

    CoroutineScope(context).launch {

        method()
    }
}

fun String.fileUrl() = Uri.fromFile(File(this))!!