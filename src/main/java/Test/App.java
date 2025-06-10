package Test;
import DAOs.ImagenDAO;
import Entities.*;
import Entities.Empresa;
import Enums.Estado;
import Enums.FormaPago;
import Enums.TipoEnvio;
import Enums.TipoPromocion;
import java.time.*;

// INTEGRANTES: NAVARRIA, MARINO, CRESPO Y SANTOS

public class App {
    public static void main(String[] args) {

        // DATOS GEOGRAFICOS
        // Paises
        Pais argentina = Pais.builder()
                .nombre("Argentina")
                .build();

        // Provincias
        Provincia mendoza = Provincia.builder()
                .nombre("Mendoza")
                .build();

        // Localidades
        Localidad godoyCruz = Localidad.builder()
                .nombre("Godoy Cruz")
                .build();

        // Domicilios
        Domicilio sanMartinSur = Domicilio.builder()
                .calle("San Martin")
                .cp(5500)
                .numero(2896)
                .localidad(godoyCruz)
                .build();

        // Agregar datos geograficos
        argentina.agregarProvincia(mendoza);
        mendoza.agregarLocalidad(godoyCruz);
        godoyCruz.agregarDomicilio(sanMartinSur);
        godoyCruz.verDomicilios(); //Probando ver los domicilios de la Localidad

        // -------------------------------------------------------

        // DATOS DE EMPRESA
        // Crea la empresa
        Empresa buenSabor = Empresa.builder()
                .nombre("Mental") // Asigna el nombre.
                .razonSocial("El Heredero de Dios") // Asigna la razón social.
                .cuil(54584569) // Asigna el CUIL.
                .build();

        // Sucursales de Buen Sabor
        Sucursal sucMendoza = Sucursal.builder()
                .nombre("Mendoza")
                .horarioApertura(LocalTime.of(8,00))
                .horarioCierre(LocalTime.of(21,00))
                .domicilio(sanMartinSur)
                .build();

        // Agregar a sucursal
        buenSabor.agregarSucursal(sucMendoza);

        // Muestro empresa
        System.out.println(buenSabor.toString());

        // -------------------------------------------------------

        // CLIENTES
        // Crear cliente
        Cliente charlyCimino = Cliente.builder()
                .nombre("Charly")
                .apellido("Cimino")
                .telefono("4932322")
                .email("ciminocharly@gmail.com")
                .fechaNacimiento(LocalDate.of(1986,02,12))
                .build();

        // -------------------------------------------------------

        // USUARIOS
        // Crear usuario
        Usuario charly = Usuario.builder()
                .auth0Id("6549682")
                .username("elCharlyProfeOk")
                .cliente(charlyCimino)
                .build();

        // Crear imagen
        Imagen foto = Imagen.builder()
                .denominacion("fotoCharlyEnLaPlaya.jpg")
                .build();

        //Agregar imagen a cliente
        charlyCimino.setImagen(foto);

        // Muestro usuario
        System.out.println(charlyCimino.toString());

        // -------------------------------------------------------

        // ARTICULOS
        // Crear articulos insumo
        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .precioVenta(152000.00)
                .precioCompra(350000.00)
                .unidad(UnidadMedida.builder()
                        .denominacion("Kilos")
                        .build())
                .stockActual(52)
                .stockMaximo(150)
                .esParaElaborar(true)
                .build();

        // Crear articulos
        ArticuloManufacturado empanada = ArticuloManufacturado.builder()
                .descripcion("Empanada")
                .tiempoEstimadoMinutos(120)
                .unidad(UnidadMedida.builder()
                        .denominacion("Kilos")
                        .build())
                .preparacion("Empanadas Fritas")
                .build();

        //Agregar detalle a los articulos
        harina.agregarDetalle(ArticuloManufacturadoDetalle.builder()
                .cantidad(25)
                .insumo(harina)
                .build());
        empanada.agregarDetalle(ArticuloManufacturadoDetalle.builder()
                .cantidad(10)
                .build()); //Faltan insumos

        //Muestro articulos
        System.out.println(harina.toString() + "\n" + empanada.toString());

        // -------------------------------------------------------

        // PROMOCIÓN
        // Crear Promocion
        Promocion promocion = Promocion.builder()
                .denominacion("Promocion empanadas")
                .FechaDesde(LocalDate.of(2025, 05, 25))
                .FechaHasta(LocalDate.of(2025, 07, 25))
                .HoraDesde(LocalTime.of(00, 00))
                .HoraHasta(LocalTime.of(00, 00))
                .descripcionDescuento("Empanadas Recargo Darin")
                .precioPromocional(48000.00)
                .tipoPromocion(TipoPromocion.PROMOCION1)
                .build();

        //Agregando articulo e imagen
        Imagen imagen = Imagen.builder()
                .denominacion("Empanada de oro")
                .build();
        promocion.agregarArticulo(empanada);
        promocion.agregarImagen(imagen);

        //Mostrar promocion
        System.out.println(promocion);

        //Removiendo articulo e imagen
        promocion.removerArticulo(empanada);
        promocion.removerImagen(imagen);

        //Muestro promoción
        System.out.println(promocion);

        // -------------------------------------------------------

        // CATEGORÍA
        //Crear categoria
        Categoria categoria = Categoria.builder()
                .denominacion("Comestible")
                .build();

        //Agregando articulo y subcategoria
        categoria.agregarArticulo(empanada);
        categoria.agregarSubCategoria(Categoria.builder()
                .denominacion("Rotiseria")
                .build());

        //Mostrar Categoria
        System.out.println(categoria);

        //Removiendo articulo y subcategoria
        categoria.removerArticulo(empanada);
        categoria.removerSubCategoria(Categoria.builder()
                .denominacion("Rotiseria")
                .build());

        //Muestro categoría
        System.out.println(categoria);

        // -------------------------------------------------------

        // PEDIDO
        //Crear factura
        Factura factura = Factura.builder()
                .fechaFacturacion(LocalDate.of(2025, 05, 27))
                .mpPaymentId(123)
                .mpMerchantOrderId(456)
                .mpPreferenceId("juansalvo.mp")
                .mpPaymentType("Transferencia")
                .formaPago(FormaPago.MERCADOPAGO)
                .totalVenta(48000.00)
                .build();

        //Crear pedido
        Pedido pedido = Pedido.builder()
                .horaEstimadaFinalizacion(LocalTime.of(21, 30))
                .total(55000.00)
                .totalCosto(48000.00)
                .estado(Estado.PREPARACION)
                .tipoEnvio(TipoEnvio.DELIVERY)
                .formaPago(FormaPago.MERCADOPAGO)
                .fechaPedido(LocalDate.of(2025, 05, 27))
                .sucursal(sucMendoza)
                .domicilio(sanMartinSur)
                .factura(factura)
                .build();

        //Agregando detalles del pedido
        DetallePedido detallePedido = DetallePedido.builder()
                .cantidad(65)
                .subTotal(48000.00)
                .articulo(empanada)
                .build();

        //Agrega detalle pedido
        pedido.agregarDetallePedido(detallePedido);

        //Mostrar pedido
        System.out.println(pedido);

        //Removiendo detalles
        pedido.removerDetallePedido(detallePedido);

        System.out.println(pedido);


        //DAO CONEXION CON DB
        ImagenDAO imagenConectarDAO = ImagenDAO.builder()
                .build();

        //Agrega a la base de datos
        imagenConectarDAO.cargarImagenEnDB(Imagen.builder()
                .denominacion("empanadasA48000.jpg")
                .build());

        //Elimina de la base de datos
        /*imagenConectarDAO.borrarImagenDeDB(Imagen.builder()
                .id(1)
                .build());*/

    }
}

// INTEGRANTES: NAVARRIA, MARINO, CRESPO Y SANTOS
