package com.leandro1995.healthypet.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.databinding.FragmentInjectionBinding

class InjectionFragment : Fragment() {

    private lateinit var injectionBinding: FragmentInjectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        injectionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_injection, container, false)

        return injectionBinding.root
    }
}