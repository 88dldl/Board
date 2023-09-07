package com.study.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 테이블을 의미함
@Data
public class Board {
    @Id //PR키
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String title;
    private String content;
}
