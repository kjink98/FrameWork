package com.jvision.admin.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// PostsRepository는 DAO라 불리는 DB Layer 접근자
// 인터페이스로 생성, JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
