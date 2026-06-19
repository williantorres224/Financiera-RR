package util;
import java.util.Random;

public class TokenSeguridad {

    public String generarToken() {

        Random random = new Random();

        return String.valueOf(
            100000 + random.nextInt(900000)
        );
    }
}