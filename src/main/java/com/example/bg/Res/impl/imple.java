package com.example.bg.Res.impl;

import com.example.bg.Res.PrismaRes;
import com.example.bg.model.UserCredit;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class imple implements PrismaRes {

    @Override
    public Optional<UserCredit> findByClerkUserId(String clerkUserId) {
        return Optional.empty();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UserCredit> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends UserCredit> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<UserCredit> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UserCredit getOne(Long aLong) {
        return null;
    }

    @Override
    public UserCredit getById(Long aLong) {
        return null;
    }

    @Override
    public UserCredit getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends UserCredit> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserCredit> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends UserCredit> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends UserCredit> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserCredit> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserCredit> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends UserCredit, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends UserCredit> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UserCredit> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<UserCredit> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<UserCredit> findAll() {
        return List.of();
    }

    @Override
    public List<UserCredit> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(UserCredit entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserCredit> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserCredit> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<UserCredit> findAll(Pageable pageable) {
        return null;
    }
}
