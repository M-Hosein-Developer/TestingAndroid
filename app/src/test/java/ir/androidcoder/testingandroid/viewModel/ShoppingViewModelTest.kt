package ir.androidcoder.testingandroid.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import ir.androidcoder.testingandroid.MainCoroutineRule
import ir.androidcoder.testingandroid.getOrAwaitValue
import ir.androidcoder.testingandroid.repositories.FAkeShoppingRepository
import ir.androidcoder.testingandroid.util.Constants
import ir.androidcoder.testingandroid.util.Status
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShoppingViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel : ShoppingViewModel

    @Before
    fun setup(){
        viewModel = ShoppingViewModel(FAkeShoppingRepository())
    }

    @Test
    fun `insert shopping item with empty field , return error`(){
        viewModel.insertShoppingItem("name" , "" , "3.0")
        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled() ?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with two long name , return error`(){
        val string = buildString {
            for(i in 1..Constants.MAX_NAME_LENGTH + 1) append(i)
        }
        viewModel.insertShoppingItem(string , "5" , "3.0")
        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled() ?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with two long price , return error`(){
        val string = buildString {
            for(i in 1..Constants.MAX_PRICE_LENGTH + 1) append(i)
        }
        viewModel.insertShoppingItem("name" , "5" , string)
        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled() ?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with two high amount , return error`(){
        viewModel.insertShoppingItem("name" , "55325524125321252523125252" , "3.0")
        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled() ?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with valid input, return success`(){
        viewModel.insertShoppingItem("name" , "5" , "3.0")
        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled() ?.status).isEqualTo(Status.SUCCESS)
    }



}