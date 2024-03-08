import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Arboles from "../../components/Arboles/Arboles";
import logoRegistro from "../../components/assets/logo.png";
import axios from "axios";
import "./PerfilUsuario.css";

function PerfilUsuario() {
  const [usuario, setUsuario] = useState(null);
  const [numeroArboles, setNumeroArboles] = useState(0);
  const [roles, setRoles] = useState([]);

  useEffect(() => {

    const emailUsuario = JSON.parse(localStorage.getItem("user")).email;


    axios.get(`http://localhost:8080/usuario/${emailUsuario}/atributos`)
      .then(response => {
        setUsuario(response.data[0]); // Acceder al primer elemento de la lista

    
        axios.get(`http://localhost:8080/usuario/${emailUsuario}/numero-arboles`)
          .then(response => {
            setNumeroArboles(response.data);
          })
          .catch(error => {
            console.error("Error al obtener el número de árboles del usuario:", error);
          });

        // Obtener los roles del usuario con el email obtenido
        axios.get(`http://localhost:8080/usuario/${emailUsuario}/roles`)
          .then(response => {
            setRoles(response.data);
          })
          .catch(error => {
            console.error("Error al obtener los roles del usuario:", error);
          });
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
            {usuario && (
              <div>
                <p><strong>Nombre:</strong> {usuario[0]}</p> 
                <p><strong>Apellido:</strong> {usuario[1]}</p> 
                <p><strong>Fecha de Nacimiento:</strong> {usuario[2]}</p> 
                <p><strong>Roles:</strong> {obtenerRolesComoTexto(roles)}</p>
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