package cn.stylefeng.guns.modular.Zhao;

import com.google.gson.Gson;

import java.util.List;

public class ZTest {
    public static void main(String[] args) {
        String resultJson  = "{\"status\":200,\"data\":[输入参数转码正常{\"InspectionReportType\":1001,\"FileNameList\":[],\"UserName\":axu,\"IfRollbackWhenException\":true";
        String result = "{status: 200, data: [ 输入参数转码正常{InspectionReportType:1001,FileNameList:[C:\\\\var\\\\genechem\\\\limsmgr\\\\upload_files\\\\201812\\\\\\\"1001\\\"\\\\1544583550192\"],UserName:axu/徐爱赟,IfRollbackWhenException:true}]}";
        String resultNew = "[{\"status\": \"200\", \"data\": [ \"输入参数转码正常{\"InspectionReportType\":\"1001\",\"FileNameList\":[\"C:\\\\var\\\\genechem\\\\limsmgr\\\\upload_files\\\\201812\\\\\\\"1001\\\"\\\\1544583550192\"],\"UserName\":\"axu/徐爱赟\",\"IfRollbackWhenException\":true}]}]";
        System.out.println(resultNew+"==>");
        String strStatus = "{\"status\":\"200\",\"data\":[]}"; //正确的格式
        Gson gson = new Gson();
        FolacinOutputJson outputJson = gson.fromJson(strStatus,FolacinOutputJson.class);
        System.out.println(outputJson.getData());
    }
   class FolacinOutputJson {
       private String status;
       private List<String> data;

       public String getStatus() {
           return status;
       }

       public void setStatus(String status) {
           this.status = status;
       }

       public List<String> getData() {
           return data;
       }

       public void setData(List<String> data) {
           this.data = data;
       }
   }
}
