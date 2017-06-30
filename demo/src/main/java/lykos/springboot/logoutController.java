package lykos.springboot;

import cn.creditease.bdp.auth.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lykos on 2017/6/22.
 */
@Controller
@RequestMapping("/logout")
public class logoutController {
    @Resource
    private ReadingListRepository readingListRepository;

    private Logger logger = LoggerFactory.getLogger(logoutController.class);

    @RequestMapping(value = "/me",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request, HttpServletResponse response){
        AuthService.logout(request,response);
        return "logout";
    }
}

