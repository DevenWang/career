package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.Work;
import com.wangpengcheng.career.service.WorkService;
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
public class WorkController {

    private WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }


    @RequestMapping(value = "/addWork", method = RequestMethod.POST)
    public VO addWork(@RequestParam("start") String start, @RequestParam("end") String end,
                      @RequestParam("workType") String workType, @RequestParam("name") String name,
                      @RequestParam("duty") String duty, @RequestParam("content") String content,
                      @RequestAttribute("userId") String userId
    ) {
        if (start == null || end == null || name == null || content == null || duty == null || userId == null || workType == null) {
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

        Work work = new Work(MyUtil.getStringID(), userId, date1, date2, workType, name, content, duty);

        workService.save(work);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneWork", method = RequestMethod.POST)
    public VO oneWork(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Work work = workService.findById(id);

        return new VO(work);
    }

    @RequestMapping(value = "/company/allWork", method = RequestMethod.POST)
    public VO allWork(@RequestAttribute("userId") String userId) {

        List<Work> works = workService.findAll();

        return new VO(works);
    }

    @RequestMapping(value = "/works", method = RequestMethod.POST)
    public VO works(@RequestAttribute("userId") String userId) {

        List<Work> works = workService.findByUserId(userId);

        return new VO(works);
    }

    @RequestMapping(value = "/deleteWork", method = RequestMethod.POST)
    public VO deleteWork(@RequestAttribute("userId") String userId, @RequestParam("workId") String Work) {

        if (Work == null) {
            return VO.INVALID_TOKEN;
        }
        workService.remove(Work);
        return VO.SUCCESS;
    }
}
