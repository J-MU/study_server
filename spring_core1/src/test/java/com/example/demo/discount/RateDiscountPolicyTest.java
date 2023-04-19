package com.example.demo.discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_has_10p_discount() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);
        int discount2 = discountPolicy.discount(member, 20000);
        // then

        assertThat(discount).isEqualTo(1000);
        assertThat(discount2).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 10%할인이 적용되어서는 안된다.")
    void vip_x(){
        Member member = new Member(1L, "memberBasic", Grade.BASIC);

        int discount=discountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(0);
    }
}