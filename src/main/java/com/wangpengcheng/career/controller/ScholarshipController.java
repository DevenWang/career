package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.Scholarship;
import com.wangpengcheng.career.service.ScholarshipService;
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
public class ScholarshipController {

    private ScholarshipService scholarshipService;

    @Autowired
    public ScholarshipController(ScholarshipService scholarshipService) {
        this.scholarshipService = scholarshipService;
    }

    @RequestMapping(value = "/addScholarship", method = RequestMethod.POST)
    public VO addScholarship(@RequestParam("source") String source, @RequestParam("time") String time,
                             @RequestParam("level") String level,
                             @RequestAttribute("userId") String userId
    ) {
        if (source == null || time == null || level == null || userId == null) {
            return VO.INVALID_TOKEN;
        }

        Date date1 = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = format1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Scholarship scholarship = new Scholarship(MyUtil.getStringID(), userId, source, level, date1);

        scholarshipService.save(scholarship);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneScholarship", method = RequestMethod.POST)
    public VO oneScholarship(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Scholarship scholarship = scholarshipService.findById(id);

        return new VO(scholarship);
    }

    @RequestMapping(value = "/company/scholarshipLevel", method = RequestMethod.POST)
    public VO scholarshipLevel(@RequestAttribute("userId") String userId, @RequestParam("level") String level) {

        List<Scholarship> scholarships = scholarshipService.findByLevel(level);

        return new VO(scholarships);
    }

    @RequestMapping(value = "/company/scholarshipSource", method = RequestMethod.POST)
    public VO scholarshipSource(@RequestAttribute("userId") String userId, @RequestParam("source") String source) {

        List<Scholarship> scholarships = scholarshipService.findBySource(source);

        return new VO(scholarships);
    }

    @RequestMapping(value = "/scholarships", method = RequestMethod.POST)
    public VO scholarships(@RequestAttribute("userId") String userId) {

        List<Scholarship> scholarships = scholarshipService.findByUserId(userId);

        return new VO(scholarships);
    }

    @RequestMapping(value = "/deleteScholarship", method = RequestMethod.POST)
    public VO deleteScholarship(@RequestAttribute("userId") String userId, @RequestParam("scholarshipId") String scholarshipId) {

        if (scholarshipId == null) {
            return VO.INVALID_TOKEN;
        }
        scholarshipService.remove(scholarshipId);
        return VO.SUCCESS;
    }
}
