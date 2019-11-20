<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.MalformedURLException"%>
<%@page import="java.io.IOException"%>

<%
   // 안드로이드 , 웹  - 공공데이터 포탈 실종아동 Open API 발급
    String esntlId = "10000287"; // 발급 ID
    String authKey = "78e54c5f554345cf"; // 발급 인증키
    String rowSize = "50"; // 게시물 수 ; 최근 실종신고건 부터 n명 씩 출력
    String pageNum = "1"; // 페이지
    String[] writngTrgetDscds = {"010", "060", "070"}; //010 정상아동, 060 지적장애인 , 070 치매질환자
    String sexdstnDscd = ""; // 성별
    String nm = ""; // 이름
    String detailDate1 = ""; // 시작발생일
    String detailDate2 = ""; // 종료발생일
    String age1 = ""; // 시작 당시나이
    String age2 = ""; // 종료 당시나이
    String etcSpfeatr = ""; // 신체특징
    String occrAdres = ""; // 발생장소
    String xmlUseYN = ""; // xml 사용여부
    
    String reference = ""; // 출처 

    String urlStr = "http://www.safe182.go.kr/api/lcm/amberList.do";

    String params = "esntlId=";
    params += esntlId;
    params += "&authKey=";
    params += authKey;
    params += "&rowSize=";
    params += rowSize;
    params += "&page=";
    params += pageNum;

    for(int i=0; i<writngTrgetDscds.length; i++){
        params += "&writngTrgetDscds=";
        params += writngTrgetDscds[i];
    }

    params += "&sexdstnDscd=";
    params += sexdstnDscd;
    params += "&nm=";
    params += nm;
    params += "&detailDate1=";
    params += detailDate1;
    params += "&detailDate2=";
    params += detailDate2;
    params += "&age1=";
    params += age1;
    params += "&age2=";
    params += age2;
    params += "&etcSpfeatr=";
    params += etcSpfeatr;
    params += "&occrAdres=";
    params += occrAdres;
    params += "&xmlUseYN=";
    params += xmlUseYN;

    URL url;
    URLConnection connection;
    OutputStreamWriter wr = null;
    InputStreamReader isr = null;
    BufferedReader br = null;

    String result = "";

    try{
        url = new URL(urlStr);
        connection = url.openConnection();
        connection.setDoOutput(true);

        wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(params);
        wr.flush();

        isr = new InputStreamReader(connection.getInputStream(), "utf-8");
        br = new BufferedReader(isr);
        String buf = "";

        while(true){
             buf = br.readLine();
             if(buf == null){
                 break;
             }else{
                 result = buf;
             }
         }

     } catch(MalformedURLException e){
         e.printStackTrace();
     } catch(IOException ioe){
         ioe.printStackTrace();
     } finally {
         wr.close();
         isr.close();
         br.close();
     }

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>실종정보 OPEN API</title>
<style type="text/css">
	body {margin:0px; padding:0px; font-size:12px; font-family:"돋움",Dotum,Helvetica,AppleGothic,Sans-serif; line-height:1.5em; color:#666;}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
    var resultStr = '<%= result %>';
    var jsonObject = jQuery.parseJSON(resultStr.replace(/\s/g, "<br />"));

    var _result = jsonObject.result;
    var _msg = jsonObject.msg;
    var _totalCount = jsonObject.totalCount;
    var _list = jsonObject.list;
    
    var status = ""; // 대상구분
    var address =""; // 주소 open API 형식 수정

    function rand(){ // 미아공고 랜덤 출력;  랜덤정수 1~50
       return Math.floor(Math.random() * 50) + 1;
    }   
 
    var j = rand();
    for(var i=0; i<_list.length; i++){
      
      if(_list[i].rnum == j){ // rnum : 신고 건 고유번호 (캡슐화되어있음) ; 웹 우클릭 -> 소스보기
         
      	  // 가변길이
    	  //document.write('<table border="1" width="100%" height="100%" bgcolor="#ffdb70" cellspacing=0.1 style="font-size:1em; color: #222b3c; font-family: NotoSansCJKkrBold">'); 
          //bgcolor : 테이블 색, cellspacing : 테이블 테두리 가늘기,  color : 폰트색 , width/height : 100% 크기에 맞게 자동조절, font-family: 폰트, font-size:1em 폰트크기(가변)
    	  
      	   // 고정길이  1.6:1.0
      	   document.write('<table border="1" width="100%" height="720" bgcolor="#ffdb70" cellspacing=0.1 style="font-size:1em; color: #222b3c; font-family: NotoSansCJKkrBold">'); 
           
           // 폰트크기 : style="font-size:1em;"
           document.write('    <tr>');
           document.write('        <th>사진</th>'); // 사진 테이블 크기 조정 (고정크기o 가변x)
           document.write('        <th>신상정보&nbsp;&nbsp;[자료 출처:경찰청]</th>');
           document.write('    </tr>');
          
           document.write('    <tr>');
          
           // 사진
           if( _list[i].tknphotolength != "0" )
               document.write("        <td><a href='http://www.safe182.go.kr/home/lcm/lcmMssGet.do?gnbMenuCd=014000000000&lnbMenuCd=014001000000&rptDscd=2&msspsnIdntfccd=" + _list[i].msspsnIdntfccd + "'><img style='width:100%px;height:100%px;' width='100%' height='100%' border='0' src='http://www.safe182.go.kr/api/lcm/imgView.do?msspsnIdntfccd=" + _list[i].msspsnIdntfccd + "'/></a></td>");
           else
               document.write("        <td align=center bgcolor=#D8D8D8>사진없음</td>");      
           
           /* 
              대상구분
               010 정상아동, 020 가출인, 040 시설보호무연고자, 060 지적장애인, 061 지적장애인(18세미만), 062 지적장애인(18세이상), 070 치매질환자, 080 불상(기타)
           */
           if(_list[i].writngTrgetDscd == "010"){
            status = "정상아동";
           }
           else if(_list[i].writngTrgetDscd == "020"){
            status = "가출인";
           }
           else if(_list[i].writngTrgetDscd == "040"){
              status = "시설보호무연고자";
           }
           else if(_list[i].writngTrgetDscd == "060"){
              status = "지적장애인";
           }
           else if(_list[i].writngTrgetDscd == "061"){
              status = "지적장애인(18세미만)";
           }
           else if(_list[i].writngTrgetDscd == "062"){
              status = "지적장애인(18세이상)";
           }
           else if(_list[i].writngTrgetDscd == "070"){
              status = "치매질환자";
           }
           else if(_list[i].writngTrgetDscd == "080"){
              status = "불상(기타)";
           }
           
           address = _list[i].occrAdres.split(' '); // API 주소형식 변환
          
           // 신상정보   
           document.write('<td align="center" style="font-weight: bold; color: #222b3c; font-family: NotoSansCJKkrBold">' + "이름: " + _list[i].nm + "&nbsp;(" + status +")<br/>성별: " + _list[i].sexdstnDscd + "<br/>발생일시: " + _list[i].occrde + "<br/>발생장소: " + address + "<br/>현재나이: " + _list[i].ageNow + "&nbsp;(당시나이: " + _list[i].age + ")<br/>인상착의: " + _list[i].alldressingDscd  + "<br/><br/>실종신고: 112<br/>경찰청 실종아동찾기센터: 182" + '</td>');
           document.write('    </tr>');
           document.write('</table>');   
         
      }
         
   }
   
   setTimeout("location.reload()",10000); // 10초마다 페이지 갱신
   
   /*
      최근 실종 접수 50건(모든 연령) 10초마다 랜덤 출력 (새로운 실종 접수 데이터는 경찰청으로 부터 자동갱신됨)
      랜덤으로 출력해야 가장 최근에 신고가 접수된 미아만 계속 출력되는것을 방지할 수 있다.
   */

</script>
</head>
<body>
</body>
</html>