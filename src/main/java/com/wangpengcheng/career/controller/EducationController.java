package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.Education;
import com.wangpengcheng.career.service.EducationService;
import com.wangpengcheng.career.util.MyUtil;
import com.wangpengcheng.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @RequestMapping(value = "/addEducation", method = RequestMethod.POST)
    public VO addEducation(@RequestParam("start") String start, @RequestParam("end") String end,
                           @RequestParam("school") String school, @RequestParam("department") String department,
                           @RequestParam("major") String major, @RequestParam("degree") String degree,
                           @RequestParam("rank") String rank,
                           @RequestAttribute("userId") String userId
    ) {
        if (start == null || end == null || school == null || department == null || major == null || degree == null || rank == null) {
            return new VO(4003, "信息不完整", null);
        }

        Date date1 = null;
        Date date2 = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = format1.parse(start);
            date2 = format1.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Education education = new Education(MyUtil.getStringID(), userId, date1, date2, school, department, major, degree.toString(), rank.toString());

        educationService.save(education);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneEducation", method = RequestMethod.POST)
    public VO findOne(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Education education = educationService.getById(id);

        return new VO(education);
    }

    @RequestMapping(value = "/company/allEducation", method = RequestMethod.POST)
    public VO allEducation(@RequestAttribute("userId") String userId) {

        List<Education> educations = educationService.getAll();

        return new VO(educations);
    }

    @RequestMapping(value = "/educations", method = RequestMethod.POST)
    public VO educations(@RequestAttribute("userId") String userId) {

        List<Education> educations = educationService.getByUserId(userId);

        return new VO(educations);
    }

    @RequestMapping(value = "/deleteEducation", method = RequestMethod.POST)
    public VO deleteEducation(@RequestAttribute("userId") String userId, @RequestParam("educationId") String educationId) {

        if (educationId == null) {
            return VO.INVALID_TOKEN;
        }
        educationService.remove(educationId);
        return VO.SUCCESS;
    }

}
