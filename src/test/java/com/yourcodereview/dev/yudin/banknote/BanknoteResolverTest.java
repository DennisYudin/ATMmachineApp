package com.yourcodereview.dev.yudin.banknote;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BanknoteResolverTest {
    BanknoteResolver banknoteResolver = new BanknoteResolver();

    @Test
    void resolve_ShouldBanknote_WhenInputIs1000() {

        String input = "1000";
        Banknote banknote = banknoteResolver.resolve(input);

        String actual = banknote.getBanknote();
        String expected = "1000";

        assertEquals(expected, actual);
    }

    @Test
    void resolve_ShouldBanknote_WhenInputIs500() {

        String input = "500";
        Banknote banknote = banknoteResolver.resolve(input);

        String actual = banknote.getBanknote();
        String expected = "500";

        assertEquals(expected, actual);
    }

    @Test
    void resolve_ShouldThrowIllegalArgumentException_WhenInputIsDoesNotExistBanknote35() {

        String input = "35";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> banknoteResolver.resolve(input).getBanknote());

        String expected = "[35] There is no such banknote.";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void resolve_ShouldThrowIllegalArgumentException_WhenInputIsNegativeValue() {

        String input = "-1";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> banknoteResolver.resolve(input).getBanknote());

        String expected = "[-1] There is no such banknote.";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }
}
