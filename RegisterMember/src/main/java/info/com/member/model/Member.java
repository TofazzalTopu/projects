package info.com.member.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by mdtofazzal.hossain on 4/3/2019.
 */

@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Member Id is mandatory")
    @Column(name = "member_id", length = 10, unique = true, nullable = false)
    private String memberId;

    @NotBlank(message = "Member Name is mandatory")
//    @Size(min = 4, max = 50)
    @Column(name = "member_name", length = 20, nullable = false)
    private String memberName;

    @NotBlank(message = "Address is mandatory")
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(name = "password", length = 20, nullable = false)
    private String password;

    public Member(@NotBlank(message = "Member Id is mandatory") String memberId, @NotBlank(message = "Password is mandatory") String password, @NotBlank(message = "Member Name is mandatory") String memberName, @NotBlank(message = "Address is mandatory") String address, @NotBlank(message = "Email is mandatory") String email) {
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
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