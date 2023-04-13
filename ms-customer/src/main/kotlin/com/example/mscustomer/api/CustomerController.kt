package com.example.mscustomer.api
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Value
import com.example.mscustomer.service.AccountService
import com.example.mscustomer.service.KeycloakService
import com.example.mscustomer.dto.ResponseCurrencyDto
import org.springframework.web.bind.annotation.RequestBody
import example.mscustomer.dto.RequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import com.example.mscustomer.service.CurrencyService

@RestController
@RequestMapping("/customers")
class CustomerController @Autowired constructor(private val accountService: AccountService, private val keycloakService:KeycloakService, private val currencyService: CurrencyService) {

    @Value("\${server.port}")
    lateinit var port: String

    @GetMapping("/test")
    fun test(): String {
        var result = accountService.test()
        return "Service is running on port $result"
    }

    @GetMapping("/list")
    fun getCustomers(): List<String> {
        return listOf("Customer 1", "Customer 2", "Customer 3") + accountService.getCustomers()
    }

    @GetMapping("/convert")
    fun convertCurrency(@RequestParam("from") from: String, @RequestParam("to") to: String, @RequestParam("amount") amount: String): ResponseCurrencyDto {
        return currencyService.getCurrency(from, to, amount)
    }

    @PostMapping("/token")
    fun getToken(@RequestBody requestDto: RequestDto){
        // return keycloakService.getToken(requestDto)
        print(requestDto)
        // return "token";
    }
}