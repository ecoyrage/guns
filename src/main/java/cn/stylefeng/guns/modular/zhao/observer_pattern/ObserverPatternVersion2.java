/**
 * ObserverPatternVersion2 class
 *
 * @author ZhaoMing
 * @data 2018/12/26
 */
package cn.stylefeng.guns.modular.zhao.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternVersion2 {

    public final static String SATTE = "通知状态";
    public final static String STOP = "安静状态";

    public static void main(String[] args) {

        AbObserved zhansan = new Zhansan("张三","打游戏");
        AbObserved lisi = new Lisi("李四","看直播","man");

        AbObserver boss = new ObserverBoss();
        ((ObserverBoss) boss).attach(zhansan);
        ((ObserverBoss) boss).attach(lisi);
//        System.out.println("Boss不通知张三了");
//        ((ObserverBoss) boss).detach(zhansan);
        String result = ((ObserverBoss) boss).notifyObserver(ObserverPatternVersion2.STOP);
        System.out.println(result);

    }
}
//实现

class ObserverBoss extends AbObserver implements Inotify{
    private String indentify;

    private List<AbObserved> observeds = new ArrayList<>();

    public String getIndentify() {
        return indentify;
    }

    public void setIndentify(String indentify) {
        this.indentify = indentify;
    }


    public List<AbObserved> getObserveds() {
        return observeds;
    }

    public void setObserveds(List<AbObserved> observeds) {
        this.observeds = observeds;
    }

    @Override
    public String notifyObserver(String state) {
        if(state.equalsIgnoreCase(ActionState.NOTIFYSTATE.getAction())){
            for (AbObserved o: observeds) {
                o.changeAction();
            }

        }else{
            return "无事可做";

        }
        return "通知成功";
    }

    @Override
    public void attach(AbObserved observed) {
        this.observeds.add(observed);
    }

    @Override
    public void detach(AbObserved observed) {
        this.observeds.remove(observed);
    }
}


class Zhansan extends  AbObserved{

    Zhansan(String name,String presentAction){
        setName(name);
        setPresentAction(presentAction);
    }
    Zhansan(){}
    @Override
    String changeAction() {
        System.out.println(getName()+"收到通知，当前"+getPresentAction()+"的行为要发生变化了");
        return null;
    }
}

class Lisi extends AbObserved{

    private String gandar;


    Lisi(String name,String presentAction,String gandar){
        setName(name);
        setPresentAction(presentAction);
        setGandar(gandar);
    }

    public String getGandar() {
        return gandar;
    }

    public void setGandar(String gandar) {
        this.gandar = gandar;
    }

    @Override
    String changeAction() {
        System.out.println(getName()+"性别"+getGandar()+"收到通知，当前"+getPresentAction()+"的行为要发生变化了");
        return null;
    }
}

//=====================================================================

/**
 * 观察者
 */
abstract class AbObserver{

    protected String name;
}

/**
 * 被观察者
 */
abstract class AbObserved{
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPresentAction(String presentAction) {
        this.presentAction = presentAction;
    }

    public String getPresentAction() {
        return presentAction;
    }

    protected String presentAction;
    abstract String changeAction();
}

interface Inotify{
    /**
     *
     * @return  是否通知成功
     */
    String notifyObserver(String state);

    void attach(AbObserved observed);
    void detach(AbObserved observed);

}

/**
 * 状态枚举
 */
enum ActionState{
    /**
     *
     */
    NOTIFYSTATE("通知状态",1),

    SLIENCESTATE("安静状态",1);

    private String action;
    private int index;

    ActionState(String action,int index){
        this.action = action;
        this.index = index;
    }
    public String getAction(){
        return action;
    }

    public int getIndex() {
        return index;
    }
}








