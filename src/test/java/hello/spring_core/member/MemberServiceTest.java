package hello.spring_core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void Join() {
        Member member = new Member(1L, "leo", Grade.VIP);

        memberService.join(member);
        Member foundMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(foundMember);
    }
}
