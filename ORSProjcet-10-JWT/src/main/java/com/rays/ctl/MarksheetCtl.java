package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * Marksheet Controller.
 * Handles marksheet operations and related APIs.
 * Provides preload data and search by roll number.
 * 
 * @author Yusuf Khan
 */
@RestController
@RequestMapping(value = "Marksheet")
public class MarksheetCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

	@Autowired
	private StudentServiceInt studentService = null;

	@Autowired
	private MarksheetServiceInt marksheetServiceInt = null;

	/**
	 * Load marksheet and student list for dropdown.
	 */
	@GetMapping("preload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);

		List<MarksheetDTO> list = marksheetServiceInt.search(new MarksheetDTO(), userContext);
		List<StudentDTO> list1 = studentService.search(new StudentDTO(), userContext);

		res.addResult("marksheetList", list);
		res.addResult("studentList", list1);

		return res;
	}

	/**
	 * Find marksheet by roll number.
	 */
	@GetMapping("rollno/{rollNo}")
	public ORSResponse rollNo(@PathVariable String rollNo) {

		ORSResponse res = new ORSResponse(true);

		MarksheetDTO dto = baseService.findByUniqueKey("rollNo", rollNo, userContext);

		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}

		return res;
	}
}