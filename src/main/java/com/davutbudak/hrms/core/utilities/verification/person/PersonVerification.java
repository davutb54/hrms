package com.davutbudak.hrms.core.utilities.verification.person;

public interface PersonVerification {
    boolean verify(long identityNumber, String name, String surname, int yearOfBirth);
}
