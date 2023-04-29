package ru.job4j.model.status;

public enum CardName {
    REGULAR(3), GOLD(5);
    int rate;

    CardName(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
