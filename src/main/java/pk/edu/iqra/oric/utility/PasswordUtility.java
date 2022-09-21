package pk.edu.iqra.oric.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class PasswordUtility {
    public static void main(String []ar){
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(10, new SecureRandom());
        System.out.println(bCryptPasswordEncoder.encode("as4$$64CV23"));
    }
}
