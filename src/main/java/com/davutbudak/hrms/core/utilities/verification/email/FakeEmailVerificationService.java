package com.davutbudak.hrms.core.utilities.verification.email;

public class FakeEmailVerificationService implements EmailVerification{
    @Override
    public boolean verify(String email) {
        return true;
    }
}
