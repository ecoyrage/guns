package cn.stylefeng.guns.modular.zhao.Simple_Factory_Pattern;

import java.util.Scanner;

/**
 * 实现一个控制台计算器：要求输入两个数和一个符号，得到结果
 */

public class SimpleFactoryPrograme {

    public static void main(String[] args) {
        double result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数");
        String numberA = scanner.nextLine();
        System.out.println("请输入第二个数");
        String numberB = scanner.nextLine();
        System.out.println("请输入运算符号");
        String strOperate = scanner.nextLine();
        /**第一种
        Integer result = Integer.parseInt(str1) + Integer.parseInt(str2);*/

        /**第二种
        if("+".equals(strOperate)){
            AddOperation addOperation = new AddOperation();
            addOperation.set_numberA(Double.parseDouble(numberA));
            addOperation.set_numberB(Double.parseDouble(numberB));
            result = addOperation.getResult();
        }*/

        /** 第三种  */
        Operation operation = OperationFactory.createOperation(strOperate);
        operation.set_numberA(Double.parseDouble(numberA));
        operation.set_numberB(Double.parseDouble(numberB));
        result = operation.getResult();

        System.out.println(result);

    }

    //优化点：1、是否进行输入校验、如何校验。2、输入的数字数量，是否支持批量。
    //      3、运算符号的种类，如何拓展。4、如何满足大数（高精度）要求
    //      5、数据安全性如何保证。

}

class OperationFactory{

    public static Operation createOperation(String strOperate){
        Operation operation = null;
        switch (strOperate){
            case "+":operation = new OperationAdd();break;
            case "-":operation = new OperationSub();break;
        }
        return operation;
    }

}

class Operation{
    private double _numberA = 0;
    private double _numberB = 0;

    public double get_numberA() {
        return _numberA;
    }

    public void set_numberA(double _numberA) {
        this._numberA = _numberA;
    }

    public double get_numberB() {
        return _numberB;
    }

    public void set_numberB(double _numberB) {
        this._numberB = _numberB;
    }

    public double getResult(){
        return 0;
    }
}

class OperationAdd extends Operation{
    @Override
    public double getResult(){
        double result = 0;
        result = get_numberA() + get_numberB();
        return result;
    }
}

class OperationSub extends Operation{
    @Override
    public double getResult(){
        double result = 0;
        result = get_numberA() - get_numberB();
        return result;
    }
}

abstract class Animal{
    public void getAdd(){
    }
}

