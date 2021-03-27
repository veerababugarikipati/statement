package com.nagarro.statement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.statement.entity.Statement;
@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {
	 List<Statement> findByAccountId(Long accountId);
}
