package ir.androidcoder.testingandroid.data.local

import androidx.room.Database

@Database(entities = [ShoppingItem::class], version = 1 , exportSchema = false)
abstract class ShoppingItemDb {

    abstract fun shoppingDao() : ShoppingDao

}