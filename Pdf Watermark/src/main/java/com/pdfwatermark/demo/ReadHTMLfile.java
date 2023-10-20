package com.pdfwatermark.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class ReadHTMLfile {

	public static void main(String[] args) {
		try {
			// Read the HTML file
			String htmlContent = readHTMLFile("C:\\Users\\User\\Downloads\\dwsample1-html.html");

			// Extract the first 100 characters
			String textToEncrypt = htmlContent.substring(0, Math.min(100, htmlContent.length()));

			// Generate RSA key pair
			KeyPair keyPair = generateRSAKeyPair();

			// Encrypt the text
			byte[] encryptedBytes = encryptRSA(textToEncrypt, keyPair.getPublic());
			
			// Decrypt the encrypted text
            String decryptedText = decryptRSA(encryptedBytes, keyPair.getPrivate());
			// Print the original and encrypted text
			
			System.out.println("Original Text: " + textToEncrypt);
			System.out.println("Encrypted Text: " + Base64.getEncoder().encodeToString(encryptedBytes));
			System.out.println("Decrypted Text: " + decryptedText);

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

	public static KeyPair generateRSAKeyPair() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048); // Use 2048-bit keys for RSA-256
		return keyPairGenerator.generateKeyPair();
	}

	public static byte[] encryptRSA(String plaintext, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(plaintext.getBytes());
	}

	public static String decryptRSA(byte[] ciphertext, PrivateKey privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedBytes = cipher.doFinal(ciphertext);
		return new String(decryptedBytes);
	}
}