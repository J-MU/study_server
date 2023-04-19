package com.example.demo;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.member.MemoryMemberRepository;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memoryRepository());
    }

    private static MemberRepository memoryRepository() {
        return new MemoryMemberRepository();
    }



    public OrderService orderService(){
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }

    private static DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
