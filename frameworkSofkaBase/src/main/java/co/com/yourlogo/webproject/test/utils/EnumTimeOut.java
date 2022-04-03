package co.com.yourlogo.webproject.test.utils;

public enum EnumTimeOut {

    UNO(1),
    DOS(2),
    TRES(3),
    CUATRO(4),
    CINCO(5),
    SEIS(6),
    SIETE(7),
    OCHO(8),
    NUEVE(9),
    DIEZ(10);

    private final int value;

    EnumTimeOut(int value) {
        this.value = value;
    }

    public int getValue() {

        return value;
    }
}
