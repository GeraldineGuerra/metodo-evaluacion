$(document).ready(function(){

    $('#listar').on('click', function(){
        let tabla = document.querySelector('#tabla');
        $.ajax({
            url: "http://localhost:8080/mostrarProd",
            type: "GET",
            dataTyoe: "JSON",
            success:  function(respuesta){
                console.log(respuesta);
            for (i = 0; i<= respuesta.length; i++){
                tabla.innerHTML+='<tr><td>' + respuesta[i].codigo+ '</td></tr>'
                tabla.innerHTML+='<tr><td>' + respuesta[i].nombre+ '</td></tr>'
                tabla.innerHTML+='<tr><td>' + respuesta[i].precio+ '</td></tr>'
                tabla.innerHTML+='<tr><td>' + respuesta[i].categoria+ '</td></tr>'
                tabla.innerHTML+='<tr><td>' + respuesta[i].cantidad+ '</td></tr>'
              
            }
            }
        })
    })


    


$.ajax({
    url: '/actualizar',
    type: 'PUT',
    data: JSON.stringify({
        codigo: 1,
        nombre: 'nuevo nombre',
        precio: 6000.0,
        categoria: 'frutas',
        cantidad: 10
    }),
    contentType: 'application/json; charset=utf-8',
    success: function() {
        console.log('Producto actualizado');
    },
    error: function() {
        console.log('Error al actualizar producto');
    }
});


})