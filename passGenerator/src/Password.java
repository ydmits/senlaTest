import java.util.Random;

public class Password {
    private final String LOW = "abcdefghijklmnopqrstuvwxyz";
    private final String UP = LOW.toUpperCase();
    private final String NUMBER = "0123456789";
    private final String SPECIAL = "!@#$%^&*()_+";
    private final String RESULT = LOW + UP + NUMBER + SPECIAL;

    private int length;
    private String password;

    public Password(int length) {
        this.length = length;
        generatePassword();
        validation();
    }

    public String getPassword() {
        return password;
    }

    private void generatePassword() {
        StringBuilder pass = new StringBuilder(length);

        for (int i = 0; i < length; i ++) {
            Random random = new Random();
            int index = random.nextInt(RESULT.length());
            pass.append(RESULT.charAt(index));
        }
        password = pass.toString();
    }

    private void validation() {
        while (true) {
            boolean flagUpper = false;
            boolean flagLower = false;
            boolean flagNumber = false;
            boolean flagSpecial = false;

            for (int i = 0; i < password.length(); i++) {
                if (LOW.indexOf(password.charAt(i)) != -1) {
                    flagLower = true;
                }
                if (UP.indexOf(password.charAt(i)) != -1) {
                    flagUpper = true;
                }
                if (NUMBER.indexOf(password.charAt(i)) != -1) {
                    flagNumber = true;
                }
                if (SPECIAL.indexOf(password.charAt(i)) != -1) {
                    flagSpecial = true;
                }
            }

            StringBuilder pas = new StringBuilder(password);
            if(!flagUpper) {
                Random random = new Random();
                int indexPas = random.nextInt(pas.length());
                int indexUp = random.nextInt(UP.length());
                pas.setCharAt(indexPas, UP.charAt(indexUp));
            }
            if(!flagLower) {
                Random random = new Random();
                int indexPas = random.nextInt(pas.length());
                int indexLow = random.nextInt(LOW.length());
                pas.setCharAt(indexPas, LOW.charAt(indexLow));
            }
            if(!flagNumber) {
                Random random = new Random();
                int indexPas = random.nextInt(pas.length());
                int indexNum = random.nextInt(NUMBER.length());
                pas.setCharAt(indexPas, NUMBER.charAt(indexNum));
            }
            if(!flagSpecial) {
                Random random = new Random();
                int indexPas = random.nextInt(pas.length());
                int indexSp = random.nextInt(SPECIAL.length());
                pas.setCharAt(indexPas, SPECIAL.charAt(indexSp));
            }

            if (flagUpper && flagLower && flagNumber && flagSpecial) {
                break;
            }
        }
    }
}
