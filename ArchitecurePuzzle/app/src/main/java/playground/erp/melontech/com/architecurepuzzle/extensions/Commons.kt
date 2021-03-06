package id.kotlin.room.extensions

internal inline fun <reified T : Any> objectOf() = T::class.java

internal fun getId(): Long = Math.random().toLong()