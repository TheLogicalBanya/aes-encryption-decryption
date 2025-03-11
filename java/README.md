# AES Encryption & Decryption
## [Java](https://www.java.com) implementation

This is an implementation of the AES algorithm in Java, specifically CBC mode, with 128 bits key length and PKCS7 padding.

### Usage

```java
AESMethod AesObj = new AESMethod();
String plainText = "Hello, This is random text to test encryption.";
String secretKey = "1234567890123456";  // Example secret key (16 bytes for AES-128)


// strings encryption
String encryptedText = AesObj.encrypt(plainText, secretKey);
System.out.println(encryptedText);

// strings decryption
String decryptedText = AesObj.decrypt(encryptedText, secretKey);
System.out.println(decryptedText);
```
