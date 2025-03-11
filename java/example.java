public class example{
    public static void main(String[] args) {
        try {
            // Example plain text to encrypt
            String plainText = "Hello, This is random text to test encryption.";
            String secretKey = "1234567890123456";  // Example secret key (16 bytes for AES-128)

            System.out.println("Original Text: " + plainText);
            System.out.println("===========================");
            System.out.println("Secret Key: " + secretKey);
            System.out.println("===========================");

            AESMethod AesObj = new AESMethod();

            String encryptedText = AesObj.encrypt(plainText, secretKey);
            System.out.println("Encrypted Text: " + encryptedText);

            System.out.println("===========================");  

            String decryptedText = AesObj.decrypt(encryptedText, secretKey);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


