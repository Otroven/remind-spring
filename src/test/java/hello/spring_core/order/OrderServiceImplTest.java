package hello.spring_core.order;

import hello.spring_core.discount.FixDiscountPolicy;
import hello.spring_core.member.Grade;
import hello.spring_core.member.Member;
import hello.spring_core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "leo", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }


}