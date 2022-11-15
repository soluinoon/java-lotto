package lotto.domain;

public class Money {
    private final int money;

    public Money(String input) {
        validateNull(input);
        validateAllDigit(input);
        validateDividedByThousand(input);
        this.money = Integer.parseInt(input);
    }

    private void validateNull(String input) {
        if (input == null) {
            throw (new IllegalArgumentException());
        }
    }

    private void validateAllDigit(String input) {
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            validateIsDigit(c);
        }
    }

    private void validateIsDigit(char c) {
        try {
            if (!Character.isDigit(c)) {
                throw (new IllegalArgumentException("[ERROR]오류"));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            return;
        }
    }

    private void validateDividedByThousand(String input) {
        int number = Integer.parseInt(input);

        if (number == 0) {
            throw (new IllegalArgumentException());
        }
        if ((number % 1000) != 0) {
            throw (new IllegalArgumentException());
        }
    }

    public int getMoney() {
        return money;
    }
}