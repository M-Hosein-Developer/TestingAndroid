package ir.androidcoder.testingandroid.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.testingandroid.data.local.ShoppingItemDb
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("test_db")
    fun provideInMemory(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(
            context,
            ShoppingItemDb::class.java
        )
            .allowMainThreadQueries()
            .build()


}