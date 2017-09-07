package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.BaseInfo;
import com.wangpengcheng.career.service.BaseInfoService;
import com.wangpengcheng.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BaseInfoController {

    private BaseInfoService baseInfoService;

    @Autowired
    public BaseInfoController(BaseInfoService baseInfoService) {
        this.baseInfoService = baseInfoService;
    }

    @RequestMapping(value = "/addBaseInfo", method = RequestMethod.POST)
    public VO addBaseInfo(@RequestParam("name") String name, @RequestParam("gender") String gender,
                          @RequestParam("cardId") String cardId, @RequestParam("birthday") String birthday,
                          @RequestParam("localCity") String localCity, @RequestParam("birthCity") String birthCity,
                          @RequestParam("phone") String phone, @RequestParam("email") String email,
                          @RequestAttribute("userId") String userId
    ) {
        if (name == null || gender == null || cardId == null || birthCity == null || localCity == null || birthday == null || phone == null || email == null) {
            return new VO(4003, "信息不完整", null);
        }

        Date date = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format1.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BaseInfo baseInfo = new BaseInfo(userId, name, gender, cardId, date, localCity, birthCity, phone, email);

        baseInfoService.save(baseInfo);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneBaseInfo", method = RequestMethod.POST)
    public VO findOne(@RequestAttribute("userId") String userId) {

        List<BaseInfo> baseInfos = new ArrayList<>();
        BaseInfo baseInfo = baseInfoService.getbyId(userId);

        baseInfos.add(baseInfo);

        return new VO(baseInfos);
    }

    @RequestMapping(value = "/company/allBaseInfo", method = RequestMethod.POST)
    public VO findAll(@RequestAttribute("userId") String userId) {

        List<BaseInfo> baseInfo = baseInfoService.getAll();

        return new VO(baseInfo);
    }

    @RequestMapping(value = "/delBaseInfo", method = RequestMethod.POST)
    public VO delBaseInfo(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        baseInfoService.remove(id);

        return VO.SUCCESS;
    }

}
