package hello.hello_spring;

import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManager;
import javax.sql.DataSource;

// 구현 클래스를 변경 해야 할 경우 스프링 빈에 직접 등록
@Configuration
public class SpringConfig {

    /**private final DataSource dataSource;
     private final EntityManager em;

     public SpringConfig(DataSource dataSource, EntityManager em) {
     this.dataSource = dataSource;
     this.em = em;
     }**/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /**@Bean
    public MemberRepository memberRepository() {
    // 개방-폐쇄 원칙 (OCP)
    // return new MemoryMemberRepository();
    // return new JdbcMemberRepository(dataSource);
    // return new JdbcTemplateMemberRepository(dataSource);
    // return new JpaMemberRepository(em);
    }**/
}
