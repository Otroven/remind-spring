package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("leo");

        // when
        Long id = memberService.join(member);

        // then
        Member findOne = memberService.findOne(id).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findOne.getName());
    }

    @Test
    public void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("cris");

        Member member2 = new Member();
        member2.setName("cris");

        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}