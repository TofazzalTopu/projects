package info.com.member.controller;

import info.com.member.model.Member;
import info.com.member.model.User;
import info.com.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by mdtofazzal.hossain on 4/3/2019.
 */

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/signup")
    public String showSignUpForm(@Valid Member member, BindingResult result) {
        if (result.hasErrors()) {
            return "add-member";
        }
        return "add-member";
    }


    @PostMapping("/addMember")
    public String addMember(@Valid Member member, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-member";
        }

        memberRepository.save(member);
        model.addAttribute("users", memberRepository.findAll());
        return "userIndex";
//        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));

        model.addAttribute("member", member);
//        return "index";
        return "update-member";
    }


    @PostMapping("/update/{id}")
    public String updateMember(@PathVariable("id") long id, @Valid Member member,
                             BindingResult result, Model model) {
        /*if (member.hasErrors()) {
            member.setId(id);
            return "update-member";
        }*/

        memberRepository.save(member);
        model.addAttribute("users", memberRepository.findAll());
        return "userIndex";
//        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        memberRepository.delete(member);
        model.addAttribute("users", memberRepository.findAll());
        return "userIndex";
//        return "index";
    }

}
