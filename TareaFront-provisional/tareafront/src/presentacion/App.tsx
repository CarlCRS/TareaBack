import "../App.css"
import { Route, Routes } from "react-router-dom"
import Login from "./paginas/Login"
import Register from "./paginas/Register"
import Home from "./paginas/Home"
import ProductoForm from "./paginas/ProductoForm"
import Usuarios from "./paginas/Usuarios"

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/registro" element={<Register />} />
      <Route path="/home" element={<Home />} />
      <Route path="/producto/nuevo" element={<ProductoForm />} />
      <Route path="/producto/editar/:id" element={<ProductoForm />} />
      <Route path="/usuarios" element={<Usuarios />} />
    </Routes>
  )
}

export default App
