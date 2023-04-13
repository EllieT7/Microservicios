package example.mscustomer.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class RequestDto(
    @JsonProperty("client_id")
    val clientId: String,
    @JsonProperty("client_secret")
    val clientSecret: String,
    @JsonProperty("grant_type")
    val grantType: String
)