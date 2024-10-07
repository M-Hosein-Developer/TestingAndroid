package ir.androidcoder.testingandroid.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.androidcoder.testingandroid.R
import ir.androidcoder.testingandroid.databinding.FragmentShoppingBinding
import ir.androidcoder.testingandroid.viewModel.ShoppingViewModel

@AndroidEntryPoint
class ShoppingFragment : Fragment() {

    private val viewModel: ShoppingViewModel by viewModels()
    lateinit var binding: FragmentShoppingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShoppingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddShoppingItem.setOnClickListener {
                findNavController().navigate(R.id.action_shoppingFragment_to_addShoppingItemFragment)
            }



    }
}