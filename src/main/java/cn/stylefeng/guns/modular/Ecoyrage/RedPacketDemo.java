package cn.stylefeng.guns.modular.Ecoyrage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @program: guns
 * @description:
 * @author: Chenchao
 * @create: 2018-11-05 16:57
 **/
public class RedPacketDemo {

    public static void main(String[] args) {
        List<Integer> redp=Red(1,2000);
        Iterator it=redp.iterator();
        while (it.hasNext()){
            System.out.print(it.next());
            System.out.print(",");
        }

    }
    /**
     *
     * @param remainSize 数量
     * @param totalReward 金额（*100之后的值）
     * @return
     */
    public List<Integer> Red(Integer remainSize,Integer totalReward) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱 ,2,BigDecimal.ROUND_HALF_UP
        List<Integer> redPacketMoney = new ArrayList<>();
        BigDecimal remainMoney = new BigDecimal(totalReward * 0.01);
        int peilv = remainSize/200;
        if(peilv >= 15){
            peilv = 15;
        }else if(peilv < 10){
            peilv = 10;
        }
        int number = remainSize;
        for (int i = 1; i <= number; i++) {
            if (remainSize == 1) {
                remainSize--;
                Integer rpMoney=remainMoney.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
                redPacketMoney.add(rpMoney);
                break;
            }
            double min = 0.01;
            BigDecimal b = remainMoney.divide(new BigDecimal(remainSize), 2, BigDecimal.ROUND_HALF_EVEN);
            BigDecimal max = new BigDecimal("0");
            Random r = new Random();
            int num = r.nextInt(number);
            double ratio = remainSize * 0.18;
            if (0 < num && num <= ratio) {
                ratio = remainSize * 0.01;
                if (0 < num && num <= ratio) {
                    max = b.multiply(new BigDecimal(peilv));
                } else {
                    if (b.compareTo(new BigDecimal(0.1)) == -1) {
                        max = b.multiply(new BigDecimal(peilv));
                    } else {
                        BigDecimal gg = b.subtract(new BigDecimal(0.09)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                        BigDecimal g = new BigDecimal(peilv).subtract(gg.multiply(new BigDecimal(100))).setScale(0, BigDecimal.ROUND_HALF_EVEN);
                        if (g.compareTo(new BigDecimal(6)) == -1) {
                            g = new BigDecimal(6);
                        }
                        max = b.multiply(g);
                    }
                }
            } else {
                if (i < remainSize / 2) {
                    max = b.multiply(new BigDecimal("1.4"));
                } else {
                    max = b.multiply(new BigDecimal("1.8"));
                }
            }
            BigDecimal m = new BigDecimal(r.nextDouble() * max.doubleValue());
            double money = m.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            money = money <= min ? 0.01 : money;
            remainSize--;
            remainMoney = remainMoney.subtract(new BigDecimal(money)).setScale(2, BigDecimal.ROUND_HALF_UP);
            Integer rpMoney=new BigDecimal(money).multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
            redPacketMoney.add(rpMoney);
        }
        return redPacketMoney;
    }
}
