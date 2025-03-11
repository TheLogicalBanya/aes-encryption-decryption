import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.SecureRandom;

public class AESMethod {

    // Method to encrypt the text using AES algorithm in CBC mode with padding
    public static String encrypt(String plainText, String secretKey) throws Exception {
        // Generate a random IV for each encryption (16 bytes for AES)
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[16];
        secureRandom.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Create a secret key from the provided string key
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");

        // Get an instance of AES cipher in CBC mode with PKCS5Padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Initialize the cipher in encryption mode with the secret key and IV
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        // Perform encryption and get the encrypted byte array
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // Combine the IV and encrypted text into a single byte array
        byte[] encryptedWithIv = new byte[iv.length + encryptedBytes.length];
        System.arraycopy(iv, 0, encryptedWithIv, 0, iv.length);
        System.arraycopy(encryptedBytes, 0, encryptedWithIv, iv.length, encryptedBytes.length);

        // Return the encrypted data in Base64 encoding for easier storage/transmission
        return Base64.getEncoder().encodeToString(encryptedWithIv);
    }

    // Method to decrypt the text using AES algorithm in CBC mode with padding
    public static String decrypt(String encryptedText, String secretKey) throws Exception {
        // Decode the Base64 encoded encrypted text
        byte[] encryptedWithIv = Base64.getDecoder().decode(encryptedText);

        // Extract the IV from the encrypted data (the first 16 bytes)
        byte[] iv = new byte[16];
        System.arraycopy(encryptedWithIv, 0, iv, 0, iv.length);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Extract the encrypted text (the remaining bytes after the IV)
        byte[] encryptedBytes = new byte[encryptedWithIv.length - iv.length];
        System.arraycopy(encryptedWithIv, iv.length, encryptedBytes, 0, encryptedBytes.length);

        // Create a secret key from the provided string key
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");

        // Get an instance of AES cipher in CBC mode with PKCS5Padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Initialize the cipher in decryption mode with the secret key and IV
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        // Perform decryption and get the decrypted byte array
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Return the decrypted string
        return new String(decryptedBytes);
    }
}
