package com.jvision.admin.domain.posts;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 스프링과 Junit을 연결해주는 SpringRunner
@RunWith(SpringRunner.class)
// 스프링 부트 테스트 클래스임을 나타내는 어노테이션
// 별다른 설정이 없이 사용할 경우 H2 데이터베이스 실행
@SpringBootTest
public class PostsRepositoryTest {
    // PostsRepository 인터페이스 객체 주입
    @Autowired
    PostsRepository postsRepository;

    // Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드
    // 여러 테스트가 동시에 수행되면 테스트용 데이트베이스인 H2에 데이터가 그대로 남아있어
    // 다음 테스트 실행시 테스트가 실패할 수 있으므로 모두 삭제 필요
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // save() 메소드
        // 테이블 posts에 insert/update 쿼리 실행
        // id 값이 있다면 update, 없다면 insert 쿼리 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("kjink98@naver.com")
                .build());

        // findALl() 메소드
        // 테이블 posts에 있는 모든 데이터를 조회하는 메소드
        List<Posts> postsList=postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
