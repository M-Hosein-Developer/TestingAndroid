package ir.androidcoder.testingandroid.data.repository

import androidx.lifecycle.LiveData
import ir.androidcoder.testingandroid.data.local.ShoppingDao
import ir.androidcoder.testingandroid.data.local.ShoppingItem
import ir.androidcoder.testingandroid.data.remote.PixabayApi
import ir.androidcoder.testingandroid.data.remote.responses.ImageResponse
import ir.androidcoder.testingandroid.util.Constants.API_KEY
import ir.androidcoder.testingandroid.util.Resource
import retrofit2.Response
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayApi: PixabayApi
) : ShoppingRepository{

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItem(): LiveData<List<ShoppingItem>> =
        shoppingDao.observeAllShoppingItems()

    override fun observeTotalPrice(): LiveData<Float> =
        shoppingDao.observeTotalPrice()

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> =
        try {
            val response = pixabayApi.searchForImage(imageQuery)

            if (response.isSuccessful)
                response.body()?.let {
                    Resource.success(it)
                } ?: Resource.error("An unknown error occured", null)
            else
                   Resource.error("An unknown error occured", null)

        } catch (e : Exception){
            Resource.error("Couldn't reach the server. check your internet connection", null)
        }


}