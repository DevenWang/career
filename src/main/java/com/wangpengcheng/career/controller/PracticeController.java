package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.Practice;
import com.wangpengcheng.career.service.PracticeService;
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
public class PracticeController {

    private PracticeService practiceService;

    @Autowired
    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @RequestMapping(value = "/addPractice", method = RequestMethod.POST)
    public VO addPractice(@RequestParam("start") String start, @RequestParam("end") String end,
                          @RequestParam("name") String name, @RequestParam("content") String content,
                          @RequestParam("duty") String duty,
                          @RequestAttribute("userId") String userId
    ) {
        if (start == null || end == null || name == null || content == null || duty == null || userId == null) {
            return VO.INVALID_TOKEN;
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

        Practice practice = new Practice(MyUtil.getStringID(), userId, date1, date2, name, content, duty);

        practiceService.save(practice);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/onePractice", method = RequestMethod.POST)
    public VO onePractice(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Practice practice = practiceService.findById(id);

        return new VO(practice);
    }

    @RequestMapping(value = "/company/allPractice", method = RequestMethod.POST)
    public VO allPractice(@RequestAttribute("userId") String userId) {

        List<Practice> practices = practiceService.findAll();

        return new VO(practices);
    }

    @RequestMapping(value = "/practices", method = RequestMethod.POST)
    public VO practices(@RequestAttribute("userId") String userId) {

        List<Practice> practices = practiceService.findByUserId(userId);

        return new VO(practices);
    }

    @RequestMapping(value = "/deletePractice", method = RequestMethod.POST)
    public VO deletePractice(@RequestAttribute("userId") String userId, @RequestParam("practiceInfoId") String practiceInfoId) {

        if (practiceInfoId == null) {
            return VO.INVALID_TOKEN;
        }
        practiceService.remove(practiceInfoId);
        return VO.SUCCESS;
    }

}
