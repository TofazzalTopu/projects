package com.example.demo.model;


import javax.persistence.*;

/**
 * Created by mdtofazzal.hossain on 3/31/2019.
 */
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;


    @Column(name = "password")
    private String password;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    public Member(Long memberId, String password, String memberName, String address, String email) {
        this.memberId = memberId;
        this.password = password;
        this.memberName = memberName;
        this.address = address;
        this.email = email;
    }

    public Member() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
