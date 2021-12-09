package com.kotlinexample.businesscontentapp.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kotlinexample.businesscontentapp.database.AppDatabase
import com.kotlinexample.businesscontentapp.database.BusinessContentDao
import com.kotlinexample.businesscontentapp.repository.BusinessRepository
import com.kotlinexample.businesscontentapp.remote.BusinessContentApi
import com.kotlinexample.businesscontentapp.remote.BusinessRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(60, TimeUnit.SECONDS).build()

    @Provides
    @Singleton
    @Named("BUSINESS_API")
    internal fun provideBusinessRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/api/businesscontentapi/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    internal fun provideBusinessApiService(@Named("BUSINESS_API") retrofit: Retrofit): BusinessContentApi =
        retrofit.create(BusinessContentApi::class.java)

    @Singleton
    @Provides
    fun provideBusinessRemoteDataSource(businessSource: BusinessContentApi) = BusinessRemoteDataSource(businessSource)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideBusinessDao(db: AppDatabase) = db.businessContentDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: BusinessRemoteDataSource,
                          localDataSource: BusinessContentDao) =
        BusinessRepository(remoteDataSource, localDataSource)
}