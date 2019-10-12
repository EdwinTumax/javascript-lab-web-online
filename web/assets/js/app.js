$.ajax({
    url: 'http://192.168.31.145:9200/api/v1/categorias',
    data: { format: 'json'},
    error: function(){
        alert('Error al hacer la petición');
    },
    success: function(data){
        segmento = $('#datos');
        $.each(data,function(index,value){ 
            segmento.append('<tr><td>' + value.descripcion + '</td><td><button class="btn btn-success" type="button">Update</button></td><td><button class="btn btn-danger" type="button">Update</button></td></tr>');
        });
    },
    type: 'GET'
});