
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LispListTest {

    @Test
    void testLength() {
        Assertions.assertEquals(0, LispList.empty().length());
        Assertions.assertEquals(1, LispList.of(10).length());
        Assertions.assertEquals(3, LispList.of(1, 2, 3).length());
        Assertions.assertEquals(4, LispList.of(0, -1, 2, -3).length());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("[]", LispList.empty().toString());
        Assertions.assertEquals("[10]", LispList.of(10).toString());
        Assertions.assertEquals("[10, 20, 30]",
                LispList.of(10, 20, 30).toString());
        Assertions.assertEquals("[0, -2, 5]",
                LispList.of(0, -2, 5).toString());
    }

    @Test
    void testRemoveAll() {
        // Empty list
        Assertions.assertEquals(
                LispList.empty(),
                LispList.empty().removeAll(3));

        // No matches
        Assertions.assertEquals(
                LispList.of(1, 2, 4),
                LispList.of(1, 2, 4).removeAll(3));

        // Some matches
        Assertions.assertEquals(
                LispList.of(4, 5),
                LispList.of(3, 4, 3, 5).removeAll(3));

        // All matches
        Assertions.assertEquals(
                LispList.empty(),
                LispList.of(3, 3, 3).removeAll(3));

        // Zero and negative numbers
        Assertions.assertEquals(
                LispList.of(-1, 2),
                LispList.of(0, -1, 0, 2).removeAll(0));

        Assertions.assertEquals(
                LispList.of(0, 2),
                LispList.of(-1, 0, -1, 2).removeAll(-1));

        // Singleton
        Assertions.assertEquals(
                LispList.empty(),
                LispList.of(5).removeAll(5));
    }

    @Test
    void testMerge() {
        // Both empty
        Assertions.assertEquals(
                LispList.empty(),
                LispList.empty().merge(LispList.empty()));

        // First empty
        Assertions.assertEquals(
                LispList.of(1, 2),
                LispList.empty().merge(LispList.of(1, 2)));

        // Second empty
        Assertions.assertEquals(
                LispList.of(1, 2),
                LispList.of(1, 2).merge(LispList.empty()));

        // Equal lengths
        Assertions.assertEquals(
                LispList.of(1, 4, 2, 5, 3, 6),
                LispList.of(1, 2, 3).merge(LispList.of(4, 5, 6)));

        // First list longer
        Assertions.assertEquals(
                LispList.of(1, 5, 2, 6, 3, 4),
                LispList.of(1, 2, 3, 4).merge(LispList.of(5, 6)));

        // Second list longer
        Assertions.assertEquals(
                LispList.of(1, 3, 2, 4, 5, 6),
                LispList.of(1, 2).merge(LispList.of(3, 4, 5, 6)));

        // Singletons
        Assertions.assertEquals(
                LispList.of(0, -1),
                LispList.of(0).merge(LispList.of(-1)));
    }

    @Test
    void testOriginalListsUnchanged() {
        LispList xs = LispList.of(1, 2, 1, 3);
        LispList ys = LispList.of(4, 5);

        xs.removeAll(1);
        xs.merge(ys);

        Assertions.assertEquals(LispList.of(1, 2, 1, 3), xs);
        Assertions.assertEquals(LispList.of(4, 5), ys);
    }
}

