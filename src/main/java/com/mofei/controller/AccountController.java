package com.mofei.controller;


import com.mofei.constant.StatusCodeConstant;
import com.mofei.pojo.Account;
import com.mofei.pojo.Category;
import com.mofei.pojo.Entry;
import com.mofei.service.AccountService;
import com.mofei.service.CategoryService;
import com.mofei.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/login")
    public String listCategory(Account account, Model model, HttpSession session){
        //假设前端验证成功
        boolean existsCardNo = accountService.existsCardNo(account.getCardNo());
        System.out.println(account);
        if (existsCardNo) {
            //卡号存在登录
            account = accountService.login(account);
            if (account == null) {
                //密码错误
                model.addAttribute("errorMsg","密码错误");
                return "login";
            }else{
                //检查状态
                if (account.getStatus() == 0) {
                    //冻结
                    model.addAttribute("errorMsg","账户冻结");
                    return "login";
                }else {
                    //登录成功
                    session.setAttribute("account",account);
                    return "main";
                }
            }
        }else {
            //卡号不存在错误
            model.addAttribute("errorMsg","卡号不存在");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("account");
        session.invalidate();
        return "redirect:/jsp/login.jsp";
    }

    @RequestMapping("/balance/{cardNo}")
    public String queryBalance(@PathVariable("cardNo") String cardNo,Model model){
        double  balance = accountService.queryBalance(cardNo);
        model.addAttribute("balance",balance);
        model.addAttribute("page","balance");
        return "main";
    }

    @RequestMapping("/transferTo")
    public String transferTo(Model model){
        model.addAttribute("page","transferTo");
        return "main";
    }

    @RequestMapping("/transfer")
    public String transfer(Model model,HttpSession session,
                           @RequestParam("cardNo") String cardNo,
                           @RequestParam("transactionAmount") Double transactionAmount)
    {
        //从Session获取
        Account sourceAccount = (Account) session.getAttribute("account");
        Map<String ,Object> map = accountService.transfer(sourceAccount,cardNo,transactionAmount);

        int code = (int) map.get("code");
        String msg = (String) map.get("msg");
        System.out.println(code +" "+msg);

        model.addAttribute("code",code);
        model.addAttribute("msg",msg);
        model.addAttribute("page","transferTo");
        if (code == StatusCodeConstant.SUCCESS) {
            //success
        }else {
            //fail
        }
        return "main";
    }



}
