import { useEffect, useState } from "react";
import { Button, Card, CardBody, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import { ProductoServicio } from "../../aplicacion/servicios/ProductoServicio";

const Home = () => {
  const [productos, setProductos] = useState([]);

  const getProductos = async () => {
    try {
      const data = await ProductoServicio.obtenerTodos();
      setProductos(data);
    } catch {
      alert("Error al cargar productos");
    }
  };

  const eliminarProducto = async (id: number) => {
    if (!confirm("Eliminar este producto?")) return;
    try {
      await ProductoServicio.eliminar(id);
      getProductos();
    } catch {
      alert("No se pudo eliminar el producto");
    }
  };

  useEffect(() => {
    getProductos();
  }, []);

  return (
    <div>
      <Card>
        <CardBody>
          <div className="d-flex justify-content-between align-items-center mb-3">
            <h2>Listado de Productos</h2>
            <Link to="/producto/nuevo" className="btn btn-outline-primary">
              Anadir Producto
            </Link>
            <Link to="/usuarios" className="btn btn-outline-secondary">
              Gestión de Usuarios
            </Link>
          </div>
          <Table striped bordered hover>
            <thead className="table-dark">
              <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Precio</th>
                <th>Accion</th>
              </tr>
            </thead>
            <tbody>
              {productos.length === 0 ? (
                <tr>
                  <td colSpan={5} className="text-center">
                    No hay productos
                  </td>
                </tr>
              ) : (
                productos.map((p: any) => (
                  <tr key={p.id}>
                    <td>{p.id}</td>
                    <td>{p.nombre}</td>
                    <td>{p.descripcion}</td>
                    <td>${p.precio}</td>
                    <td>
                      <Link
                        to={`/producto/editar/${p.id}`}
                        className="btn btn-outline-warning btn-sm me-1"
                      >
                        Editar
                      </Link>
                      <Button
                        variant="outline-danger"
                        size="sm"
                        onClick={() => eliminarProducto(p.id)}
                      >
                        Eliminar
                      </Button>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </Table>
        </CardBody>
      </Card>
    </div>
  );
};

export default Home;
