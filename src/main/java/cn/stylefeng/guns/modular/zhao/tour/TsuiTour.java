/**
 * TsuiTour class
 *
 * @author ZhaoMing
 * @data 2018/12/28
 */
package cn.stylefeng.guns.modular.zhao.tour;

import java.util.*;

public class TsuiTour {

    static String FLAG = "0";
    public static void main(String[] args) {

        TsuiTour tsuiTour = new TsuiTour();

        while(true){
            tsuiTour.init();
            System.out.println(FLAG);
            if("-1".equalsIgnoreCase(FLAG)){
                break;
            }
        }
    }
    public void init(){
        System.out.println("请选择一个下列选项");
        System.out.println("===================");
        System.out.println("1、候选景点查看      2、候选方案查看       3、综合比较排名       0、返回      -1退出程序");

        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        if("".equalsIgnoreCase(choose)){
            System.out.println("未填写选项序号，请填写");
        }else{
            switch(choose){
                case "1" :showViewPoints(); break;
                case "2" :showCandidatePlan(); break;
                case "3" :
                    System.out.println("有待开发");break;
                case "0": break;
                case "-1":FLAG="-1"; break;
                default:break;
            }
        }

    }

    /**
     * 展示候选景点
     */
    public void showViewPoints(){
        Map<Integer,Viewpoint> viewpointMap = new HashMap<>();

        Viewpoint siNanRoud = new Viewpoint("思南路","靠近南京路步行街","free");
        Viewpoint chinaGllery = new Viewpoint("中国馆","浦东新区上南路205号","free");
        Viewpoint  thamesTown = new Viewpoint("泰晤士小镇","松江区三新北路","free");
        Viewpoint underwaterWorld = new Viewpoint("海底世界","靠近东方明珠","￥155/人");

        viewpointMap.put(0,siNanRoud);
        viewpointMap.put(1,chinaGllery);
        viewpointMap.put(2,thamesTown);
        viewpointMap.put(3,underwaterWorld);

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < viewpointMap.size() - 2 ; i++){
            builder.append("\t");
        }
        System.out.println();
        System.out.println("候选景点如下");
        System.out.println("景点名称          景点地址        景点价格");
        for (int i = 0; i < viewpointMap.size(); i++) {
            System.out.print(viewpointMap.get(i).getVname()+builder.toString());
            System.out.print(viewpointMap.get(i).getVaddress()+builder.toString());
            System.out.print(viewpointMap.get(i).getVprice());
            System.out.println();
        }
        System.out.println("--------------------");

    }

    /**
     * 展示候选方案
     */
    public void showCandidatePlan(){

        Candidateplan plan1 = new Candidateplan();
        plan1.setPname("计划一");
        plan1.setDesc("人文情怀向（思南路--》中国馆）");

        Candidateplan plan2 = new Candidateplan();
        plan2.setPname("计划二");
        plan2.setDesc("亲近自然向（海底世界）");

        Candidateplan plan3 = new Candidateplan();
        plan3.setPname("计划三");
        plan3.setDesc("古风古镇向（泰晤士小镇）");

        System.out.println("候选方案如下");
        System.out.println("---------------");
        System.out.println("计划一 || 计划二  ||  计划三");


        boolean flag = false;
        while(true){
            System.out.println("输入对应数字1或2或3查看, 按0返回主界面");
            Scanner scanner = new Scanner(System.in);
            String choosePlan = scanner.nextLine();
            switch (choosePlan){
                case "1":
                    System.out.println(plan1.getDesc());break;
                case "2":
                    System.out.println(plan2.getDesc());break;
                case "3":
                    System.out.println(plan3.getDesc());break;
                default: flag = true ; break;
            }
            if(flag){
                break;
            }
        }
        System.out.println("---------------");

    }
}


class Viewpoint{

    private String vname;
    private String vaddress;
    private String vprice;

    Viewpoint(String vname,String vaddress,String vprice){
        this.vname = vname;
        this.vaddress = vaddress;
        this.vprice = vprice;
    }
    Viewpoint(){}

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getVprice() {
        return vprice;
    }

    public void setVprice(String vprice) {
        this.vprice = vprice;
    }
}

class Candidateplan{
    private String pname;
    private String desc;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
