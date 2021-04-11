package com.example.custombutton

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.fragment_third.view.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class ThirdFragment : Fragment() {

    private val REQUEST_CODE_PICKER = 123
    var selectecdImage: Uri? = null
    lateinit var file: File
    lateinit var  Viewmodel : MainViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        upload_btn.setOnClickListener {
            uploadImage()
        }

        send_btn.setOnClickListener {


            val requestBody = RequestBody.create(MediaType.parse("image/jpg"), file)
            val parts = MultipartBody.Part.createFormData("file", file.name, requestBody)

            Viewmodel.uploadImage(parts).observe(viewLifecycleOwner, Observer {
                println("GOD: ${it.message}")
                status.text = it.message

            })

        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        Viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)

        return view
    }


    fun uploadImage() {
        val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE_PICKER)

    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICKER && resultCode == Activity.RESULT_OK) {
            Log.d("Enter", "Yeah")

            selectecdImage = data?.data
            imageView.setImageURI(selectecdImage)

            //Create a parcel descriptor for the file
            val parcelFileDescriptor =
                    selectecdImage?.let { context?.contentResolver?.openFileDescriptor(it, "r", null) }
//create a cache version of the image in the application folder and send to be uploaded
//to the server.
            parcelFileDescriptor?.let {
                val inputStream = FileInputStream(it.fileDescriptor)
                val fileName = context?.contentResolver?.getFileName(selectecdImage!!)
                file = File(context?.cacheDir, fileName!!)
                val outputStream = FileOutputStream(file)
                inputStream.copyTo(outputStream) //Cache version created.


            }


        }

    }


    private fun ContentResolver.getFileName(fileUri: Uri): String {
        var name = ""
        val returnCursor = this.query(fileUri, null, null, null, null)
        if (returnCursor != null) {
            val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            returnCursor.moveToFirst()
            name = returnCursor.getString(nameIndex)
            returnCursor.close()
        }
        return name
    }

}