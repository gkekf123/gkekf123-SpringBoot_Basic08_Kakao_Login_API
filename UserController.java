package com.coding404.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding404.myweb.util.KakaoAPI;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// REST API KEY
	//44dd34e23bb1653c0cee89121b5de123
	
	@Autowired // KakaoAPI주입
	private KakaoAPI kakaoAPI;
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/userDetail")
	public String userDetail() {
		return "user/userDetail";
	}
	
	@GetMapping("/kakao")
	public String kakao(@RequestParam String code) {
		
		String token = kakaoAPI.getToken(code);
		System.out.println(token);
		
		return "redirect:/main"; // 로그인 후 메인화면으로
	}
	
}
