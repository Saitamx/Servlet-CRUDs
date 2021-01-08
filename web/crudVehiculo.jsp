<%-- 
    Document   : crudVehiculo
    Created on : 07-01-2021, 16:58:24
    Author     : piale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>CRUD Vehiculo</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
            crossorigin="anonymous"
            />
        <script
            defer
            src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"
        ></script>
        <script
            defer
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"
        ></script>
                         <script>
                    $(document).ready(function(){
                    $(".btn.btn-warning").click(function(){
                     window.location.href="crudVehiculo.jsp";
                    });
                    });
                </script>
    </head>
    <body>
        <main>
            <div class="container" style="background-color: #fafafa">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <form action="VehiculoServlet" method="POST">
                            <h4>CRUD de Vehículo</h4>
                            <div class="form-group">
                                <label for="id">ID</label>
                                <input
                                    type="number"
                                    class="form-control"
                                    id="id"
                                    name="txtId"
                                    value="${id}"
                                    />
                            </div>
                            <div class="form-group">
                                <label for="nombre">Patente</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="patente"
                                    name="txtPatente"
                                    value="${patente}"
                                    />
                            </div>
                            <div class="form-group">
                                <label for="color">Color</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="color"
                                    name="txtColor"
                                    value="${color}"
                                    />
                            </div>
                            <div class="form-group">
                                <label for="modelo">Modelo</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="modelo"
                                    name="txtModelo"
                                    value="${modelo}"
                                    />
                            </div>

                            <div class="form-group">
                                <input
                                    type="submit"
                                    class="btn btn-info"
                                    id="calcular"
                                    value="Buscar"
                                    name="bt"
                                    />
                            </div>
                            <div class="form-group">
                                <input
                                    type="submit"
                                    class="btn btn-warning"
                                    id="calcular"
                                    value="Registrar"
                                    name="bt"
                                    />
                            </div>
                            <div class="form-group">
                                <input
                                    type="submit"
                                    class="btn btn-info"
                                    id="calcular"
                                    value="Actualizar"
                                    name="bt"
                                    />
                            </div>
                            <div class="form-group">
                                <input
                                    type="submit"
                                    class="btn btn-info"
                                    id="calcular"
                                    value="Eliminar"
                                    name="bt"
                                    />
                            </div>

                            <div class="form-group">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="imc"
                                    disabled
                                    name="msj"
                                    value="${msj}"
                                    />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
