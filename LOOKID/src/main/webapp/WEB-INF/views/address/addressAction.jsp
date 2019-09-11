<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 검색</title>
</head>
<body>

	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		new daum.Postcode({

			oncomplete : function(data) {

				if (data.userSelectedType == "R") {

					// userSelectedType : 검색 결과에서 사용자가 선택한 주소의 타입

					// return type : R - roadAddress, J : jibunAddress

					// LOOKID 은 안드로이드에서 등록한 이름

					window.LOOKID.setAddress(data.zonecode, data.roadAddress, data.buildingName);
				} else {
					window.LOOKID.setAddress(data.zonecode, data.jibunAddress, data.buildingName);
				}
			}
		}).open();
	</script>

</body>
</html>