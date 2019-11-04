<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.MalformedURLException"%>
<%@page import="java.io.IOException"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>실종경보 템플릿</title>
</head>
<body>

   <%
      URL url;
      URLConnection connection;
      InputStream is = null;
      InputStreamReader isr = null;
      BufferedReader br = null;
      String strHTML = "";

      try {
         //인증 ID 인증 발급키 입력
         //viewType=01~03
         url = new URL(
               "http://www.safe182.go.kr/api/lcm/amberListTForm.do?esntlId=10000287&authKey=78e54c5f554345cf&viewType=02");
         connection = url.openConnection();
         is = connection.getInputStream();
         isr = new InputStreamReader(is, "utf-8");
         br = new BufferedReader(isr);
         String buf = "";
         
         while (true) {
            buf = br.readLine();
            if (buf == null) {
               break;
            } else {
               strHTML += (buf + "\n");
            }
         }

      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } finally {
         is.close();
         isr.close();
         br.close();
      }

      out.print(strHTML);
      
   %>
   

</body>
</html>