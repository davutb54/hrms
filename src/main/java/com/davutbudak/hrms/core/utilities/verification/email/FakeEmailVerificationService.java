package com.davutbudak.hrms.core.utilities.verification.email;

import org.springframework.stereotype.Component;

@Component
public class FakeEmailVerificationService implements EmailVerification {
    @Override
    public boolean verify(String email) {
        return true;
    }
}
