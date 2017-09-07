package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.Recruitment;
import com.wangpengcheng.career.service.RecruitmentService;
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
public class RecruitmentController {

    private RecruitmentService recruitmentService;

    @Autowired
    public RecruitmentController(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

    @RequestMapping(value = "/company/addRecruitment", method = RequestMethod.POST)
    public VO addRecruitment(@RequestParam("endTime") String endTime, @RequestParam("company") String company,
                             @RequestParam("post") String post, @RequestParam("address") String address,
                             @RequestAttribute("userId") String userId
    ) {
        if (endTime == null || company == null || post == null || address == null || userId == null) {
            return VO.INVALID_TOKEN;
        }

        Date date = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format1.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Recruitment recruitment = new Recruitment(MyUtil.getStringID(), userId, company, post, address, date);

        recruitmentService.save(recruitment);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneRecruitment", method = RequestMethod.POST)
    public VO oneRecruitment(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Recruitment recruitment = recruitmentService.getById(id);

        return new VO(recruitment);
    }

    @RequestMapping(value = "/allRecruitment", method = RequestMethod.POST)
    public VO allRecruitment(@RequestAttribute("userId") String userId) {

        List<Recruitment> recruitments = recruitmentService.findAll();

        return new VO(recruitments);
    }

    @RequestMapping(value = "/recruitments", method = RequestMethod.POST)
    public VO recruitments(@RequestAttribute("userId") String userId) {

        List<Recruitment> recruitments = recruitmentService.getByUserId(userId);

        return new VO(recruitments);
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public VO company(@RequestAttribute("userId") String userId, @RequestParam("company") String company) {

        if (company == null) {
            return VO.INVALID_TOKEN;
        }
        List<Recruitment> recruitments = recruitmentService.findByCompany(company);

        return new VO(recruitments);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public VO post(@RequestAttribute("userId") String userId, @RequestParam("post") String post) {

        if (post == null) {
            return VO.INVALID_TOKEN;
        }
        List<Recruitment> recruitments = recruitmentService.findByPost(post);

        return new VO(recruitments);
    }

    @RequestMapping(value = "/company/deleteRecruitment", method = RequestMethod.POST)
    public VO deleteRecruitment(@RequestAttribute("userId") String userId, @RequestParam("recruitmentId") String recruitmentId) {

        if (recruitmentId == null) {
            return VO.INVALID_TOKEN;
        }
        recruitmentService.remove(recruitmentId);
        return VO.SUCCESS;
    }

}
