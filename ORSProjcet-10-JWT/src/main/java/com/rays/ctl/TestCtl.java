package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;

@RestController
@RequestMapping(value = "Test")
public class TestCtl {

	@GetMapping("Test1")
	public ORSResponse TestAdd() {

		ORSResponse res = new ORSResponse();
		res.addData("Akbar");
		res.addMessage("Indore");
		res.addInputError("FirstName is reqiured");
		res.addResult("sdfg", "nmoik");
		return res;

	}
}
