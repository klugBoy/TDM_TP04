package com.example.corona.tp04exo2

import android.app.Activity
import android.content.Context
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_photo.*
import kotlinx.android.synthetic.main.fragment_photo.view.*
import java.util.zip.Inflater
import android.widget.Toast
import android.R.attr.orientation
import android.content.res.Configuration


class MainActivity : AppCompatActivity() {

    lateinit var bookCovers : ArrayList<Int>
    lateinit var bookTitles : ArrayList<String>
    lateinit var bookAuthor :ArrayList<String>
    lateinit var bookAuthorPhoto  : ArrayList<Int>
    lateinit var bookDescription : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // All the data needed
        bookCovers  = arrayListOf(R.drawable.flow,R.drawable.friends)
        bookTitles  = arrayListOf("Flow","How to win friends")
        bookAuthor  = arrayListOf("Mihaly Csikszentmihalyi","Dale Carnegie")
        bookAuthorPhoto   = arrayListOf(R.drawable.mihaly,R.drawable.dale)
        bookDescription  = arrayListOf("Psychologist Mihaly Csikszentmihalyi's investigations of \"optimal experience\" have revealed that what makes an experience genuinely satisfying is a state of consciousness called flow. " +
                "During flow, people typically experience deep enjoyment, creativity, and a total involvement with life. Csikszentmihalyi demonstrates the ways this positive state can be controlled, not just left to chance. Flow: The Psychology of Optimal Experience teaches how, by ordering the information that enters our consciousness, " +
                "we can discover true happiness, unlock our potential, and greatly improve the quality of our lives.","You can go after the job you want...and get it! You can take the job you have...and improve it! You can take any situation you're in...and make it work for you!\n" +
                "\n" +
                "Since its release in 1936, How to Win Friends and Influence People has sold more than 15 million copies. Dale Carnegie's first book is a timeless bestseller, packed with rock-solid advice that has carried thousands of now famous people up the ladder of success in their business and personal lives.\n" +
                "\n" +
                "As relevant as ever before, Dale Carnegie's principles endure, and will help you achieve your maximum potential in the complex and competitive modern age.\n" +
                "\n" +
                "Learn the six ways to make people like you, the twelve ways to win people to your way of thinking, and the nine ways to change people without arousing resentment.")



        // pass the data to the menu
        val fragment : MenuFragment = MenuFragment()
        val bundle = Bundle()
        bundle.putIntegerArrayList("bookCovers", bookCovers)
        bundle.putStringArrayList("bookTitles", bookTitles)
        fragment.setArguments(bundle)
        supportFragmentManager.beginTransaction().replace(R.id.menuBook,fragment).commit()



    }

    fun changeDetailsFragment(position : Int){
        val fragment : DetailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putInt("photoAuthor", bookAuthorPhoto.get(position))
        bundle.putString("nameAuthor", bookAuthor.get(position))
        bundle.putString("descriptionBook", bookDescription.get(position))
        fragment.setArguments(bundle)
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction().replace(R.id.detailsBook,fragment).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.menuBook,fragment).commit()
        }

    }




}
