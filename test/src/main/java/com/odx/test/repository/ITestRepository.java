package com.odx.test.repository;

import com.odx.test.entity.PalindromeTrack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITestRepository extends CrudRepository<PalindromeTrack, Long> {
    List<PalindromeTrack> findByInput(String input);
}
