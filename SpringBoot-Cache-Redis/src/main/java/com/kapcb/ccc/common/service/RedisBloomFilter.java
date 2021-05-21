//package com.kapcb.ccc.common.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Scope;
//import org.springframework.lang.NonNull;
//import org.springframework.stereotype.Component;
//
///**
// * <a>Title: RedisBloomFilter </a>
// * <a>Author: Kapcb <a>
// * <a>Description:  <a>
// *
// * @author Kapcb
// * @date 2021/5/19-19:08
// */
//@Slf4j
//@Component
//@Scope("singleton")
//@RequiredArgsConstructor
//public class RedisBloomFilter {
//
//    private final RedisService redisService;
//
//    /**
//     * add value into bloom filter
//     *
//     * @param bloomFilterHelper BloomFilterHelper
//     * @param key               String
//     * @param value             T
//     * @param index             int
//     * @param <T>               <T>
//     */
//    @SneakyThrows
//    public <T> void addByBloomFilter(@NonNull BloomFilterHelper<T> bloomFilterHelper, @NonNull String key, @NonNull T value, @NonNull int index) {
//        int[] offset = bloomFilterHelper.murmurHashOffset(value);
//        for (int i : offset) {
//            Boolean result = redisService.setBit(key, i, true, index);
//            log.info("key : " + key + " value : " + i + " add into bloom filter result is : " + result);
//        }
//    }
//
//    /**
//     * add value in bloom filter
//     *
//     * @param bloomFilterHelper BloomFilterHelper
//     * @param key               String
//     * @param value             T
//     * @param index             int
//     * @param <T>               <T>
//     * @return boolean
//     */
//    @SneakyThrows
//    public <T> boolean checkByBloomFilter(@NonNull BloomFilterHelper<T> bloomFilterHelper, @NonNull String key, @NonNull T value, @NonNull int index) {
//        int[] offset = bloomFilterHelper.murmurHashOffset(value);
//        for (int i : offset) {
//            if (!redisService.getBit(key, i, index)) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
