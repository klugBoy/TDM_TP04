package com.example.corona.tp04exo2


import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_details, container, false)

        var arg : Bundle? = arguments
        val  photoUri = arg?.getInt("photoAuthor")
        v.nameAuthor.setText(arg?.getString("nameAuthor"))
        v.descriptionBook.setText( arg?.getString("descriptionBook"))
       v.photoAuthor.setImageURI(Uri.parse("android.resource://com.example.corona.tp04exo2/drawable/$photoUri"))
        v.descriptionBook.setMovementMethod(ScrollingMovementMethod())


        return v
    }


}
