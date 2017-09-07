package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.dto.CompanyApplyDTO;
import com.wangpengcheng.career.dto.MyApplyDTO;
import com.wangpengcheng.career.model.Apply;
import com.wangpengcheng.career.model.BaseInfo;
import com.wangpengcheng.career.model.Recruitment;
import com.wangpengcheng.career.model.User;
import com.wangpengcheng.career.service.ApplyService;
import com.wangpengcheng.career.service.BaseInfoService;
import com.wangpengcheng.career.service.RecruitmentService;
import com.wangpengcheng.career.service.UserService;
import com.wangpengcheng.career.util.MyUtil;
import com.wangpengcheng.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ApplyController {

    private ApplyService applyService;
    private RecruitmentService recruitmentService;
    private BaseInfoService baseInfoService;

    @Autowired
    public ApplyController(ApplyService applyService, RecruitmentService recruitmentService, BaseInfoService baseInfoService) {
        this.applyService = applyService;
        this.recruitmentService = recruitmentService;
        this.baseInfoService = baseInfoService;
    }

    @RequestMapping(value = "/addApply", method = RequestMethod.POST)
    public VO addApply(@RequestParam("workId") String workId,
                       @RequestAttribute("userId") String userId
    ) {
        if (workId == null || userId == null) {
            return VO.INVALID_TOKEN;
        }

        Apply apply = new Apply(MyUtil.getStringID(), userId, workId, new Date());

        applyService.save(apply);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneApply", method = RequestMethod.POST)
    public VO oneApply(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Apply apply = applyService.findById(id);

        return new VO(apply);
    }

    @RequestMapping(value = "/company/allApply", method = RequestMethod.POST)
    public VO allApply(@RequestAttribute("userId") String userId) {

        List<Apply> applies = applyService.findAll();

        return new VO(applies);
    }

    @RequestMapping(value = "/userApply", method = RequestMethod.POST)
    public VO userApply(@RequestAttribute("userId") String userId) {

        List<Apply> applies = applyService.findByUserId(userId);
        List<MyApplyDTO> dtos = new ArrayList<>();


        for (Apply apply : applies) {
            System.out.println(apply.getWorkId());
            Recruitment recruitment = recruitmentService.getById(apply.getWorkId());
            if (recruitment != null) {
                MyApplyDTO myApplyDTO = new MyApplyDTO(apply.getApplyId(), recruitment.getCompany(), recruitment.getPost(), recruitment.getAddress(), recruitment.getEndTime(), apply.getTime());
                dtos.add(myApplyDTO);
            }

        }

        return new VO(dtos);
    }

    @RequestMapping(value = "/companyApply", method = RequestMethod.POST)
    public VO company(@RequestAttribute("userId") String userId) {

        if (userId == null) {
            return VO.INVALID_TOKEN;
        }

        List<CompanyApplyDTO> dtos = new ArrayList<>();

        List<Recruitment> recruitments = recruitmentService.getByUserId(userId);
        for (Recruitment r : recruitments) {
            List<Apply> applies = applyService.findByWorkId(r.getRecruitmentId());
            for (Apply a : applies) {
                BaseInfo baseInfo = baseInfoService.getbyId(a.getUserId());
                if (baseInfo != null) {
                    CompanyApplyDTO dto = new CompanyApplyDTO(a.getUserId(), baseInfo.getName(), baseInfo.getGender(), baseInfo.getPhone(), baseInfo.getEmail(), r.getPost(), a.getTime());
                    dtos.add(dto);
                } else {
                    CompanyApplyDTO dto = new CompanyApplyDTO(a.getUserId(), "未填", "未填", "未填", "未填", r.getPost(), a.getTime());
                    dtos.add(dto);
                }
            }
        }
        return new VO(dtos);
    }

    @RequestMapping(value = "/deleteApply", method = RequestMethod.POST)
    public VO deleteApply(@RequestAttribute("userId") String userId, @RequestParam("applyId") String applyId) {

        if (applyId == null) {
            return VO.INVALID_TOKEN;
        }
        applyService.remove(applyId);
        return VO.SUCCESS;
    }

}
