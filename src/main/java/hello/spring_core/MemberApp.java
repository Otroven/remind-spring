package hello.spring_core;

import hello.spring_core.member.Grade;
import hello.spring_core.member.Member;
import hello.spring_core.member.MemberService;
import hello.spring_core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args)  {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "leo", Grade.VIP);
        memberService.join(member);

        Member foundMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("foundMember = " + foundMember.getName());


    }
}
