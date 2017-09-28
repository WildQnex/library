package by.bsuir.library.main;

import by.bsuir.library.cache.Cache;
import by.bsuir.library.cache.exception.CacheException;
import by.bsuir.library.view.Menu;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try (Cache cache = Cache.getInstance()) {
            Menu.getInstance().displayMainMenu();
        } catch (CacheException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

