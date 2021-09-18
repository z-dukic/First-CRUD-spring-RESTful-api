package com.dukic.app.rest.repo;

import com.dukic.app.rest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
