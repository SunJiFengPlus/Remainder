package util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 孙继峰
 * @date 2019/05/19
 */
public class CollectionUtil {

    /**
     * 获得集合中随机的一个元素, 可以重载, 但是! 此项目中还用不到其他的
     * @param collection 集合
     * @return 集合中随机的一个元素
     */
    public static int getRandomElement(int[] collection) {
        int randomIndex = ThreadLocalRandom.current().nextInt(collection.length);
        return collection[randomIndex];
    }
}
