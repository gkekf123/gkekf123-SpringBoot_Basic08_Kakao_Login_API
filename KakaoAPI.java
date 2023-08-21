package com.coding404.myweb.util;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service("kakaoAPI") // 빈생성 가능해짐 (컨트롤러에서 여기로 전달 옮)
public class KakaoAPI {

	public String getToken(String code) {
		
		String accecc_token = "";
		String refresh_token = "";
		String requestURL = "https://kauth.kakao.com/oauth/token";
		
		try {
			
			URL url  = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("POST"); // 요청메서드 선언
			conn.setDoOutput(true); // post요청에 필수
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8"); // 헤더 설정
			
			String req = "grant_type=authorization_code"
					   + "&client_id=44dd34e23bb1653c0cee89121b5de123"
					   + "&redirect_uri=http://192.168.0.4:8282/user/kakao"
					   + "&code=" + code;
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			bw.write(req); // 문자를 씀
			bw.flush(); // 데이터를 비워냄
			
			// 응답이 돌아오면 conn객체에 담김
			if(conn.getResponseCode() == 200) {
				System.out.println("요청 성공함");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
