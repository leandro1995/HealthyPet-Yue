package com.leandro1995.healthypet.util.view

import android.app.Activity
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.databinding.FragmentProfileBinding
import com.leandro1995.healthypet.model.entity.Pet
import com.leandro1995.healthypet.util.ArrayListUtil
import com.leandro1995.healthypet.util.DesignUtil

class ProfileViewUtil {

    companion object {

        @Suppress("DEPRECATION")
        fun profilePetView(
            activity: Activity,
            pet: Pet,
            fragmentProfileBinding: FragmentProfileBinding
        ) {

            DesignUtil.textHtml(
                activity = activity,
                textView = fragmentProfileBinding.titleText,
                idString = R.string.profile_pet_text_title,
                petName = pet.name
            )

            fragmentProfileBinding.photoProfileSimple.setImageURI(pet.photoFile())

            fragmentProfileBinding.nameText.text = pet.name

            fragmentProfileBinding.spiceText.text =
                ArrayListUtil.spiceFilter(id = pet.spice.id, activity = activity)!!.name

            fragmentProfileBinding.sexText.setText(DesignUtil.sexText(isSex = pet.isSex))

            fragmentProfileBinding.dateText.text = pet.date(format = Setting.DATE_FORMAT_ONE)
        }
    }
}