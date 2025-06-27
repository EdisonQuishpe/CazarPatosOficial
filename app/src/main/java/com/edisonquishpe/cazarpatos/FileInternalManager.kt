package com.edisonquishpe.cazarpatos

import android.app.Activity
import android.content.Context

class FileInternalManager(val actividad: Activity) : FileHandler {
    override fun SaveInformation(datosAGrabar:Pair<String,String>) {
        val texto = datosAGrabar.first + System.lineSeparator() + datosAGrabar.second
        actividad.openFileOutput("fichero.txt", Context.MODE_PRIVATE).bufferedWriter().use { fos ->
            fos.write(texto)
        }
    }
    override fun ReadInformation():Pair<String,String> {
        actividad.openFileInput("fichero.txt").bufferedReader().use {
            val datoLeido = it.readText()
            val textArray = datoLeido.split(System.lineSeparator())
            val email = textArray[0]
            val clave = textArray[1]
            return (email to clave)
        }
        return ("" to "")
    }
}