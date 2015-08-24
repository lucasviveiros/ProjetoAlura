<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${not empty usuarioLogado }">
 	Logado como ${usuarioLogado.email}<br/>
</c:if>

Bem vindo ao nosso gerenciador de empresas!<br/>
<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="NovaEmpresa"/>
	Nome: <input type="text" name="nome">
	<input type="submit" value="Enviar">
</form>
<form action="login" method="POST">
	Email:<input type="email" name="email"/>
	Senha:<input type="password" name="senha"/>
	<input type="submit" value="Enviar">

</form>


	<form action="executa" method="POST">
		<input type="hidden" name="tarefa" value="Logout"/>
		<input type="submit" value="Deslogar"/>
	
	</form>
</body>
</html>