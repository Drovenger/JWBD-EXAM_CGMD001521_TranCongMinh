package test;

import util.DBHandle;
import org.junit.jupiter.api.Test;

class DBHandleTest {

    @Test
    void getConnection() {
        System.out.println(DBHandle.getConnection());
    }
}