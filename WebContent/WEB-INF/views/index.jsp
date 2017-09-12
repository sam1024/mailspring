<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Enviar correo con spring</title>
		<style type="text/css">
			#div_form {
				border: 3px solid gray;
				width: 600px;
				height: 420px;
				border-radius: 3px;
				margin: auto;
				padding: 25px 50px;
			}

			input {
				margin: 0 0 10px 0;
				height: 35px;
				width: 500px;				
				padding: 1px;
			}
	
			.input_field {
				display: block;
				border: 1px solid gray;
    			border-radius: 3px;
			}
			
			#txtarea_msj {
			    height: 280px;
    			width: 600px;
			}
			
			#btn {
				margin-top: 5px;
    			height: 45px;
    			width: 100px;
    			background-color: #01579b;
    			border: 1px solid gray;
    			border-radius: 3px;
    			font-size: 25px;
    			color: #fff;
			}
		</style>
	</head>
<body>
	<div id="div_form">
		<form action="${pageContext.request.contextPath}/send" method="post">
			<input type="text" class="input_field" id="txt_to" placeholder="Para:" name="to">
			<input type="text" class="input_field" id="txt_subject" placeholder="Asunto:" name="asunto">
			<textarea class="input_field" id="txtarea_msj" placeholder="Mensaje:" name="msj"></textarea>
			<button id="btn">Enviar</button>
		</form>
	</div>	
</body>
</html>