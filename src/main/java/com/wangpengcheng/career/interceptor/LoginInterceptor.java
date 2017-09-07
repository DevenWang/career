package com.wangpengcheng.career.interceptor;

import com.wangpengcheng.career.model.User;
import com.wangpengcheng.career.service.UserService;
import com.wangpengcheng.career.util.GsonUtils;
import com.wangpengcheng.career.util.JedisUtils;
import com.wangpengcheng.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by wpc on 2017/5/21.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        String uid;
        String path = request.getServletPath();

        if (path.startsWith("login", 1)) {
            return true;
        }
        if (path.startsWith("register", 1)) {
            return true;
        }
        if (path.startsWith("logout", 1)) {
            return true;
        }

        if (token == null || (uid = JedisUtils.get(token)) == null) {
            response.getWriter().print(GsonUtils.toJson(VO.INVALID_TOKEN));
            return false;
        }

        uid = JedisUtils.get(token);
        if (path.startsWith("company")) {
            User user = userService.getUserById(uid);
            if (user != null && user.getType().equals("company")) {
                request.setAttribute("userId", uid);
                return true;
            } else {
                response.getWriter().print(GsonUtils.toJson(VO.INVALID_TOKEN));
                return false;
            }
        } else {
            request.setAttribute("userId", uid);
            return true;
        }

    }
}
