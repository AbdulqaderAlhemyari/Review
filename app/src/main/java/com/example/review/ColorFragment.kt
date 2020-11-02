package com.example.review


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class ColorFragment : Fragment() {

    interface Callbacks {

        fun onButtonClick(fm: String)
    }

    override fun onAttach(context: Context)
    {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    private var callbacks: Callbacks? = null

    override fun onDetach()
    {
        super.onDetach()
        callbacks = null
    }

    private lateinit var mColorTV : TextView
    private lateinit var clickbtb: Button

    companion object
    {
        fun newInstance(name:String):ColorFragment
    {
        val args= Bundle().apply {
            putSerializable("Name",name)
        }

        return ColorFragment().apply {
            arguments=args
         }
        }
    }

    var mColor:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mColor= arguments?.getSerializable("Name") as String
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_color, container, false)
        mColorTV= view.findViewById(R.id.tv) as TextView
        clickbtb= view.findViewById(R.id.btn_activity) as Button

        clickbtb.setOnClickListener {
            callbacks?.onButtonClick("This is fragment Data ")
        }
        mColorTV.setText(mColor)

        return view
    }


}
