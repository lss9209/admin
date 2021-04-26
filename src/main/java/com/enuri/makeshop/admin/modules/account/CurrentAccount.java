package com.enuri.makeshop.admin.modules.account;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
컨트롤러에서 현재 로그인된 Account 인스턴스를 가리킬 때 파라미터 앞에 붙일 자체 제작 어노테이션.
시큐리티 세션 홀더에서 보유하고 있는 토큰 정보를 기반으로 로그인 된 유저 정보를 가져온다.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : account")
/*
바로 위의 어노테이션이 시큐리티에서 원래 제공하는 로그인 추적 어노테이션이다. 이 어노테이션은 저 어노테이션을 래핑한 커스터마이징 어노테이션이다.
스프링 시큐리티는 로그인된 유저정보가 없을 때 자동으로 Username에 디폴트 값으로 'anonymousUser'라는 문자열 값을 저장한다. 만약 그러하다면 null을 반환하고 그렇지 않고
해당 파라미터(Account 인스턴스)에 해당하는 로그인 정보가 있으면 그 인스턴스를 반환한다.
 */
public @interface CurrentAccount {
}
