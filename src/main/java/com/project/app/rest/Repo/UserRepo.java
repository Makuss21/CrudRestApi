package com.project.app.rest.Repo;

import com.project.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
