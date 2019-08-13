package com.aurelmarishta.restblog.user.verificationtoken;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVerificationRepository extends JpaRepository<UserVerificationToken, Long> {
}
