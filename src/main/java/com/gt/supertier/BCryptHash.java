package com.gt.supertier;

import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Named;
import javax.security.enterprise.identitystore.PasswordHash;

@Named
public class BCryptHash implements PasswordHash {

    @Override
    public String generate(char[] password) {
        return BCrypt.hashpw(String.valueOf(password), BCrypt.gensalt());
    }

    @Override
    public boolean verify(char[] password, String hashedPassword) {
        return BCrypt.checkpw(String.valueOf(password), hashedPassword);
    }

}
