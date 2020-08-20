<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <button type="button" class="btn btn-outline-danger" onclick="document.forms['logoutForm'].submit()">Log out</button></h2>
    </c:if>
  </div>

    <br>
    <h3>Voce pode votar apenas uma vez</h3>
    <br>

<div class="row">
  <div class="col-sm-4">
    <div class="card">
    <img src="resources/img/Le-Jardin.gif" class="card-img-top" alt="Le-Jardin">
      <div class="card-body">
        <h5 class="card-title">Resedencial Le-Jardin</h5>
        <p class="card-text">Apartamentos de 98 m2 com area de lazer completa, sendo 3 quartos com uma suite plena. A varanda ampla e o diferencial deste empreendimento, alem de um grande balcao para colocaco de diversas plantas.</p>

                    <form:form method="POST" action="/votos/votar" modelAttribute="user">
                         <input type="hidden" name="username" value= "${pageContext.request.userPrincipal.name}"/>
                         <input type="hidden" name="empid" value= "1"/>
                         <input type="submit" value="Votar"/>
                    </form:form>


      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card">
      <img src="resources/img/Evian.gif" class="card-img-top" alt="Evian">
      <div class="card-body">
        <h5 class="card-title">Resedencial Evian</h5>
        <p class="card-text">Empreendimento com apartamentos modernos de 75 m2 com duas suites. Aqui o foco e a praticidade, pois o condominio sera entregue com lavanderia, academia, espaco coworking e piscina com raia.</p>

                    <form:form method="POST" action="/votos/votar" modelAttribute="user">
                         <input type="hidden" name="username" value= "${pageContext.request.userPrincipal.name}"/>
                         <input type="hidden" name="empid" value= "2"/>
                         <input type="submit" value="Votar"/>
                    </form:form>


      </div>
    </div>
  </div>
  <div class="col-sm-4">
      <div class="card">
        <img src="resources/img/Olimpia-Thermas.gif" class="card-img-top" alt="Olimpia-Thermas">
        <div class="card-body">
          <h5 class="card-title">Resedencial Olimpia-Thermas</h5>
          <p class="card-text">Apartamentos de 120 m2 com 3 suites, sendo uma delas master. A area de lazer é o diferencial deste empreendimento, com tres churrasqueiras em areas reservadas, playground e brinquedoteca integrados, piscinas adulto e infantil, quadra poliesportiva e piscina aquecida com raia em area fechada.</p>

            <form:form method="POST" action="/votos/votar" modelAttribute="user">
                 <input type="hidden" name="username" value= "${pageContext.request.userPrincipal.name}"/>
                 <input type="hidden" name="empid" value= "3"/>
                 <input type="submit" value="Votar"/>
            </form:form>


        </div>
      </div>
    </div>
</div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
