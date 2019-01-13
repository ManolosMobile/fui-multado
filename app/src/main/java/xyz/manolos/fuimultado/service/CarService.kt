package xyz.manolos.fuimultado.service

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import xyz.manolos.fuimultado.model.Car

interface CarService {

    @FormUrlEncoded
    @POST("consultaveiculo.asp")
    fun fetch(@Field("placa") plate: String, @Field("renavam") renavam: String): Single<Car>
}
