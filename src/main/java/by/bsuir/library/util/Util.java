package by.bsuir.library.util;

import java.util.List;

public class Util<T> {

    public void printListIfNotEmpty(List<T> objects, String message) {
        if (!objects.isEmpty()) {
            objects.forEach(System.out::println);
        } else {
            System.out.println(message);
        }
    }

}
