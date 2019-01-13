package xyz.manolos.fuimultado.service

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import xyz.manolos.fuimultado.model.Car
import java.lang.reflect.Type

class CarConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        if (type is Class<*> && type.isAssignableFrom(Car::class.java)) {
            return CarConverter()
        }
        return null
    }
}

class CarConverter : Converter<ResponseBody, Car> {

    override fun convert(value: ResponseBody): Car? {
        return Car("test")
    }
}
