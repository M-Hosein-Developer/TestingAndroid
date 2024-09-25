package ir.androidcoder.testingandroid.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.testingandroid.data.local.ShoppingItemDb
import ir.androidcoder.testingandroid.util.Constants.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideShoppingItemDatabase(@ApplicationContext context : Context) =
        Room.databaseBuilder(
            context,
            ShoppingItemDb::class.java,
            DATABASE_NAME
        )

    @Provides
    @Singleton
    fun provideShoppingDao(database: ShoppingItemDb) = database.shoppingDao()

}