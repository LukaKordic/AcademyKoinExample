package com.example.koinexample.domain.login

import com.example.koinexample.common.ErrorLambda
import com.example.koinexample.common.SuccessLambda
import com.example.koinexample.data.reponse.LoginResponse
import com.example.koinexample.data.request.LoginRequestBody
import com.example.koinexample.networking.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginUseCaseImpl(private val authApi: AuthService) : LoginUseCase {
  override fun execute(body: LoginRequestBody, onSuccess: SuccessLambda<LoginResponse>, onFailure: ErrorLambda) {
    authApi.login(body).enqueue(object : Callback<LoginResponse> {
      override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        onFailure(t)
      }
      
      override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        if (response.isSuccessful) response.body()?.run(onSuccess)
      }
    })
  }
}