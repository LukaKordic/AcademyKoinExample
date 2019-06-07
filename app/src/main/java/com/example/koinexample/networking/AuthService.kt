package com.example.koinexample.networking

import com.example.koinexample.data.reponse.LoginResponse
import com.example.koinexample.data.reponse.RegisterResponse
import retrofit2.Call
import retrofit2.http.POST

interface AuthService {
  
  @POST(LOGIN_URL)
  fun login(): Call<LoginResponse>
  
  @POST(REGISTER_URL)
  fun register(): Call<RegisterResponse>
}