package com.technipixl.testexo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.testexo2.databinding.FragmentAddArticleBinding
import java.lang.Integer.parseInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAddArticle.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAddArticle : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var binding :FragmentAddArticleBinding ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddArticleBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.buttonCancel?.setOnClickListener {
            findNavController().popBackStack()
        }
        var type:Types? = null
        binding?.buttonRegister?.setOnClickListener {
            val name = binding?.name?.text.toString()
            val quantity = binding?.quantity?.text.toString()
            val quantities=parseInt(quantity)
            binding?.food?.setOnCheckedChangeListener {food, checked ->
            if (checked){
                type = Types.food
            }
                binding?.drink?.isChecked=false
                binding?.hygiene?.isChecked=false
                binding?.house?.isChecked=false

            }

            binding?.drink?.setOnCheckedChangeListener {food, checked ->
                type = Types.drink
                binding?.food?.isChecked=false
                binding?.hygiene?.isChecked=false
                binding?.house?.isChecked=false

            }

            binding?.hygiene?.setOnCheckedChangeListener {food, checked ->
                type = Types.health
                binding?.drink?.isChecked=false
                binding?.food?.isChecked=false
                binding?.house?.isChecked=false

            }

            binding?.house?.setOnCheckedChangeListener {food, checked ->
                type = Types.house
                binding?.drink?.isChecked=false
                binding?.hygiene?.isChecked=false
                binding?.food?.isChecked=false

            }

            binding?.buttonRegister?.setOnClickListener {
                val value =type.toString()
                val action = FragmentShoppingListDirections.actionFragmentShoppingListToFragmentAddArticle(1,name,quantities, value)
                findNavController().navigate(R.id.action_fragmentAddArticle_to_fragmentShoppingList2)
            }
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentAddArticle.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentAddArticle().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}