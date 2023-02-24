package com.example.ass.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/thong-tin")
public class ThongtinController {

	@GetMapping("")
	public String showThongTin() {
		return "admin/thongtin";
	}
}
