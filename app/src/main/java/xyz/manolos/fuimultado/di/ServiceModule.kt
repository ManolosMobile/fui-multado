package xyz.manolos.fuimultado.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import xyz.manolos.fuimultado.service.CarService
import javax.inject.Singleton

@Module
object ServiceModule {

    @Provides @JvmStatic @Singleton
    fun provideCarService(): CarService = Retrofit
        .Builder()
        .baseUrl("http://www2.detran.rn.gov.br/servicos/")
        .client(
            OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()
        )
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(CarService::class.java)
}
