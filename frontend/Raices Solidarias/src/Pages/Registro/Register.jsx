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
    password: "",
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
    if (formData.password !== formData.confirmarContraseña) {
      alert("Las contraseñas no coinciden");
      return; // Detener el envío del formulario
    }

    // Verificar el formato de correo electrónico
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(formData.email)) {
      alert("El correo electrónico no es válido");
      return;
    }

    // Verificar el formato de la fecha de nacimiento
    const dateRegex = /^\d{4}-\d{2}-\d{2}$/;
    if (!dateRegex.test(formData.fechaDeNacimiento)) {
      alert("El formato de fecha de nacimiento no es válido (AAAA-MM-DD)");
      return;
    }

    // Crear la lista de roles a partir de los campos donador y voluntario
    const rol = [];
    if (formData.donador) {
      rol.push("donante");
    }
    if (formData.voluntario) {
      rol.push("voluntario");
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
        "http://localhost:8080/api/auth/registro",
        formDataWithRoles
      );
      console.log(response.data);
    } catch (error) {
      console.error("Error al registrar usuario:", error);
    }
  };

  return (
    <>
      <div className="contenedor-hiddenNavbar">
        <div className="contenedorLogoRegistro">
          <img
            className="logoRegistro"
            src={logoRegistro}
            alt="logo para registro user"
          />
        </div>
        <div className="contenedor-volverRegistro">
          <a className="volver-registro" href="/">
            Volver
          </a>
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
              <label htmlFor="nombre" className="label">
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
              <label htmlFor="apellido" className="label">
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
              <label htmlFor="fechaDeNacimiento" className="label">
                Fecha de Nacimiento (AAAA-MM-DD)
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
              <label htmlFor="email" className="label">
                Email
              </label>
            </div>

            <div className="inputContainer">
              <input
                type="password"
                className="input"
                id="password"
                placeholder="a"
                value={formData.password}
                onChange={handleChange}
              />
              <label htmlFor="password" className="label">
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
              <label htmlFor="confirmarContraseña" className="label">
                Confirmar Contraseña
              </label>
            </div>
            <div className="contenedor-checkbox1">
              <h2>Quiero Ser...</h2>
              <div className="contenedor-checkbox2">
                <div>
                  <label htmlFor="donador" className="label-check">
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
      </div>
    </>
  );
}

export default Register;
