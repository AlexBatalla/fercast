package com.daw2.fercast.model.repository;

import com.daw2.fercast.model.entity.LogPage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogPagesRepository extends JpaRepository<LogPage, Integer> {

}
