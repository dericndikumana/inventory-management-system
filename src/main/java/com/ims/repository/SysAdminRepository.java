package com.ims.repository;

import com.ims.model.SysAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SysAdminRepository extends JpaRepository<SysAdmin, Long> {
    Optional<SysAdmin> findByUsername(String username);
}