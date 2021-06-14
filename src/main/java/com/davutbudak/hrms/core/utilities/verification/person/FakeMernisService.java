package com.davutbudak.hrms.core.utilities.verification.person;

import org.springframework.stereotype.Component;

@Component
public class FakeMernisService implements PersonVerification {
    @Override
    public boolean verify(long identityNumber, String name, String surname, int yearOfBirth) {
        return true;
    }
}
