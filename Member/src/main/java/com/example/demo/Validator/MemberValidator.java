package com.example.demo.Validator;

/**
 * Created by mdtofazzal.hossain on 4/1/2019.
 */

import com.example.demo.dao.MemberDAo;
import com.example.demo.model.Member;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MemberValidator implements Validator {

    // common-validator library.
    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    private MemberDAo memberDAo;

    // The classes are supported by this validator.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Member.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;

        // Check the fields of member.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", "NotEmpty.member.memberId");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "getMemberName", "NotEmpty.member.getMemberName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.member.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.member.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.member.address");

        if (!this.emailValidator.isValid(member.getEmail())) {
            // Invalid email.
            errors.rejectValue("email", "Pattern.member.email");
        } else if (member.getMemberId() == null) {
            Member dbUser = memberDAo.findMemberByEmail(member.getEmail());
            if (dbUser != null) {
                // Email has been used by another account.
                errors.rejectValue("email", "Duplicate.member.email");
            }
        }

        if (!errors.hasFieldErrors("memberName")) {
            Member dbUser = memberDAo.findMemberByName(member.getMemberName());
            if (dbUser != null) {
                // Username is not available.
                errors.rejectValue("member", "Duplicate.member.memberName");
            }
        }

        if (!errors.hasErrors()) {
            if (!member.getPassword().equals(member.getPassword())) {
                errors.rejectValue("password", "Match.member.password");
            }
        }
    }
}