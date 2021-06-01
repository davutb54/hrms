package com.davutbudak.hrms.core.utilities.verification.person;

public class FakePersonVerificationService implements PersonVerification{
    @Override
    public boolean verify(long identityNumber, String name, String surname, int yearOfBirth) throws Exception {
        return true;
    }
}
