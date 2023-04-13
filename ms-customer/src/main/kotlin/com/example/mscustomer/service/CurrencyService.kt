package com.example.mscustomer.service
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import com.example.mscustomer.dto.ResponseCurrencyDto


@FeignClient(name="currencyApi", url="http://localhost:8080/api/currency/convert")
interface CurrencyService {
    @RequestMapping(method = [RequestMethod.GET])
    fun getCurrency(@RequestParam("from") from: String, @RequestParam("to") to: String, @RequestParam("amount") amount: String): ResponseCurrencyDto

}