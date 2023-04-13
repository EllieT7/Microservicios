//importamos las librerias
package com.example.msaccount.api
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/accounts")
class AccountController{
    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(AccountController::class.java)
        val accounts = listOf("1233","8387383","77909")
    }

    @Value("\${server.port}")
    lateinit var port: String

    @GetMapping("/test")
    fun test(): String {
        return "Service is up and running on port $port"
    }

    @GetMapping("/list")
    fun getAccounts(): List<String> {
        LOGGER.info("Returning accounts")
        return accounts
    }

    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: Int): String {
        LOGGER.info("Returning account $id")
        return accounts[id]
    }
}