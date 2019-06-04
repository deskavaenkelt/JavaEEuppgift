package se.theflow.vaderaktivitet.business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HachPasswordGenerator {        // work in progress

    public class Main {

        public String byte2Hex(byte[] input) {
            StringBuilder hexString = new StringBuilder();

            for (byte b : input) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        }


        public String generateRandomSaltString(int targetLength) {
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

        public String dasHash() {
            String salt = generateRandomSaltString(1000);
            String password = "ThisIsThePassword";
            String hash = generateHashString(salt, password);
            System.out.println("Salt: " + salt);
            System.out.println("Hash: " + hash);

            return "das hacher";
        }
    }
}
