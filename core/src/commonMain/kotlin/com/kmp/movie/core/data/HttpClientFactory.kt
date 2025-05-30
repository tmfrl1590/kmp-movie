package com.kmp.movie.core.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {

    private val prettyJsonFormatter = Json {
        prettyPrint = true
        prettyPrintIndent = "  "
        ignoreUnknownKeys = true
    }

    fun create(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 20_000L
                requestTimeoutMillis = 20_000L
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        if ("BODY START" in message) {
                            val rawJson = message
                                .substringAfter("BODY START")
                                .substringBefore("BODY END")
                                .trim()

                            try {
                                val pretty = prettyJsonFormatter.encodeToString(
                                    Json.parseToJsonElement(rawJson)
                                )
                                println("Pretty HTTP Body:\n$pretty")
                            } catch (e: Exception) {
                                println("JSON 파싱 실패:\n$rawJson")
                            }
                        } else {
                            println("🔸 $message")
                        }
                    }
                }
                level = LogLevel.ALL
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
            }
            install(DefaultRequest) {
                header(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1NTI3MTlhM2Q0MTJjYjliOTNkNzg0YTY4MzZlNjI4MyIsIm5iZiI6MTczMDY5ODEzMS4yMTQwMDAyLCJzdWIiOiI2NzI4NWI5MzUzMDliOGE1YjA0NzBhNzEiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.CXgP-upk6zz7V9uucidoQ41JPft8Oq1ag9kQzegxM9E"
                )
            }
        }
    }
}