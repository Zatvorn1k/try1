package com.demoex.try2.Repo;

import com.demoex.try2.Entity.Statements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepo extends JpaRepository<Statements, Long> {

}
