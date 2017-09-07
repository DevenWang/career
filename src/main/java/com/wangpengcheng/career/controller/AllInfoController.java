package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.*;
import com.wangpengcheng.career.service.*;
import com.wangpengcheng.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AllInfoController {

    private BaseInfoService baseInfoService;
    private EducationService educationService;
    private PracticeService practiceService;
    private WorkService workService;
    private ScholarshipService scholarshipService;
    private MatchesService matchesService;
    private OtherInfoService otherInfoService;

    @Autowired
    public AllInfoController(BaseInfoService baseInfoService, EducationService educationService, PracticeService practiceService, WorkService workService, ScholarshipService scholarshipService, MatchesService matchesService, OtherInfoService otherInfoService) {
        this.baseInfoService = baseInfoService;
        this.educationService = educationService;
        this.practiceService = practiceService;
        this.workService = workService;
        this.scholarshipService = scholarshipService;
        this.matchesService = matchesService;
        this.otherInfoService = otherInfoService;
    }

    @RequestMapping(value = "/company/all", method = RequestMethod.POST)
    public VO all(@RequestParam("userId") String userId) {

        if (userId == null) {
            return VO.INVALID_TOKEN;
        }

        List<BaseInfo> baseInfos = new ArrayList<>();
        List<Education> educations = new ArrayList<>();
        List<Practice> practices = new ArrayList<>();
        List<Work> works = new ArrayList<>();
        List<Scholarship> scholarships = new ArrayList<>();
        List<Matches> matches = new ArrayList<>();
        List<OtherInfo> otherInfos = new ArrayList<>();

        BaseInfo baseInfo = baseInfoService.getbyId(userId);
        baseInfos.add(baseInfo);

        educations = educationService.getByUserId(userId);
        practices = practiceService.findByUserId(userId);
        works = workService.findByUserId(userId);
        scholarships = scholarshipService.findByUserId(userId);
        matches = matchesService.findByUserId(userId);
        otherInfos = otherInfoService.findByUserId(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("baseInfos", baseInfos);
        map.put("educations", educations);
        map.put("practices", practices);
        map.put("works", works);
        map.put("scholarships", scholarships);
        map.put("matches", matches);
        map.put("otherInfos", otherInfos);

        return new VO(200, "success", map);

    }

}
