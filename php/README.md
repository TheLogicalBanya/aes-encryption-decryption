# AES Encryption & Decryption
## PHP implementation
This is an implementation of the AES algorithm in PHP, specifically CBC mode, with 128 bits key length and PKCS7 padding. 

Requirements: php >= 5.3.0

Uses: [OpenSSL Functions](http://php.net/manual/en/ref.openssl.php)

### Usage

```php
require_once("aes-encdec.php");

// encryption
$encryptedText = encrypt('TEXT TO ENCRYPT', 'PASSWORD');

// decryption
$decryptedText = decrypt('TEXT TO DECRYPT', 'PASSWORD');
```
