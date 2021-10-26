package doctor.clinic.util;

import doctor.clinic.entity.Reason;

import java.util.Random;

public class Randoms {
    public static String randomString(int length) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            stringBuilder.append(AlphaNumericString.charAt(index));
        }

        return stringBuilder.toString();
    }

    public static int randomInt(int minimum, int maximum) {
        Random random = new Random();
        return random.nextInt(maximum - minimum) + minimum;
    }

    public static Reason randomReason() {
        int reasonNumber = randomInt(0, 3);
        Reason reason = new Reason();
        switch (reasonNumber) {
            case 0:
                reason.setName("CONSULTATION");
                reason.setMoney(50);
                reason.setTime(30);
                break;
            case 1:
                reason.setName("TREATMENT");
                reason.setMoney(35);
                reason.setTime(40);
                break;
            case 2:
                reason.setName("PRESCRIPTIONS");
                reason.setMoney(20);
                reason.setTime(20);
                break;
        }
        return reason;
    }
}
