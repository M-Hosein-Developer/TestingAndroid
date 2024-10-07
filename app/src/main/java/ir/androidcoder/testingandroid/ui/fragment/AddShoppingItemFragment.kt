package ir.androidcoder.testingandroid.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.androidcoder.testingandroid.R
import ir.androidcoder.testingandroid.databinding.FragmentAddShoppingItemBinding
import ir.androidcoder.testingandroid.viewModel.ShoppingViewModel

@AndroidEntryPoint
class AddShoppingItemFragment : Fragment() {

    private val viewModel: ShoppingViewModel by viewModels()
    lateinit var binding: FragmentAddShoppingItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddShoppingItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.ivShoppingImage.setOnClickListener {
            findNavController().navigate(R.id.action_addShoppingItemFragment_to_imagePickFragment)
        }


        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.setCurImageUrl("")
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)

    }

}