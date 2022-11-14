
$(document).ready(function(){
    cargarUsuarios();
})

async function cargarUsuarios(){
    const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        });
    const usuarios = await request.json();

    let listadoHtml = '';
    for(let usuario of usuarios){
        let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
                            + usuario.email+'</td><td>'+usuario.telefono+ '</td></tr>';
            listadoHtml += usuarioHtml;
    }

    document.querySelector("#tablaEstudiantes tbody").outerHTML = listadoHtml;
}




