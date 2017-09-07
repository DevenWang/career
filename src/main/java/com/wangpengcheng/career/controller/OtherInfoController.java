package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.OtherInfo;
import com.wangpengcheng.career.service.OtherInfoService;
import com.wangpengcheng.career.util.MyUtil;
import com.wangpengcheng.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OtherInfoController {

    private OtherInfoService otherInfoService;

    @Autowired
    public OtherInfoController(OtherInfoService otherInfoService) {
        this.otherInfoService = otherInfoService;
    }

    @RequestMapping(value = "/addOtherInfo", method = RequestMethod.POST)
    public VO addOtherInfo(@RequestParam("city") String city, @RequestParam("englishLevel") String englishLevel,
                           @RequestParam("swap") String swap, @RequestParam("english") int english,
                           @RequestAttribute("userId") String userId
    ) {
        if (city == null || englishLevel == null || swap == null || english == 0 || userId == null) {
            return VO.INVALID_TOKEN;
        }

        OtherInfo otherInfo = new OtherInfo(MyUtil.getStringID(), englishLevel, userId, english, city, swap);

        otherInfoService.save(otherInfo);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneOtherInfo", method = RequestMethod.POST)
    public VO oneOtherInfo(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        OtherInfo otherInfo = otherInfoService.findById(id);

        return new VO(otherInfo);
    }

    @RequestMapping(value = "/company/otherInfoCity", method = RequestMethod.POST)
    public VO otherInfoCity(@RequestAttribute("userId") String userId, @RequestParam("city") String city) {

        List<OtherInfo> otherInfos = otherInfoService.findByCity(city);

        return new VO(otherInfos);
    }

    @RequestMapping(value = "/otherInfos", method = RequestMethod.POST)
    public VO otherInfos(@RequestAttribute("userId") String userId) {

        List<OtherInfo> otherInfos = otherInfoService.findByUserId(userId);

        return new VO(otherInfos);
    }

    @RequestMapping(value = "/deleteOtherInfo", method = RequestMethod.POST)
    public VO deleteOtherInfo(@RequestAttribute("userId") String userId, @RequestParam("otherInfoId") String otherInfoId) {

        if (otherInfoId == null) {
            return VO.INVALID_TOKEN;
        }
        otherInfoService.remove(otherInfoId);
        return VO.SUCCESS;
    }

}
