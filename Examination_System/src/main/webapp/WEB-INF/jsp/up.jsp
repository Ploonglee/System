<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body>
	<form action="" method="post" enctype="multipart/form-data" id="form">
		<input type="file" name="filedata" id="filedata" /> 
		<input type="button" class="submit" value="上传" />
	</form>
</body>
<script type="text/javascript">
	$(".submit").click(function() {
		var formData = new FormData(document.getElementById("form"));
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/admin/upUser",
			data : formData,
			//不让ajax处理请求头
			contentType:false,
			//不让ajax处理发送的数据
			processData:false,
			ancType:"multipart/form-data",
			async : false,
			success : function(data) {
				alert(data.msg);
				window.location.reload();
			}
		});
	})
</script>
</html>