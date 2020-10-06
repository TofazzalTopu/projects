package com.example.demo.controller;

import com.example.demo.MemberApplication;
import com.example.demo.dao.MemberDAo;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by mdtofazzal.hossain on 3/31/2019.
 */

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberApplication.class);

    @Autowired
    MemberService memberService;

    @Autowired
    MemberDAo memberDAo;

    @RequestMapping("/")
    public String viewHome(Model model) {

        return "form";
    }
    @RequestMapping("/members")
    public String showMember(Model model) {
        List<Member> memberList =  memberDAo.getAllMember();
        model.addAttribute("members", memberList);
        return "showMember";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister(Model model) {
        Member form = new Member();
        model.addAttribute("member", form);

        return "memberRegistration";
    }

    // This method is called to save the registration information.
    // @Validated: To ensure that this Form
    // has been Validated before this method is invoked.
    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public String saveRegister(Model model, //
                               @ModelAttribute("member") @Validated Member member, //
                               BindingResult result, //
                               final RedirectAttributes redirectAttributes) {

        // Validate result
        if (result.hasErrors()) {
            return "memberRegistration";
        }

        boolean memberById = memberDAo.checkIsExistById(member.getMemberId());

        if(memberById){
            model.addAttribute("errorMessage", "Error: " + "Member ID already exists");
            return "memberRegistration";
        }

        Member newMember = null;
        try {
            newMember = memberDAo.createMember(member);
            System.out.println("Successful");
        }
        // Other error!!
        catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            System.out.println("Unsuccessful");
            return "memberRegistration";
        }

        redirectAttributes.addFlashAttribute("member", newMember);

        return "redirect:/member/members";
//        return "redirect:/registerSuccessful";
    }
    @RequestMapping("/registerSuccessful")
    public String successfulPage(Model model) {

        return "registerSuccessfulPage";
    }


    @RequestMapping(value = "/checkMember")
    public String checkMember() {
        System.out.println("Member");
        return "member";
    }

    @RequestMapping(value = "/memberForm")
    private ModelAndView memberForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("member");

        return modelAndView;
    }

    @RequestMapping(value = "/checkMember1")
    private ModelAndView checkMember1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("form");

        return modelAndView;
    }



    @RequestMapping(value = "/getMemberById")
    public Member getMember(Long id) {
        return memberDAo.findMemberById(id);
    }

    private void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("manik.mmanik@gmail.com", "Tofazzal7a@");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("manik.mmanik@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("manik.mmanik@gmail.com"));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("/var/tmp/image19.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }

    @RequestMapping(value = "/sendemail")
    public String sendEmail() throws AddressException, MessagingException, IOException {
        sendmail();
        return "Email sent successfully";
    }
}
