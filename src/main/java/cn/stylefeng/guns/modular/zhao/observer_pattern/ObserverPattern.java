/**
 * ObserverPattern class
 *
 * @author ZhaoMing
 * @data 2018/12/26
 */
package cn.stylefeng.guns.modular.zhao.observer_pattern;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ObserverPattern {
    public final static String SATTE = "notify";
    public static void main(String[] args) {
        Observed observed1 = new Observed("张三");
        observed1.setPresentAction("打游戏");
        Observed observed2 = new Observed("李四");
        observed2.setPresentAction("看直播");

        List<Observed> observeds = new ArrayList<>();
        observeds.add(observed1);
        observeds.add(observed2);

        Observer observer = new Observer();

        observer.setState(ObserverPattern.SATTE);

        observer.notifyObserved(observeds);


    }
}
//观察者
class Observer{
    /**
     * 观察者状态：是否通知被观察者
     *
     */
    private String state;

    /**
     *
     * @return
     */
    public String notifyObserved(List<Observed> observeds){
        if(ObserverPattern.SATTE.equalsIgnoreCase(getState())){
            for (Observed o: observeds) {
                o.changeAction();
            }
        }else{
            return "无事发生";
        }
        return null;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
//被观察者
class Observed{
    private String name;

    /**
     * 当前行为
     */
    private String presentAction;


    Observed(String name){
        this.name = name;
    }
    Observed(){}
    public String changeAction(){
        System.out.println(getName()+"收到通知，当前"+getPresentAction()+"的行为要发生变化了");
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresentAction() {
        return presentAction;
    }

    public void setPresentAction(String presentAction) {
        this.presentAction = presentAction;
    }
}
