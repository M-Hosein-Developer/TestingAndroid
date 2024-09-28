package ir.androidcoder.testingandroid.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.testingandroid.data.local.ShoppingDao
import ir.androidcoder.testingandroid.data.remote.PixabayApi
import ir.androidcoder.testingandroid.data.repository.DefaultShoppingRepository
import ir.androidcoder.testingandroid.data.repository.ShoppingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideShoppingRepository(shoppingRepository : DefaultShoppingRepository) : ShoppingRepository


}