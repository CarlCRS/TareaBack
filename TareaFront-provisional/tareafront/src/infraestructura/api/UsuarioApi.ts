import { api } from "../config/conexion"

export const UsuarioApi = {
  async mayoresDe18() {
    const response = await api.get("/api/v1/usuarios/mayores-18")
    return response.data
  },

  async nombres() {
    const response = await api.get("/api/v1/usuarios/nombres")
    return response.data
  },

  async nombresOrdenados() {
    const response = await api.get("/api/v1/usuarios/nombres-ordenados")
    return response.data
  },

  async contarMayores() {
    const response = await api.get("/api/v1/usuarios/contar-mayores")
    return response.data
  },
}
