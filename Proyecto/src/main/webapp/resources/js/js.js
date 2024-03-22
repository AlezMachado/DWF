let carrito = [];

document.addEventListener("DOMContentLoaded", function() {
    const agregarBotones = document.querySelectorAll('.agregar-btn');
    agregarBotones.forEach(boton => {
        boton.addEventListener('click', function() {
            const producto = this.getAttribute('data-producto');
            const precio = parseFloat(this.getAttribute('data-precio'));
            agregarAlCarrito(producto, precio);
        });
    });
});

function agregarAlCarrito(producto, precio) {
    let productoExistente = carrito.find(item => item.producto === producto);
    if (productoExistente) {
        productoExistente.cantidad++;
    } else {
        carrito.push({ producto: producto, precio: precio, cantidad: 1 });
    }
    mostrarCarrito();
}

function mostrarCarrito() {
    const tablaCarrito = document.getElementById('tabla-carrito');
    tablaCarrito.innerHTML = '';
    let total = 0;

    carrito.forEach(item => {
        const fila = document.createElement('tr');
        fila.innerHTML = `
            <td>${item.producto}</td>
            <td>$${item.precio}</td>
            <td>${item.cantidad}</td>
        `;
        tablaCarrito.appendChild(fila);
        total += item.precio * item.cantidad;
    });

    const totalElement = document.getElementById('total');
    totalElement.textContent = `Total: $${total.toFixed(2)}`;
}
