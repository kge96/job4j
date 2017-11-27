package ru.job4j;

import org.junit.Test;
import ru.job4j.productstorage.ControlQuality;
import ru.job4j.productstorage.products.Apple;
import ru.job4j.productstorage.products.Food;
import ru.job4j.productstorage.products.Meet;

import java.text.SimpleDateFormat;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing ControlQuality.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 26.11.2017.
 */
public class ControlQualityTest {
    /**
     * Test.
     */
    @Test
    public void whenMeetExpirationDateIsBadThenItPutToTrash() {
        ControlQuality cq = new ControlQuality();
        Food meet = new Meet("Beef", 1511714512701L - 823000000, 1511714512701L - 824000000, 128, 0);
        cq.putProductToStorage(meet);

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        System.out.print(format1.format(1511714512701L - 824000000));
        System.out.print(" - ");
        System.out.println(format1.format(1511714512701L - 823000000));
    }
    /**
     * Test2.
     */
    @Test
    public void whenAppleExpirationDateIsGoodThenItPutShopStorage() {
        ControlQuality cq = new ControlQuality();
        Food apple = new Apple("Green", 1511714512701L + 824000000, 1511714512701L - 824000000, 56, 0);
        cq.putProductToStorage(apple);

        assertThat(cq.getShopStorage().size(), is(1));

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        System.out.print(format1.format(1511714512701L - 824000000));
        System.out.print(" - ");
        System.out.println(format1.format(1511714512701L + 824000000));

    }
}
