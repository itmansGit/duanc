package com.duanc.utils;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SMS {

	public boolean sentSMS(String PhoneNo,String password) throws HttpException, IOException{

	HttpClient client = new HttpClient();
	PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
	post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
	NameValuePair[] data ={ new NameValuePair("Uid", "duanchao"),new NameValuePair("Key", "3429ca1de594ac33c875"),new NameValuePair("smsMob",PhoneNo),new NameValuePair("smsText","【手掌】："+ password +"，非本人操作请及时联系管理员或修改密码")};
	post.setRequestBody(data);

	client.executeMethod(post);
	Header[] headers = post.getResponseHeaders();
	int statusCode = post.getStatusCode();
	System.out.println("statusCode:"+statusCode);
	for(Header h : headers)
	{
	System.out.println(h.toString());
	}
	String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
	System.out.println(result); //打印返回消息状态

	post.releaseConnection();
	if(Integer.parseInt(result) > 0){
		return true;
	}
	return false;
	}

}
