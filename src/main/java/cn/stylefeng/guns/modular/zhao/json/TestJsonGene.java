/**
 * TestJsonGene class
 *
 * @author ZhaoMing
 * @data 2019/1/17
 */
package cn.stylefeng.guns.modular.zhao.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestJsonGene {

    public static void main(String[] args) {

        JSONObject data = new JSONObject();

        //数据组
        data.put("基因位点","c.2573T");
        data.put("具有肺癌适应症的药物","balabala");
        data.put("药物敏感","敏感");
        data.put("参考范围","未发现突变");


       //条件组
        JSONObject bianhua = new JSONObject();
        JSONObject genename = new JSONObject();

        bianhua.put("p.L858R",data);
        genename.put("EGFR",bianhua);

        JSONObject projects = new JSONObject();
        projects.put("肺癌靶向",genename);

        JSONObject result = projects.getJSONObject("肺癌靶向")
                                    .getJSONObject("EGFR")
                                    .getJSONObject("p.L858R");

        System.out.println(projects);








    }
}
