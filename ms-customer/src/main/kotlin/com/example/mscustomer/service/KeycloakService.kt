package com.example.mscustomer.service
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import example.mscustomer.dto.RequestDto
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name="keycloak", url="http://localhost:8008/realms/software/protocol/openid-connect/token")
interface KeycloakService {
    //Aumentar dto y mapa
    @RequestMapping(method = [RequestMethod.POST], value=["/token"], consumes = ["application/x-www-form-urlencoded"])
    fun getToken(@RequestBody requestDto: RequestDto): String{
        println(requestDto)
        //Retornamos el token
        return "token"

    }
    // @PostMapping(consumes = ["application/x-www-form-urlencoded"])
    // fun token(formParams:Map<String, *>): TokenClientCredentialsDto




    
}
