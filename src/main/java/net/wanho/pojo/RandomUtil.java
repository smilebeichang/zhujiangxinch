package net.wanho.pojo;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by songb on 2019/10/7.
 */
public class RandomUtil {
    protected static final Logger log = Logger.getLogger(RandomUtil.class);

    public RandomUtil() {
    }

    public static String randomId() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 22);
        return uuid;
    }

    public static Object getRandomMapItem(Map<?, ?> map) {
        Object item = null;
        if(map != null && map.size() == 1) {
            item = map.values().toArray()[0];
        } else if(map != null && map.size() > 1) {
            int index = (int)(Math.random() * (double)map.size());
            item = map.values().toArray()[index];
        }

        return item;
    }

    public static Object getRandomListItem(List<?> list) {
        Object item = null;
        if(list != null && list.size() == 1) {
            item = list.get(0);
        } else if(list != null && list.size() > 1) {
            int index = (int)(Math.random() * (double)list.size());
            item = list.get(index);
        }

        return item;
    }

  /*  public static String getSunriseSessionId(String accountCode) {
        return randomId() + Base64Coder.encrypt(accountCode);
    }

    public static String getAccountCodeBySessionId(String sessionId) {
        String accountCode = "";

        try {
            String sessionid = sessionId.substring(22, sessionId.length());
            accountCode = Base64Coder.decrypt(sessionid);
        } catch (Exception var3) {
            log.error("异常：" + var3.getMessage());
            var3.printStackTrace();
        }

        return accountCode;
    }*/

    public static int get(int num, int index) {
        return (num & 1 << index) >> index;
    }

    public static Integer resplaceNumber(Integer Num, int index, int num) {
        if(Num != null) {
            if(Integer.toBinaryString(Num.intValue()).length() > index) {
                int tagetindex = get(Num.intValue(), index);
                if(tagetindex != num) {
                    if(num == 1) {
                        Num = Integer.valueOf(Num.intValue() + (int)Math.pow(2.0D, (double)index));
                    } else {
                        Num = Integer.valueOf(Num.intValue() - (int)Math.pow(2.0D, (double)index));
                    }
                }
            } else if(num == 1) {
                Num = Integer.valueOf(Num.intValue() + (int)Math.pow(2.0D, (double)index));
            }

            return Num;
        } else {
            return null;
        }
    }

    public static int randomNum(int seed) {
        return (new Random()).nextInt(seed);
    }

    public static String randomNumberString(int seed) {
        return System.currentTimeMillis() + "" + (int)((Math.random() * 9.0D + 1.0D) * Math.pow(10.0D, (double)seed));
    }

    public static void main(String[] args) {
        try {
            for(int i = 0; i < 100; ++i) {
                System.out.println(randomNum(1000));
            }
        } catch (Exception var2) {
            ;
        }

    }
}
