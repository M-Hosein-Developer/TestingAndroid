package ir.androidcoder.testingandroid.data.repository

import androidx.lifecycle.LiveData
import ir.androidcoder.testingandroid.data.local.ShoppingItem
import ir.androidcoder.testingandroid.data.remote.responses.ImageResponse
import ir.androidcoder.testingandroid.util.Resource
import retrofit2.Response

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItem() : LiveData<List<ShoppingItem>>

    fun observeTotalPrice() : LiveData<Float>

    suspend fun searchForImage(imageQuery : String) : Resource<ImageResponse>

}