package it.ryther.projectriot.API.SpectatorV4;

import com.google.common.base.MoreObjects;

public class Observer {
    private String encryptionKey; //Key used to decrypt the spectator grid game data for playback

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("encryptionKey", encryptionKey)
                .toString();
    }
}
