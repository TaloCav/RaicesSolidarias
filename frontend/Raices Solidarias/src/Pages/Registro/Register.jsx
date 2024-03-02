import React, { useEffect, useState } from "react";
import "./Register.css";
import logoRegistro from "../../components/assets/logo.png";
import axios from "axios";

function Register() {
  const [formData, setFormData] = useState({
    nombre: "",
    apellido: "",
    fechaDeNacimiento: "",
    email: "",
    contrasenia: "",
    confirmarContraseña: "",
    donador: false,
    voluntario: false,
  });

  const handleChange = (e) => {
    const { id, value, type, checked } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [id]: type === "checkbox" ? checked : value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // Verificar si las contraseñas coinciden
    if (formData.contrasenia !== formData.confirmarContraseña) {
      alert("Las contraseñas no coinciden");
      return; // Detener el envío del formulario
    }

    // Crear la lista de roles a partir de los campos donador y voluntario
    const rol = [];
    if (formData.donador) {
      rol.push("Donador");
    }
    if (formData.voluntario) {
      rol.push("Voluntario");
    }

    // Crear el objeto formDataWithRoles que incluye los roles
    const formDataWithRoles = {
      ...formData,
      roles: rol,
    };

    // Eliminar confirmarContraseña y voluntario del objeto formDataWithRoles
    delete formDataWithRoles.confirmarContraseña;
    delete formDataWithRoles.voluntario;
    delete formDataWithRoles.donador;

    try {
      console.log(formDataWithRoles);
      const response = await axios.post(
        "http://localhost:8080/usuario/registrar",
        formDataWithRoles
      );
      console.log(response.data);
    } catch (error) {
      console.error("Error al registrar usuario:", error);
    }
  };
  return (
    <>
      <div className="contenedorLogoRegistro">
        <img
          className="logoRegistro"
          src={logoRegistro}
          alt="logo para registro user"
        />
      </div>
      <div className="signupFrm">
        <form action="" onSubmit={handleSubmit} className="form">
          <h1 className="titulo-form">Registrarse</h1>

          <div className="inputContainer">
            <input
              type="text"
              className="input"
              id="nombre"
              value={formData.nombre}
              onChange={handleChange}
              placeholder="a"
            />
            <label form="" className="label">
              Nombre
            </label>
          </div>

          <div className="inputContainer">
            <input
              type="text"
              className="input"
              id="apellido"
              placeholder="a"
              value={formData.apellido}
              onChange={handleChange}
            />
            <label form="" className="label">
              Apellido
            </label>
          </div>

          <div className="inputContainer">
            <input
              type="text"
              className="input"
              id="fechaDeNacimiento"
              placeholder="a"
              value={formData.fechaDeNacimiento}
              onChange={handleChange}
            />
            <label form="" className="label">
              Fecha de Nacimiento año-mes-dia
            </label>
          </div>

          <div className="inputContainer">
            <input
              type="text"
              className="input"
              id="email"
              placeholder="a"
              value={formData.email}
              onChange={handleChange}
            />
            <label form="" className="label">
              Email
            </label>
          </div>

          <div className="inputContainer">
            <input
              type="password"
              className="input"
              id="contrasenia"
              placeholder="a"
              value={formData.contrasenia}
              onChange={handleChange}
            />
            <label form="" className="label">
              Contraseña
            </label>
          </div>

          <div className="inputContainer">
            <input
              type="password"
              className="input"
              id="confirmarContraseña"
              placeholder="a"
              value={formData.confirmarContraseña}
              onChange={handleChange}
            />
            <label form="" className="label">
              Confirmar Contraseña
            </label>
          </div>
          <div className="contenedor-checkbox1">
            <h2>Quiero Ser...</h2>
            <div className="contenedor-checkbox2">
              <div>
                <label form="" className="label-check">
                  Donador
                </label>
                <input
                  type="checkbox"
                  className="checkbox-input"
                  id="donador"
                  checked={formData.donador}
                  onChange={handleChange}
                />
              </div>
              <div>
                <label form="" className="label-check">
                  Voluntario
                </label>
                <input
                  type="checkbox"
                  className="checkbox-input"
                  id="voluntario"
                  checked={formData.voluntario}
                  onChange={handleChange}
                />
              </div>
            </div>
          </div>

          <input type="submit" className="submitBtn" value="Registrarme" />
        </form>
      </div>
    </>
  );
}

export default Register;
