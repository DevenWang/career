package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.Matches;
import com.wangpengcheng.career.service.MatchesService;
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
public class MatchController {

    private MatchesService matchesService;

    @Autowired
    public MatchController(MatchesService matchesService) {
        this.matchesService = matchesService;
    }

    @RequestMapping(value = "/addMatch", method = RequestMethod.POST)
    public VO addMatch(@RequestParam("name") String name, @RequestParam("time") String time,
                       @RequestParam("level") String level,
                       @RequestAttribute("userId") String userId
    ) {
        if (name == null || time == null || level == null || userId == null) {
            return VO.INVALID_TOKEN;
        }

        Date date1 = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = format1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Matches match = new Matches(MyUtil.getStringID(), userId, name, level, date1);

        matchesService.save(match);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneMatch", method = RequestMethod.POST)
    public VO oneMatch(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Matches match = matchesService.findById(id);

        return new VO(match);
    }

    @RequestMapping(value = "/matchLevel", method = RequestMethod.POST)
    public VO matchLevel(@RequestAttribute("userId") String userId, @RequestParam("level") String level) {

        List<Matches> matches = matchesService.findByLevel(level);

        return new VO(matches);
    }

    @RequestMapping(value = "/company/matchName", method = RequestMethod.POST)
    public VO matchName(@RequestAttribute("userId") String userId, @RequestParam("name") String name) {

        List<Matches> matches = matchesService.findByName(name);

        return new VO(matches);
    }

    @RequestMapping(value = "/matches", method = RequestMethod.POST)
    public VO matches(@RequestAttribute("userId") String userId) {

        List<Matches> matches = matchesService.findByUserId(userId);

        return new VO(matches);
    }

    @RequestMapping(value = "/deleteMatch", method = RequestMethod.POST)
    public VO deleteMatch(@RequestAttribute("userId") String userId, @RequestParam("matchId") String matchId) {

        if (matchId == null) {
            return VO.INVALID_TOKEN;
        }
        matchesService.remove(matchId);
        return VO.SUCCESS;
    }

}
