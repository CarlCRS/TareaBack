import { api } from "../config/conexion"

export const ProductoApi = {
  async obtenerTodos() {
    const response = await api.get("/api/v1/productos")
    return response.data
  },

  async obtenerPorId(id: number) {
    const response = await api.get(`/api/v1/productos/${id}`)
    return response.data
  },

  async crear(data: any) {
    const response = await api.post("/api/v1/productos", data)
    return response.data
  },

  async actualizar(id: number, data: any) {
    const response = await api.put(`/api/v1/productos/${id}`, data)
    return response.data
  },

  async eliminar(id: number) {
    await api.delete(`/api/v1/productos/${id}`)
  },
}
