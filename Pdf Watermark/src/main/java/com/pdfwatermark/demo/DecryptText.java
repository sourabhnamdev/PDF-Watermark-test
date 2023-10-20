package com.pdfwatermark.demo;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class DecryptText {

	public static void main(String[] args) {
		try {
			// Load your private key (Replace with your private key content)
			String privateKeyContent = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCNtXqcUr5recS7n0yKsLnYCE4JxCsQ3fsJtneaFtQnAxjqHaFk9aX5RC/syz7AK6soFQjgun+IF5i9xWZrk/e0aIz1YRgSFN/hYKfdQ9hsd7dVxnlzowELKZR8/hJplxaEN1ZP/aOoAH9hcwOOCwvzFL5i5+MdkNiEFnvTGoCtyWYjpZQiGz8i6Ube5k3+K3WKFaIfYH5ObR3TM08NFelHYgu9tGQ55UjmHC0PImiNFZQ/Rf6yqleQ11wniQvmMEXfEzjhgVj6otDkUwGzyemVY3EbqM5OVBPJPIP+C7Hcr7nSzEdZW9bgfiBNNmKMAkYp32hXD9XmTIXr0/LuIrLTAgMBAAECggEAH+Ded0Ip8hWPi0GXv29oL1AW9h16Lq4xJgs1NqXCDhClTy1hPEwCjWOogFVshWCNfVPWDnAF9oCQbMh2dObxh1UpuJ2iA5dMke/jc2Qq0KPRy2r9sWTO/ErbS48AZ16EwzOLqCz/3vBVt39fIlob0xAskCVoMyN9gaFpM6E3p2BcO/XpworXPKpkS8N8bpOqtz1JcozTsOGIOIRTWhWmTUh6kDsSGVzfWj2BBTXV+lIftQ7zxNvno3pwb2/wThrydhbdPEXD911BX9P4o3szFy/srf0sxCCUqi2hmW4j3Pd6nkzbqMQ6asN3cZU12FdCSUpgBZRqZ9n4owM2xPHRWQKBgQDM9MQYDw8HlYUnddACrv15AaOJz0BDIZX4UiDuSLcf69nGNM7ToHFZVgOjFqb/U/ow5IIzC2H+qasEA3nXcBLTE21AmDzDL520Wyfyak3JBiFrDRcu/dgI+y2S+AoqeMGjRJy8/hwoUiFG1f9mIbXVT9ScvhkO8iorJO9Wg2uaXwKBgQCxAE66P2Ko4SUb2R/gNLt287i0AMRRgrPPAywLZc4RG4OwrT8N1vUPi7SIviQVVYNUXbj/fSDIdg/IH+KwCpvrUdDNOH59kVmF88c5mH6ik2hdtncuUgqSKa8YWiy1XmtuDqwcmqFD7EC3Rlc020kUIoau6aXO606A0nXL8JmkDQKBgQDK8S5eWELckpwHZ6uxjI5lzE6fvXz3PAFgogoDiDLzw7ief1mwyTSTbg0p5tszBXc+BHY7jvDYli5FSh/SSCILqTfL9zJrXvG8TWqvqb0d6RkcBBlJqYbJ1dTZqwt95JZwURcWOFOvRSu4FVvQSF7hOivfjIgJeZZxpB/tPTJF5wKBgF7iR1HYQM8/QmFXV5sdKZFuvYjhEFyRsEo87RN/E6RgF4xSkwacQOqAfdr/8t/s42YKh+2N6lEL2RHy5dZxGXxgc4pPyp8Nl+wS7q2Vbe1BECWMdv9Bw6Du74oibO0dHIH3I5SB4AlFULvu3TjchKRijcieP+BYi9DLAZK9+97RAoGAWg+uzsNlzatEXvtW0yv8mVAvGXba+j0kF4SpIASZl4OAXCBdRjsnd38iZjlhCqK4+H/uLUKtyFgRwp+f9KLfkcZeK6tvsq04p1HZ6vV+dm+zwFOT1ux7HTArVDx3eCWUN0bLLf3cBYFc5FnqsOJt8JK40a63H4dTTX9XuDV+vAA=";
			PrivateKey privateKey = loadPrivateKey(privateKeyContent);

			// Encrypted data received from Encryption System
			String encryptedData = "CnqAMwr9QVz9aMy2/8dJqgyxQqiIJy0fTv+mLpUFRTdSUmf5zm6U12qM51K3d/W4pg1XQsEEyYHMpYPO5vUZniENkRxSHDvCI4QQxhZ8k7pZBib4nQaNHGxr7UBk0QxligqkwfkGMk7lz6WZ+EkhUUKCaPwvCL7xLe2IQq7X5mUyqj+u0yHXjrMFSumSmvd+nrsvGo/SF+vHEih+EgrYTCePWvkqXkfVD/cz2geoF91kyTiIy3aKMzlpol8GiFfDV50OpZmcN4j3hJtdK+mqwayp9Bx1cTpIYkqn6pqepolJL5GipM+JPsZSsFh0MsUGL+SZX6D7cHf2v8JHZS0PNA==";

			// Decrypt the encrypted data
			byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
			String decryptedText = decryptRSA(encryptedBytes, privateKey);
			System.out.println("Decrypted Text: " + decryptedText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static PrivateKey loadPrivateKey(String privateKeyContent) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(privateKeyContent);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(keySpec);
	}

	public static String decryptRSA(byte[] ciphertext, PrivateKey privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedBytes = cipher.doFinal(ciphertext);
		return new String(decryptedBytes);
	}

}
