
$(document).ready(function(){

})


async function registrarUsuario(){

    let datos = {};
    datos.nombre = document.querySelector("#txtNombre").value;
    datos.apellido = document.querySelector("#txtApellido").value;
    datos.telefono = document.querySelector("#txtTelefono").value;
    datos.email = document.querySelector("#txtEmail").value;



    const request = await fetch('api/usuarios', {
            method: 'POST',
            headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
            });
    const usuarios = await request.json();
}