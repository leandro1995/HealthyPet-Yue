package com.leandro1995.healthypet.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.healthypet.adapter.InjectionAdapter
import com.leandro1995.healthypet.component.ambient.ListViewAmbient
import com.leandro1995.healthypet.component.config.callback.InjectionListComponentCallBack
import com.leandro1995.healthypet.config.adapter.InjectionAdapterCallBack
import com.leandro1995.healthypet.model.entity.Injection

class InjectionListComponent(context: Context, attrs: AttributeSet? = null) :
    ListViewAmbient(context, attrs) {

    private lateinit var injectionAdapter: InjectionAdapter

    private var injectionArrayList = arrayListOf<Injection>()

    var injectionListComponentCallBack: InjectionListComponentCallBack? = null

    fun injectionArrayList(injectionArrayList: ArrayList<Injection>) {

        this.injectionArrayList = ArrayList(injectionArrayList)

        isLoadingList {

            if (this.injectionArrayList.isEmpty()) {

                errorMessageVisible()
            } else {

                errorMessageGone()
            }

            injectionAdapter.submitList(null)
            injectionAdapter.submitList(ArrayList(this.injectionArrayList))
        }
    }

    override fun adapter() {

        injectionAdapter = InjectionAdapter(activity = (context as AppCompatActivity)).apply {

            injectionAdapterCallBack = object : InjectionAdapterCallBack {

                override fun injection(injection: Injection) {

                    isInjectionListComponent(injection = injection)
                }
            }
        }

        componentListPetBinding.listRecycler.let { recycler ->

            recycler.layoutManager =
                LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }

            recycler.adapter = injectionAdapter
        }

        injectionAdapter.submitList(injectionArrayList)
    }

    private fun isInjectionListComponent(injection: Injection) {

        if (injectionListComponentCallBack != null) {

            injectionListComponentCallBack!!.injection(injection = injection)
        }
    }
}