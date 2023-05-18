package com.leandro1995.healthypet.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.leandro1995.healthypet.HealthyPetPreferences
import java.io.InputStream
import java.io.OutputStream

class HealthyPetSerializable : Serializer<HealthyPetPreferences> {

    override val defaultValue = HealthyPetPreferences.getDefaultInstance()!!

    override suspend fun readFrom(input: InputStream): HealthyPetPreferences {

        try {

            return HealthyPetPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {

            throw CorruptionException("", exception)
        }
    }

    override suspend fun writeTo(t: HealthyPetPreferences, output: OutputStream) = t.writeTo(output)
}