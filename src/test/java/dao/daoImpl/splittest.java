package dao.daoImpl;

import org.junit.Test;

/**
 * #Author :Sino
 * #Date   :2021/11/27 15:26
 * #Describe:
 */
public class splittest {
    String string = "555,222";
    String[] words = string.split(",");

    @Test
    public void testSplit() {
        for (String word : words) {
            System.out.println(word);
        }
    }
}
