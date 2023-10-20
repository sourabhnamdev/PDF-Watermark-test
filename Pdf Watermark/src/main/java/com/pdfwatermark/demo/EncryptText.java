package com.pdfwatermark.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class EncryptText {
	public static void main(String[] args) throws Exception {

		try {
			// Load your public key
			String publicKeyContent = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjbV6nFK+a3nEu59MirC52AhOCcQrEN37CbZ3mhbUJwMY6h2hZPWl+UQv7Ms+wCurKBUI4Lp/iBeYvcVma5P3tGiM9WEYEhTf4WCn3UPYbHe3VcZ5c6MBCymUfP4SaZcWhDdWT/2jqAB/YXMDjgsL8xS+YufjHZDYhBZ70xqArclmI6WUIhs/IulG3uZN/it1ihWiH2B+Tm0d0zNPDRXpR2ILvbRkOeVI5hwtDyJojRWUP0X+sqpXkNdcJ4kL5jBF3xM44YFY+qLQ5FMBs8nplWNxG6jOTlQTyTyD/gux3K+50sxHWVvW4H4gTTZijAJGKd9oVw/V5kyF69Py7iKy0wIDAQAB";
			PublicKey publicKey = loadPublicKey(publicKeyContent);

			// HTML content to encrypt
			String content = readHTMLFile("C:\\Users\\User\\Downloads\\dwsample1-html.html");
			String htmlContent = content.substring(0, Math.min(100, content.length()));

			// Encrypt the HTML content
			byte[] encryptedBytes = encryptRSA(htmlContent, publicKey);
			System.out.println("Encrypted Text: " + Base64.getEncoder().encodeToString(encryptedBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readHTMLFile(String filePath) throws Exception {
		StringBuilder htmlContent = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				htmlContent.append(line);
			}
		}
		return htmlContent.toString();
	}
	
	public static PublicKey loadPublicKey(String publicKeyContent) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(publicKeyContent);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(keySpec);
	}

	public static byte[] encryptRSA(String plaintext, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(plaintext.getBytes());
	}

}
