package com.leandro1995.healthypet.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.ProfileIntentCallBack
import com.leandro1995.healthypet.databinding.FragmentProfileBinding
import com.leandro1995.healthypet.extension.putPet
import com.leandro1995.healthypet.extension.viewLifecycleOwner
import com.leandro1995.healthypet.intent.config.ProfileIntentConfig
import com.leandro1995.healthypet.model.design.Url
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.ProfileViewModel

class ProfileFragment : Fragment(), ProfileIntentCallBack {

    private lateinit var profileBinding: FragmentProfileBinding

    private val profileViewModel by viewModels<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        ProfileIntentConfig.instance(profileIntentCallBack = this)

        profileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        profileBinding.profileViewModel = profileViewModel

        petExtra()
        collect()

        return profileBinding.root
    }

    private fun petExtra() {

        profileViewModel.pet = (Setting.PET_PUT putPet requireActivity())!!
    }

    private fun collect() {

        viewLifecycleOwner(fragment = this, method = {

            profileViewModel.profileMutableStateFlow.collect { profileIntent ->

                ProfileIntentConfig.profileSelect(profileIntent = profileIntent)
            }
        })
    }

    override fun view() {

        DesignUtil.textHtml(
            activity = requireActivity(),
            textView = profileBinding.titleText,
            idString = R.string.profile_pet_text_title,
            petName = profileViewModel.pet.name
        )
    }

    override fun playStoreOpen(intent: Intent) {

        startActivity(intent)
    }

    override fun shareApp(url: Url) {

        startActivity(url.share(message = getString(R.string.message_text)))
    }
}