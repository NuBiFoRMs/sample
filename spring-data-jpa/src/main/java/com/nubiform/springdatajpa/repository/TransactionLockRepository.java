package com.nubiform.springdatajpa.repository;

import com.nubiform.springdatajpa.repository.entity.TransactionLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface TransactionLockRepository extends JpaRepository<TransactionLock, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select l from TransactionLock l where l.lockName = :lockName")
    Optional<TransactionLock> findWithLockNameForUpdate(@Param("lockName") String lockName);
}
