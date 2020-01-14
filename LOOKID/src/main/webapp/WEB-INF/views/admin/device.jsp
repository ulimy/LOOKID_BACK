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
			<form method="post" action="./deviceAction">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">[디바이스]-[피보호자] 연결</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1. <input type="text" class="form-control" placeholder="기기 번호" name="device1" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child1" maxlength="50"/></td>
						</tr>
						<tr>
							<td>2. <input type="text" class="form-control" placeholder="기기 번호" name="device2" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child2" maxlength="50"/></td>
						</tr>
						<tr>
							<td>3. <input type="text" class="form-control" placeholder="기기 번호" name="device3" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child3" maxlength="50"/></td>
						</tr>
						<tr>
							<td>4. <input type="text" class="form-control" placeholder="기기 번호" name="device4" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child4" maxlength="50"/></td>
						</tr>
						<tr>
							<td>5. <input type="text" class="form-control" placeholder="기기 번호" name="device5" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child5" maxlength="50"/></td>
						</tr>
						<tr>
							<td>6. <input type="text" class="form-control" placeholder="기기 번호" name="device6" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child6" maxlength="50"/></td>
						</tr>
						<tr>
							<td>7. <input type="text" class="form-control" placeholder="기기 번호" name="device7" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child7" maxlength="50"/></td>
						</tr>
						<tr>
							<td>8. <input type="text" class="form-control" placeholder="기기 번호" name="device8" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child8" maxlength="50"/></td>
						</tr>
						<tr>
							<td>9. <input type="text" class="form-control" placeholder="기기 번호" name="device9" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child9" maxlength="50"/></td>
						</tr>
						<tr>
							<td>10. <input type="text" class="form-control" placeholder="기기 번호" name="device10" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child10" maxlength="50"/></td>
						</tr>
						<tr>
							<td>11. <input type="text" class="form-control" placeholder="기기 번호" name="device11" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child11" maxlength="50"/></td>
						</tr>
						<tr>
							<td>12. <input type="text" class="form-control" placeholder="기기 번호" name="device12" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child12" maxlength="50"/></td>
						</tr>
						<tr>
							<td>13. <input type="text" class="form-control" placeholder="기기 번호" name="device13" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child13" maxlength="50"/></td>
						</tr>
						<tr>
							<td>14. <input type="text" class="form-control" placeholder="기기 번호" name="device14" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child14" maxlength="50"/></td>
						</tr>
						<tr>
							<td>15. <input type="text" class="form-control" placeholder="기기 번호" name="device15" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child15" maxlength="50"/></td>
						</tr>
						<tr>
							<td>16. <input type="text" class="form-control" placeholder="기기 번호" name="device16" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child16" maxlength="50"/></td>
						</tr>
						<tr>
							<td>17. <input type="text" class="form-control" placeholder="기기 번호" name="device17" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child17" maxlength="50"/></td>
						</tr>
						<tr>
							<td>18. <input type="text" class="form-control" placeholder="기기 번호" name="device18" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child18" maxlength="50"/></td>
						</tr>
						<tr>
							<td>19. <input type="text" class="form-control" placeholder="기기 번호" name="device19" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child19" maxlength="50"/></td>
						</tr>
						<tr>
							<td>20. <input type="text" class="form-control" placeholder="기기 번호" name="device20" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child20" maxlength="50"/></td>
						</tr>
						<tr>
							<td>21. <input type="text" class="form-control" placeholder="기기 번호" name="device21" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child21" maxlength="50"/></td>
						</tr>
						<tr>
							<td>22. <input type="text" class="form-control" placeholder="기기 번호" name="device22" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child22" maxlength="50"/></td>
						</tr>
						<tr>
							<td>23. <input type="text" class="form-control" placeholder="기기 번호" name="device23" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child23" maxlength="50"/></td>
						</tr>
						<tr> 
							<td>24. <input type="text" class="form-control" placeholder="기기 번호" name="device24" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child24" maxlength="50"/></td>
						</tr>
						<tr>
							<td>25. <input type="text" class="form-control" placeholder="기기 번호" name="device25" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child25" maxlength="50"/></td>
						</tr>
						<tr>
							<td>26. <input type="text" class="form-control" placeholder="기기 번호" name="device26" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child26" maxlength="50"/></td>
						</tr>
						<tr>
							<td>27. <input type="text" class="form-control" placeholder="기기 번호" name="device27" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child27" maxlength="50"/></td>
						</tr>
						<tr>
							<td>28. <input type="text" class="form-control" placeholder="기기 번호" name="device28" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child28" maxlength="50"/></td>
						</tr>
						<tr>
							<td>29. <input type="text" class="form-control" placeholder="기기 번호" name="device29" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child29" maxlength="50"/></td>
						</tr>
						<tr>
							<td>30. <input type="text" class="form-control" placeholder="기기 번호" name="device30" maxlength="50"/>&nbsp;<input type="text" class="form-control" placeholder="피보호자" name="child30" maxlength="50"/></td>
						</tr>
						
					</tbody>
				</table>
				<input type="reset" value = "입력 내용 초기화">	
				<input type="submit" class="btn btn-primary pull-right" value="작성 완료" />
			</form>
		</div>
	</div>

</body>
</html>