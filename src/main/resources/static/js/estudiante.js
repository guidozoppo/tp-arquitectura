
$(document).ready(function(){
    cargarEstudiantes();
})

async function cargarEstudiantes(){
    const request = await fetch('api/estudiantes', {
        method: 'GET',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        });
    const estudiantes = await request.json();

    let listadoHtml = '';

    for(let estudiante of estudiantes){
        let estudianteHtml = '<tr><td>'+estudiante.dni+'</td><td>' + estudiante.nombre + ' ' + estudiante.apellido + '</td><td>'
                            + estudiante.edad+'</td><td>'+estudiante.genero+ '</td><td>'+estudiante.ciudad+'</td><td>'+estudiante.libretaUniversitaria+'</td></tr>';
            listadoHtml += estudianteHtml;
    }

    document.querySelector("#tablaEstudiantes tbody").outerHTML = listadoHtml;
}