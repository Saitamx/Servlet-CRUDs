<%-- 
    Document   : crudCliente
    Created on : 07-ene-2021, 15:28:12
    Author     : mtroncoc
--%>

<%-- Document : crudCliente Created on : 07-ene-2021, 15:28:12 Author : mtroncoc
--%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>CRUD Cliente</title>
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
            $(document).ready(function () {
                $(".btn.btn-warning").click(function () {
                    window.location.href = "crudCliente.jsp";
                });
            });
        </script>
    </head>
    <body>
        <main>
            <div class="container" style="background-color: #fafafa">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <form action="ClienteServlet" method="POST">
                            <h4>CRUD de Cliente</h4>
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
                                <label for="nombre">Nombre</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="nombre"
                                    name="txtNombre"
                                    value="${nombre}"
                                    />
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input
                                    type="email"
                                    class="form-control"
                                    id="email"
                                    name="txtEmail"
                                    value="${email}"
                                    />
                            </div>
                            <div class="form-group">
                                <label for="telefono">Teléfono</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="telefono"
                                    name="txtTelefono"
                                    value="${telefono}"
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

