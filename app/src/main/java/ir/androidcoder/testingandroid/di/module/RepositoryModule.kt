package ir.androidcoder.testingandroid.di.module

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
object RepositoryModule {

    @Provides
    @Singleton
    fun provideShoppingRepository(dao: ShoppingDao, api: PixabayApi) = DefaultShoppingRepository(dao, api) as ShoppingRepository


}