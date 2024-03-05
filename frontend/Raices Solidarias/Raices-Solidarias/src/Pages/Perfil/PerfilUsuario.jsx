import React, { useEffect, useState } from "react";
import Arboles from "../../components/Arboles/Arboles";
import "./PerfilUsuario.css";

function PerfilUsuario() {
 
  return (
    <div className="container-perfil">
      <div className="container-medio">
        <a href="">&#8592; VOLVER</a>
      <div className="container-usuario">
        <h2>PERFIL DEL USUARIO</h2>
       
          <div>
            <p>Nombre: </p>
            <p>Apellido: </p>
            <p>Género: </p>
            <p>Fecha de Nacimiento: </p>
            <p>Roles: </p>
          </div>
   
      </div>
      <div className="botones-container">
        <button className="formato-boton">DONAR</button>
        <button className="formato-boton">INSCRIBIRME</button>
      </div>
      </div>
      <div className="arboles-container">
        <Arboles />
      </div>
    </div>
  );
}

export default PerfilUsuario;