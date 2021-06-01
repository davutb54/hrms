package com.davutbudak.hrms.core.utilities.verification.person;

import com.davutbudak.hrms.core.utilities.verification.person.mernis.KPSPublicSoap;

public class MernisAdapter implements PersonVerification{
    @Override
    public boolean verify(long identityNumber, String name, String surname, int yearOfBirth) throws Exception {
        KPSPublicSoap kps = new KPSPublicSoap();
        return kps.TCKimlikNoDogrula(identityNumber,name,surname,yearOfBirth);
    }
}
