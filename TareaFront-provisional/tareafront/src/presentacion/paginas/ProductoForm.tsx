import { useEffect } from "react"
import { useForm } from "react-hook-form"
import { Button, Card, CardBody, Form } from "react-bootstrap"
import { useNavigate, useParams } from "react-router-dom"
import { ProductoServicio } from "../../aplicacion/servicios/ProductoServicio"

const ProductoForm = () => {
  const { id } = useParams()
  const isEdit = !!id
  const { register, handleSubmit, reset } = useForm()
  const navigate = useNavigate()

  useEffect(() => {
    if (!isEdit) return
    ProductoServicio.obtenerPorId(Number(id))
      .then((data) => reset(data))
      .catch(() => alert("Error al cargar producto"))
  }, [id, isEdit, reset])

  const guardarProducto = async (data: any) => {
    try {
      if (isEdit) {
        await ProductoServicio.actualizar(Number(id), data)
        alert("Producto actualizado")
      } else {
        await ProductoServicio.crear(data)
        alert("Producto registrado")
      }
      navigate("/home")
    } catch {
      alert("Error al guardar producto")
    }
  }

  return (
    <div className="container mt-5">
      <Card className="shadow p-4">
        <CardBody>
          <h2>{isEdit ? "Editar Producto" : "Nuevo Producto"}</h2>
          <Button variant="outline-secondary" onClick={() => navigate("/home")}>Regresar al Home</Button>
          <Form onSubmit={handleSubmit(guardarProducto)}>
            <Form.Group>
              <Form.Label>Nombre del producto</Form.Label>
              <Form.Control type="text" {...register("nombre")} required />
            </Form.Group>
            <Form.Group>
              <Form.Label>Descripcion</Form.Label>
              <Form.Control type="text" {...register("descripcion")} required />
            </Form.Group>
            <Form.Group>
              <Form.Label>Precio</Form.Label>
              <Form.Control type="number" step="0.01" {...register("precio")} required />
            </Form.Group>
            <Button className="mt-3" type="submit">Guardar Producto</Button>
          </Form>
        </CardBody>
      </Card>
    </div>
  )
}

export default ProductoForm
