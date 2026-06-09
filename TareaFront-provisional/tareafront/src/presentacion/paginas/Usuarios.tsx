import { useEffect, useState } from "react";
import { Button, Card, CardBody, Table } from "react-bootstrap";
import { UsuarioServicio } from "../../aplicacion/servicios/UsuarioServicio";

const Usuarios = () => {
  const [usuarios, setUsuarios] = useState([]);
  const [nombres, setNombres] = useState([]);
  const [nombresOrdenados, setNombresOrdenados] = useState([]);
  const [contarMayores, setContarMayores] = useState(0);

  const getInfo = async () => {
    try {
      const [users, names, sorted, count] = await Promise.all([
        UsuarioServicio.mayoresDe18(),
        UsuarioServicio.nombres(),
        UsuarioServicio.nombresOrdenados(),
        UsuarioServicio.contarMayores(),
      ]);
      setUsuarios(users);
      setNombres(names);
      setNombresOrdenados(sorted);
      setContarMayores(count);
    } catch {
      alert("Error al cargar usuarios");
    }
  };

  useEffect(() => {
    getInfo();
  }, []);

  return (
    <div className="container mt-4">
      <Card className="shadow p-4 mb-3">
        <Button variant="outline-primary" href="/home">
          Home
        </Button>
        <CardBody>
          <h2>Usuarios Mayores de Edad</h2>
          <p>
            Total: <strong>{contarMayores}</strong>
          </p>
          <Table striped bordered hover>
            <thead className="table-dark">
              <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Edad</th>
                <th>Correo</th>
              </tr>
            </thead>
            <tbody>
              {usuarios.map((u: any) => (
                <tr key={u.id}>
                  <td>{u.id}</td>
                  <td>{u.nombre}</td>
                  <td>{u.apellido}</td>
                  <td>{u.edad}</td>
                  <td>{u.correo}</td>
                </tr>
              ))}
            </tbody>
          </Table>
        </CardBody>
      </Card>
      <div className="row">
        <div className="col-md-6">
          <Card className="shadow p-4">
            <CardBody>
              <h2>Nombres</h2>
              <ul>
                {nombres.map((n: string, i: number) => (
                  <li key={i}>{n}</li>
                ))}
              </ul>
            </CardBody>
          </Card>
        </div>
        <div className="col-md-6">
          <Card className="shadow p-4">
            <CardBody>
              <h2>Nombres (A-Z)</h2>
              <ul>
                {nombresOrdenados.map((n: string, i: number) => (
                  <li key={i}>{n}</li>
                ))}
              </ul>
            </CardBody>
          </Card>
        </div>
      </div>
    </div>
  );
};

export default Usuarios;
