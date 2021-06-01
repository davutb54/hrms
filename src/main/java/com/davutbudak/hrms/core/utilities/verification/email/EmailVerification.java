package com.davutbudak.hrms.core.utilities.verification.email;

import javax.validation.constraints.Email;

public interface EmailVerification {
    boolean verify(@Email String email);
}
