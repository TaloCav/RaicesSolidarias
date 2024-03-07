import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Arboles from "../../components/Arboles/Arboles";
import logoRegistro from "../../components/assets/logo.png";
import axios from "axios";
import "./PerfilUsuario.css";

function PerfilUsuario() {
  const [primerUsuario, setPrimerUsuario] = useState(null);
  const [numeroArboles, setNumeroArboles] = useState(0);

  useEffect(() => {
    axios.get("http://localhost:8080/usuario/todos")
      .then(response => {
      
        if (response.data.length > 0) {
      
          setPrimerUsuario(response.data[0]);

          // Obtener el número de árboles asociados al usuario con id 1
          axios.get("http://localhost:8080/usuario/1/numero-arboles")
            .then(response => {
              setNumeroArboles(response.data);
            })
            .catch(error => {
              console.error("Error al obtener el número de árboles del usuario:", error);
            });
        }
      })
      .catch(error => {
        console.error("Error al obtener los datos del usuario:", error);
      });
  }, []);

  const obtenerRolesComoTexto = (roles) => {
  
    if (roles && Array.isArray(roles)) {
      const rolesSinPrefijo = roles.map(role => role.nombre.replace('ROLE_', ''));
      return rolesSinPrefijo.join(", ");
    } else {
      return "N/A";
    }
  };

  return (
    <>
      <div className="container-perfil">
        <div className="container-medio">
          <Link to="/otra-ruta">&#8592; VOLVER</Link>
          <div className="container-usuario">
            <h2>PERFIL DEL USUARIO</h2>
            {primerUsuario && (
              <div>
                <p><strong>Nombre:</strong> {primerUsuario.nombre}</p>
                <p><strong>Apellido:</strong> {primerUsuario.apellido}</p>
                <p><strong>Fecha de Nacimiento:</strong> {primerUsuario.fechaDeNacimiento}</p>
                <p><strong>Roles:</strong> {obtenerRolesComoTexto(primerUsuario.roles)}</p>
                <p><strong>Número de Árboles:</strong> {numeroArboles}</p>
              </div>
            )}
          </div>
          <div className="botones-container">
            <Link to="/apadrinar"><button className="formato-boton">DONAR</button></Link>
            <Link to="/registro"><button className="formato-boton">INSCRIBIRME</button></Link>
          </div>
        </div>
        <div className="arboles-container">
          <Arboles />
        </div>
      </div>
    </>
  );
}

export default PerfilUsuario;