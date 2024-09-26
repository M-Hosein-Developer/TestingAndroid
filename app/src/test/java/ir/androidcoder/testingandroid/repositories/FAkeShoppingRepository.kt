package ir.androidcoder.testingandroid.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.androidcoder.testingandroid.data.local.ShoppingItem
import ir.androidcoder.testingandroid.data.remote.responses.ImageResponse
import ir.androidcoder.testingandroid.data.repository.ShoppingRepository
import ir.androidcoder.testingandroid.util.Resource

class FAkeShoppingRepository : ShoppingRepository {

    private val shoppingItem = mutableListOf<ShoppingItem>()

    private val observableShoppingItems = MutableLiveData<List<ShoppingItem>>(shoppingItem)
    private val observableTotalPrice = MutableLiveData<Float>()

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean){
        shouldReturnNetworkError = value
    }

    private fun refreshLiveData(){
        observableShoppingItems.postValue(shoppingItem)
        observableTotalPrice.postValue(getTotalPrice())
    }

    private fun getTotalPrice() : Float = shoppingItem.sumOf { it.price.toDouble() }.toFloat()

    override suspend fun insertShoppingItem(shoppingItem1: ShoppingItem) {
        shoppingItem.add(shoppingItem1)
        refreshLiveData()
    }

    override suspend fun deleteShoppingItem(shoppingItem1: ShoppingItem) {
        shoppingItem.remove(shoppingItem1)
        refreshLiveData()
    }

    override fun observeAllShoppingItem(): LiveData<List<ShoppingItem>> = observableShoppingItems

    override fun observeTotalPrice(): LiveData<Float> = observableTotalPrice

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> =
        if (shouldReturnNetworkError)
            Resource.error("Error", null)
         else
            Resource.success(ImageResponse(listOf(), 0, 0))


}