package com.neomysideprojects.darkside2016.data;

import java.sql.Timestamp;

/**
 * Created by Neo on 23.12.2016.
 */
public class UserFull extends User{
    protected byte[] passwordHash;
    protected byte[] passwordSalt;

    public UserFull(int user_id, String name, byte[] passwordHash, byte[] passwordSalt, Timestamp registrationDate) {
        super(user_id, name, registrationDate);
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }

    public UserFull(int user_id, String name, byte[] passwordHash, byte[] passwordSalt) {
        this(user_id, name, passwordHash, passwordSalt, null);
    }


    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPassword(byte[] passwordHash, byte[] passwordSalt) {
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }
}
