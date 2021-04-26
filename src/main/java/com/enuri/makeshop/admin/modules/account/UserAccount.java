package com.enuri.makeshop.admin.modules.account;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collections;


/*
로그인 처리를 위해서는 시큐리티 컨텍스트 홀더에 스프링 시큐리티가 제공하는 User 클래스를 기반으로 만들어진 token을 인풋해야 하는데 그때 Account 인스턴스를 User를 상속한 클래스로 래핑하기 위한
클래스 이다. (참고 메소드 AccountController의 login 메서드)
 */

@Getter
public class UserAccount extends User {

    private Account account;

    public UserAccount(Account account) {
        super(account.getNickname(), account.getPassword(), new ArrayList<GrantedAuthority>(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))));
        this.account = account;
    }
}
