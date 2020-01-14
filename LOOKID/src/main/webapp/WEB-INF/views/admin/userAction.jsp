<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>LOOKID 관리자페이지</title>
</head>
<body>

	<h1 align="center">LOOKID 관리자페이지</h1>
	<hr>

	<div class="container">
		<div class="row">
			<form method="post" action="./userAction">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">사용자 정보</th>
						</tr>
					</thead>
					<tbody>
						<tr>						
							<td>							
								<%
									int j = 1;
									
									for(int i = 1; i <= 500; i++){
								
										Object vo = request.getAttribute("userInfo" + Integer.toString(i));
										
										if(vo != null){				
											out.print(j + ". </br></br>");
											out.print(vo + "<hr>");
											j++;
										}
									}
								%>							
								
							</td>						
						</tr>
					
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>