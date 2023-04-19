package com.example.demo.order;

import com.example.demo.AppConfig;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder(){
        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        Member basicMember = new Member(2L, "memberB", Grade.BASIC);
        memberService.join(member);
        memberService.join(basicMember);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Order orderB = orderService.createOrder(2L, "itemB", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(orderB.getDiscountPrice()).isEqualTo(0);
    }
}
