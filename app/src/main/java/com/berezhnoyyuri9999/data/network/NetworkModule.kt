package com.berezhnoyyuri9999.data.network

import com.berezhnoyyuri9999.data.Api
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
//class NetworkModule @Inject constructor() {
class NetworkModule {

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).client(okHttpClient)
            .build()
    }


    @Provides
    fun provideOkHttpClient(appInterceptor: AppInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(appInterceptor).build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    private val BASE_URL = "https://api.opendota.com/api/"

}

@Module
class AppInterceptor : Interceptor {

    @Provides
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url.newBuilder().addQueryParameter("APPID", "your_key_here").build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}

