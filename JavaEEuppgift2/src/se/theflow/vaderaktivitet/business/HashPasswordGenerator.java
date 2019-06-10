package se.theflow.vaderaktivitet.business;

import se.theflow.vaderaktivitet.repository.UserLogin;
import javax.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HashPasswordGenerator {        // work in progress

    @Inject
    private UserLogin userLogin;

    public String makeHashHappen(String passwordToMakeHashFrom) {
        String salt = generateRandomSaltString(10000);
        String hash = generateHashString(salt, passwordToMakeHashFrom);

        System.out.println("Salt: " + salt);
        System.out.println("Hash: " + hash);

        return "das hacher";
    }

    public String checkPassword(String passwordToMakeHashFrom, int id) {
        String salt = userLogin.findUserByUserName(id).getUserSalt();
        String hash = generateHashString(salt, passwordToMakeHashFrom);

        return hash;
    }

    private String byte2Hex(byte[] input) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : input) {
            hexString.append(Integer.toHexString(0xFF & b));
        }
        return hexString.toString();
    }

    private String generateRandomSaltString(int targetLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetLength);
        for(int i = 0; i < targetLength; i++) {
            int randomLimtedInt = leftLimit
                    + (int)(random.nextFloat()
                    * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimtedInt);
        }
        return buffer.toString();
    }

    private String generateHashString(String salt, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String saltAndPassword = salt + password;
            md.update(saltAndPassword.getBytes());
            byte[] digest = md.digest();
            return byte2Hex(digest);
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
