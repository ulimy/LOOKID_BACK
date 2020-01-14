<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOOKID 관리자 페이지</title>
</head>
<body>

	<%
		List<String> deviceList = new ArrayList<String>();
		List<String> childList = new ArrayList<String>();
		
		String device1 = request.getParameter("device1");
		String device2 = request.getParameter("device2");
		String device3 = request.getParameter("device3");
		String device4 = request.getParameter("device4");
		String device5 = request.getParameter("device5");
		String device6 = request.getParameter("device6");
		String device7 = request.getParameter("device7");
		String device8 = request.getParameter("device8");
		String device9 = request.getParameter("device9");
		String device10 = request.getParameter("device10");
		String device11 = request.getParameter("device11");
		String device12 = request.getParameter("device12");
		String device13 = request.getParameter("device13");
		String device14 = request.getParameter("device14");
		String device15 = request.getParameter("device15");
		String device16 = request.getParameter("device16");
		String device17 = request.getParameter("device17");
		String device18 = request.getParameter("device18");
		String device19 = request.getParameter("device19");
		String device20 = request.getParameter("device20");
		String device21 = request.getParameter("device21");
		String device22 = request.getParameter("device22");
		String device23 = request.getParameter("device23");
		String device24 = request.getParameter("device24");
		String device25 = request.getParameter("device25");
		String device26 = request.getParameter("device26");
		String device27 = request.getParameter("device27");
		String device28 = request.getParameter("device28");
		String device29 = request.getParameter("device29");
		String device30 = request.getParameter("device30");
		
		String child1 = request.getParameter("child1");
		String child2 = request.getParameter("child2");
		String child3 = request.getParameter("child3");
		String child4 = request.getParameter("child4");
		String child5 = request.getParameter("child5");
		String child6 = request.getParameter("child6");
		String child7 = request.getParameter("child7");
		String child8 = request.getParameter("child8");
		String child9 = request.getParameter("child9");
		String child10 = request.getParameter("child10");
		String child11 = request.getParameter("child11");
		String child12 = request.getParameter("child12");
		String child13 = request.getParameter("child13");
		String child14 = request.getParameter("child14");
		String child15 = request.getParameter("child15");
		String child16 = request.getParameter("child16");
		String child17 = request.getParameter("child17");
		String child18 = request.getParameter("child18");
		String child19 = request.getParameter("child19");
		String child20 = request.getParameter("child20");
		String child21 = request.getParameter("child21");
		String child22 = request.getParameter("child22");
		String child23 = request.getParameter("child23");
		String child24 = request.getParameter("child24");
		String child25 = request.getParameter("child25");
		String child26 = request.getParameter("child26");
		String child27 = request.getParameter("child27");
		String child28 = request.getParameter("child28");
		String child29 = request.getParameter("child29");
		String child30 = request.getParameter("child30");
		
		deviceList.add(device1);
		deviceList.add(device2);
		deviceList.add(device3);
		deviceList.add(device4);
		deviceList.add(device5);
		deviceList.add(device6);
		deviceList.add(device7);
		deviceList.add(device8);
		deviceList.add(device9);
		deviceList.add(device10);
		deviceList.add(device11);
		deviceList.add(device12);
		deviceList.add(device13);
		deviceList.add(device14);
		deviceList.add(device15);
		deviceList.add(device16);
		deviceList.add(device17);
		deviceList.add(device18);
		deviceList.add(device19);
		deviceList.add(device20);
		deviceList.add(device21);
		deviceList.add(device22);
		deviceList.add(device23);
		deviceList.add(device24);
		deviceList.add(device25);
		deviceList.add(device26);
		deviceList.add(device27);
		deviceList.add(device28);
		deviceList.add(device29);
		deviceList.add(device30);
		
		childList.add(child1);
		childList.add(child2);
		childList.add(child3);
		childList.add(child4);
		childList.add(child5);
		childList.add(child6);
		childList.add(child7);
		childList.add(child8);
		childList.add(child9);
		childList.add(child10);
		childList.add(child11);
		childList.add(child12);
		childList.add(child13);
		childList.add(child14);
		childList.add(child15);
		childList.add(child16);
		childList.add(child17);
		childList.add(child18);
		childList.add(child19);
		childList.add(child20);
		childList.add(child21);
		childList.add(child22);
		childList.add(child23);
		childList.add(child24);
		childList.add(child25);
		childList.add(child26);
		childList.add(child27);
		childList.add(child28);
		childList.add(child29);
		childList.add(child30);
		
	%>

	<h1>[디바이스]-[피보호자] 연결 리스트</h1>
	<hr>

	<%
		
		for(int i = 0; i < childList.size(); i++){
			if(!childList.get(i).equals("")){
				out.print("device" + (i+1) + " : " + deviceList.get(i) + " / " + "child" + (i+1) + " : " + childList.get(i) + "</br>");	
			}
		}	
	
	%>
		
</body>
</html>