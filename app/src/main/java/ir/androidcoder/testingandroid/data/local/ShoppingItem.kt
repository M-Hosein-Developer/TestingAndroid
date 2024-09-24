package ir.androidcoder.testingandroid.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data  class ShoppingItem (

    var name: String,
    var amount: Int,
    var price: Float,
    val imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null

)