package com.example.corona.tp04exo2


import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_photo.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MenuFragment : Fragment() {

    var bookCovers : ArrayList<Int> = ArrayList<Int>()
    var bookTitles : ArrayList<String> = ArrayList<String>()
    var bookAuthor :ArrayList<String> = ArrayList<String>()
    var bookAuthorPhoto  : ArrayList<Int> = ArrayList<Int>()
    var bookDescription : ArrayList<String> =ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_menu, container, false)
        var bundle : Bundle? = arguments
        bookCovers = arguments?.getIntegerArrayList("bookCovers")!!
        bookTitles = arguments?.getStringArrayList("bookTitles")!!
        /*bookAuthor = arguments?.getStringArrayList("bookAuthor")!!
        bookAuthorPhoto = arguments?.getIntegerArrayList("bookAuthorPhoto")!!
        bookDescription = arguments?.getStringArrayList("bookDescription")!!*/
        return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adaptee  = CustomAdapter(
            context!!,
            bookCovers,
            bookTitles,bookAuthor,bookDescription,bookAuthorPhoto
        )
        listBooks.adapter = adaptee

        // Onclick listener of an item inside listView
        listBooks.setOnItemClickListener{
                parent, view, position, id ->



        }
    }

    class CustomAdapter constructor(private val context: Context, private val dataSource:ArrayList<Int>,
                                    private val titles:ArrayList<String>,
                                    private val bookAuthor:ArrayList<String>,
                                    private val bookDescription:ArrayList<String>,
                                    private val bookAuthorPhoto:ArrayList<Int>) : BaseAdapter(){

        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //1
        override fun getCount(): Int {
            return dataSource.size
        }

        //2
        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //4
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Get view for row item
            val rowView = inflater.inflate(R.layout.fragment_photo, parent, false)

            val recipe =dataSource.get(position)
            rowView.title.setText(titles.get(position))
            rowView.img.setImageURI(Uri.parse("android.resource://com.example.corona.tp04exo2/drawable/$recipe"))
            val params = rowView.layoutParams

            // Set the height of the Item View
            params.height = 200
            rowView.layoutParams = params
            rowView.setOnClickListener {
                (context as MainActivity).changeDetailsFragment(position)
            }
            return rowView
        }}


}
