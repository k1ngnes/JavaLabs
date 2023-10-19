package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashService {

    public String createHash(String text){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Обновление хеша с байтами пароля
        byte[] hashedBytes = digest.digest(text.getBytes());
        // Преобразование байтов хеша в строку в формате шестнадцатеричного представления
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
