package com;

import com.tls.sigcheck.tls_sigcheck;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

// 由于生成 sig 和校验 sig 的接口使用方法类似，故此处只是演示了生成 sig 的接口调用

// 使用的编译命令是
// javac -encoding utf-8 Demo.java
// 使用的运行命令是
// java Demo

public class Demo { 

    public static void main(String args[]) throws Exception {
        Demo the=new Demo();

//        tls_sigcheck demo = new tls_sigcheck();
////
////        // 使用前请修改动态库的加载路径
//        demo.loadJniLib("C:\\Users\\Administrator\\Desktop\\jnisigcheck.dll");
//////        demo.loadJniLib("/home/tls/tls_sig_api/src/jnisigcheck.so");
//
//        File priKeyFile = new File("C:\\Users\\Administrator\\Desktop\\private_key");
//        StringBuilder strBuilder = new StringBuilder();
//        String s = "";
//
//        BufferedReader br = new BufferedReader(new FileReader(priKeyFile));
//        while ((s = br.readLine()) != null) {
//            strBuilder.append(s + '\n');
//        }
//        br.close();
//        String priKey = strBuilder.toString();
////		int ret = demo.tls_gen_signature_ex2("1400155242", "xiaojun", priKey);
//        int ret=demo.tls_gen_signature_ex2_with_expire("1400155242","admin",priKey,"31536000");
////
//        if (0 != ret) {
//            System.out.println("ret " + ret + " " + demo.getErrMsg());
//        }
//        else
//        {
//            System.out.println("sig:\n" + demo.getSig()+"\n"+demo.getExpireTime());
//
//        }
////        System.out.println(the.getExpireTime("eJxlj11PgzAYhe-5FQ23M1JKq7i76UhGVMI2cLKbBtsO6hzUruwjxv-uxCVr4nv7PDnnvF8OAMDNnubXJWNt1xhqjkq4YAhc6F5doFKS09LQQPN-UByU1IKWKyN0D31CCILQdiQXjZEreTYOsmzfu8YStnxN*5a-BAzhKQVhZCuy6uFzVDzE0-Ecrz*y2c1dkufECyadjsbJwFQLlQSfk*I*5oItd34NPbyP61EKM6-Ni8HjJjSviLGXYs9Tv0p1eSuSxRQt36JMHXMcjmqr0siNOL*EUUgQgYFFd0JvZdv0Ajrt9VEAf891vp0fnmtc8g__"));
//
//
//        File pubKeyFile = new File("C:\\Users\\Administrator\\Desktop\\public_key");
//        br = new BufferedReader(new FileReader(pubKeyFile));
//		strBuilder.setLength(0);
//        while ((s = br.readLine()) != null) {
//            strBuilder.append(s + '\n');
//        }
//        br.close();
//        String pubKey = strBuilder.toString();
//		ret = demo.tls_check_signature_ex2(demo.getSig(), pubKey, "1400155242", "xiaojun");
//        if (0 != ret) {
//            System.out.println("ret " + ret + " " + demo.getErrMsg());
//        }
//        else
//        {
//            System.out.println("--\nverify ok -- expire time " + demo.getExpireTime() + " -- init time " + demo.getInitTime());
//        }
        //过期时间10年
        System.out.println(the.getExpireTimeRR("eJxl0E1Pg0AQgOE7v4LsFWP3g6VNEw9YMBZrTKzU1ssG2QVGLcVlsVXjf1dXEzdxrs*bzGTePd-30c1ieVyU5W5ojTCvnUL*1EcYHf1h14EUhRFMy3*oDh1oJYrKKG2REc4ijN0GpGoNVPBbFHILrcO9fBR2h1USYkw4pyF1E6gtXqb5bJ483M1IHjQJOx3Onhh5izdpnNblhd5cZSRjdIlVrgaiAhZDGkcxe4b7DHRe1nhPaRJd98143Syq89sRx0W9mgcHssZqtD9xVhrY-ryC8JBOeDjhY0dflO5h19qAft1LKMPfg7wP7xMIVlrM"));

    }

    public int getExpireTimeRR(String sig) throws IOException {
        tls_sigcheck demo = new tls_sigcheck();
        demo.loadJniLib("C:\\Users\\Administrator\\Desktop\\jnisigcheck.dll");
        File pubKeyFile = new File("C:\\Users\\Administrator\\Desktop\\public_key");
        StringBuilder strBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(pubKeyFile));
        String s = "";
        strBuilder.setLength(0);
        while ((s = br.readLine()) != null) {
            strBuilder.append(s + '\n');
        }
        br.close();
        String pubKey = strBuilder.toString();

        int ret = demo.tls_check_signature_ex2(sig, pubKey, "1400155242", "admin");
        if (0 != ret) {
            System.out.println("ret " + ret + " " + demo.getErrMsg());
            return ret;
        }
        else
        {
            System.out.println("--\nverify ok -- expire time " + demo.getExpireTime() + " -- init time " + demo.getInitTime());
            return demo.getExpireTime();
        }

    }

}
