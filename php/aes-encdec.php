<?php
function encrypt($plainText, $secretKey) {
    // Generate a random IV (16 bytes for AES)
    $iv = openssl_random_pseudo_bytes(16);
    
    // Encrypt the plaintext using AES-128-CBC (change AES-256-CBC if needed)
    $encryptedData = openssl_encrypt($plainText, 'AES-128-CBC', $secretKey, OPENSSL_RAW_DATA, $iv);
    
    // Combine the IV and encrypted text
    $encryptedWithIv = $iv . $encryptedData;
    
    // Return the result in Base64 encoding for easier storage/transmission
    return base64_encode($encryptedWithIv);
}

function decrypt($encryptedText, $secretKey) {
    // Decode the Base64 encoded encrypted text
    $encryptedWithIv = base64_decode($encryptedText);
    
    // Extract the IV from the encrypted data (first 16 bytes)
    $iv = substr($encryptedWithIv, 0, 16);
    
    // Extract the encrypted data (remaining bytes after the IV)
    $encryptedData = substr($encryptedWithIv, 16);
    
    // Decrypt the data using AES-128-CBC
    $decryptedText = openssl_decrypt($encryptedData, 'AES-128-CBC', $secretKey, OPENSSL_RAW_DATA, $iv);
    
    // Return the decrypted string
    return $decryptedText;
}
?>
