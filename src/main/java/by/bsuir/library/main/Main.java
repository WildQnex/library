package by.bsuir.library.main;

import by.bsuir.library.cache.Cache;
import by.bsuir.library.ui.Menu;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try (Cache cache = Cache.getInstance()) {

            Menu.rootMenu.display();

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
