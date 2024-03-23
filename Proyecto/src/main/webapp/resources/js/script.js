$(document).ready(function () {
    $('.comprar-btn').click(function () {
        var nombre = $(this).closest('.card').find('.card-title').text();
        var precio = parseFloat($(this).closest('.card').find('.card-text').text().substring(1));
        agregarProducto(nombre, precio);
    });

    $('.btn-realizar-compras').click(function() {
        alert("Compra realizada con éxito");
    });

    function agregarProducto(nombre, precio) {
        var filaExistente = $('#tablaProductos').find('tr[data-nombre="' + nombre + '"]');
        if (filaExistente.length > 0) {
            var cantidadActual = parseInt(filaExistente.find('.cantidad').text());
            filaExistente.find('.cantidad').text(cantidadActual + 1);
            filaExistente.find('.precio-total').text((cantidadActual + 1) * precio);
        } else {
            var fila = $('<tr data-nombre="' + nombre + '"><td class="text-white">' + nombre + '</td><td class="text-white">' + precio + '</td><td class="cantidad text-white">1</td><td class="precio-total text-white">' + precio + '</td></tr>');
            $('#tablaProductos').append(fila);
        }

        var total = 0;
        $('#tablaProductos .precio-total').each(function () {
            total += parseFloat($(this).text());
        });
        $('#totalPrecio').text(total);
    }
});