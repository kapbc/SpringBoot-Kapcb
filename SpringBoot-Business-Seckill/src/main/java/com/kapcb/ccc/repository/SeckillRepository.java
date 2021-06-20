package com.kapcb.ccc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itstyle.seckill.common.entity.Seckill;

public interface SeckillRepository extends JpaRepository<Seckill, Long> {
}