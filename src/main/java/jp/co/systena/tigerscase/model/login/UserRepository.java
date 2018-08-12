package jp.co.systena.tigerscase.model.login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    public UserEntity findByUsername(String userid);
}