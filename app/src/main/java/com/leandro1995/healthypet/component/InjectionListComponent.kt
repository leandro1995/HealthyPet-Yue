package com.leandro1995.healthypet.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.healthypet.adapter.InjectionAdapter
import com.leandro1995.healthypet.component.ambient.ListViewAmbient
import com.leandro1995.healthypet.model.entity.Injection

class InjectionListComponent(context: Context, attrs: AttributeSet? = null) :
    ListViewAmbient(context, attrs) {

    private lateinit var injectionAdapter: InjectionAdapter

    private var injectionArrayList = arrayListOf<Injection>()

    fun injectionArrayList(injectionArrayList: ArrayList<Injection>) {

        this.injectionArrayList = ArrayList(injectionArrayList)

        if (this.injectionArrayList.isEmpty()) {

            errorMessageVisible()
        } else {

            errorMessageGone()
        }

        injectionAdapter.submitList(ArrayList(this.injectionArrayList))
    }

    override fun adapter() {

        injectionAdapter = InjectionAdapter(activity = (context as AppCompatActivity))

        componentListPetBinding.listRecycler.let { recycler ->

            recycler.layoutManager =
                LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }

            recycler.adapter = injectionAdapter
        }

        injectionAdapter.submitList(injectionArrayList)
    }
}