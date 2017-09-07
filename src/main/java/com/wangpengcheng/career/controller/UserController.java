package com.wangpengcheng.career.controller;

import com.wangpengcheng.career.model.User;
import com.wangpengcheng.career.service.UserService;
import com.wangpengcheng.career.util.JedisUtils;
import com.wangpengcheng.career.util.TokenUtil;
import com.wangpengcheng.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public VO register(@RequestParam("id") String userId, @RequestParam("pwd") String pwd, @RequestParam("type") String type) {
        if (userId == null || pwd == null || type == null) {
            return new VO(4003, "输入不能为空", null);
        }
        if (!(userId.trim().length() > 0 && pwd.trim().length() > 0)) {
            return new VO(4003, "输入不能为空", null);
        }

        User user = userService.getUserById(userId);

        if (user != null) {
            return new VO(4005, "此账号已注册", null);
        }

        User user1 = new User(userId, pwd, User.APPLICANT);

        if (type.equals(User.APPLICANT)) {
            user1.setType(User.APPLICANT);
        } else if (type.equals(User.COMPANY)) {
            user1.setType(User.COMPANY);
        } else if (type.equals(User.ADMIN)) {
            user1.setType(User.ADMIN);
        }
            userService.saveUser(user1);
            return VO.SUCCESS;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public VO login(@RequestParam("id") String userId, @RequestParam("pwd") String pwd, @RequestParam("type") String type, HttpSession session) {
        if (userId == null || pwd == null || type == null) {
            return new VO(4003, "输入不能为空", null);
        }
        if (!(userId.trim().length() > 0 && pwd.trim().length() > 0)) {
            return new VO(4003, "输入不能为空", null);
        }

        User user = userService.getUserById(userId);

        if (user == null) {
            return new VO(4005, "此账号不存在", null);
        }

        if (!user.getPwd().equals(pwd)) {
            return new VO<>(1002, "密码错误", null);
        }

        if (!user.getType().equals(type)) {
            return new VO<>(1002, "账号类型错误", null);
        }

        String token = TokenUtil.genToken(userId);
        JedisUtils.set(token, userId);
        session.setAttribute("currentUser", userId);
        session.setAttribute("token", token);
        return new VO(200, "success", token);
    }

    @RequestMapping(value = "/logout")
    public VO logout(HttpSession session) {

        session.invalidate();

        return VO.SUCCESS;
    }

    @RequestMapping(value = "/info")
    public VO userInfo(HttpSession session) {

        String token = (String) session.getAttribute("token");

        String uid = JedisUtils.get(token);
        User user = userService.getUserById(uid);
        User dto = new User(" ", " ", " ");
        dto.setType(user.getType());
        dto.setUserId(user.getUserId());

        VO vo = new VO(200, token, dto);
        return vo;
    }

}
