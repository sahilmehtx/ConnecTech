package com.cs407.connectech.network

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.Request
import org.json.JSONObject

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val responseString = getMockResponse(request)

        return Response.Builder()
            .code(200) // HTTP status code
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .message("OK")
            .body(
                ResponseBody.create(
                    "application/json".toMediaTypeOrNull(),
                    responseString.toByteArray()
                )
            )
            .build()
    }

    private fun getMockResponse(request: Request): String {
        val path = request.url.encodedPath

        return when {
            path.endsWith("/auth/login") -> {
                // Mock response for login
                """
                {
                    "id": 1,
                    "email": "${extractEmailFromRequest(request)}",
                    "name": "John Doe",
                    "token": "mock_token_123"
                }
                """
            }
            path.endsWith("/auth/register") -> {
                // Mock response for registration
                """
                {
                    "id": 2,
                    "email": "${extractEmailFromRequest(request)}",
                    "name": "Jane Smith",
                    "token": "mock_token_456"
                }
                """
            }
            else -> {
                // Default mock response
                "{}"
            }
        }
    }

    private fun extractEmailFromRequest(request: Request): String {
        val buffer = okio.Buffer()
        request.body?.writeTo(buffer)
        val requestBodyString = buffer.readUtf8()
        val jsonObject = JSONObject(requestBodyString)
        return jsonObject.optString("email", "unknown@example.com")
    }
}
