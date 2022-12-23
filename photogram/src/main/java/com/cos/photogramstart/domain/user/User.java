package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA - 자바로 데이터를 영구적으로 DB에 저장할 수있는 API를 제공


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //디비에 테이블 생성. 
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	
	private String name;
	private String website;//웹사이트
	private String bio; //자기소개
	private String email;
	private String phone;
	private String gender;
	
	private String profileImageUrl; //사진
	private String role; //권한
	
	private LocalDateTime createDate;
	
	
	@PrePersist // 디비에 Insert 되기 직전에 실행 
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
}
