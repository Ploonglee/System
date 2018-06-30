<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<title>文件上传</title>
</head>
<body>
	<div class="modal-body">
		<form id="fileForm" action="${ctx}" method="post"
			<span style="background-color:rgb(255,255,102);"> enctype="multipart/form-data"</span>
			<span style="background-color:rgb(255,255,153);">target="message"</span>>
			<input
				type="<span style="background-color:rgb(255,255,51);">file</span>"
				name="fileUser" accept="xls/xlsx"><br>
		</form>
		<span style="background-color: rgb(255, 255, 51);"><iframe
				id='message' name='message' style="display: none;"></iframe></span>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary" data-dismiss="modal"
			id="submitFile">导入短号</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>

</body>

<script type="text/javascript">

$(function() {  
    $("#submitFile").click(function() {  
        $("#fileForm").submit();  
        $('#message').unbind('load').on('load', function() {  
            var result = $("#message").contents().find('body').text();  
            alert(result);  
        });  
    });  
});co  
</script>
</html>