import { useState } from "react";
import "./informacion.css";
import imagenFondo from "../../components/assets/ArbolInformacion.svg";

function Informacion() {
	const [openTab, setOpenTab] = useState("informacion1");
	const [cambiarColor, setColor] = useState("btt-tabs");

	return (
		<>
			<div className="container-principalInformaciones">
				<div className="container-tabuladores">
					<div className="tabuladores">
						<ul className="tab-menu">
							<button
								className={
									cambiarColor === "btt-tabs1" ? "btt-tabs1" : "btt-tabs"
								}
								onClick={() => {
									setOpenTab("informacion1");
									setColor("btt-tabs1");
								}}
							>
								DEFORESTACIÓN
							</button>
							<button
								className={
									cambiarColor === "btt-tabs2" ? "btt-tabs2" : "btt-tabs"
								}
								onClick={() => {
									setOpenTab("informacion2");
									setColor("btt-tabs2");
								}}
							>
								TALA ILEGAL
							</button>
							<button
								className={
									cambiarColor === "btt-tabs3" ? "btt-tabs3" : "btt-tabs"
								}
								onClick={() => {
									setOpenTab("informacion3");
									setColor("btt-tabs3");
								}}
							>
								ÁRBOLES NATIVOS DE CHILE
							</button>
							<button
								className={
									cambiarColor === "btt-tabs4" ? "btt-tabs4" : "btt-tabs"
								}
								onClick={() => {
									setOpenTab("informacion4");
									setColor("btt-tabs4");
								}}
							>
								PLANTACIÓN DE ÁRBOLES
							</button>
							<button
								className={
									cambiarColor === "btt-tabs5" ? "btt-tabs5" : "btt-tabs"
								}
								onClick={() => {
									setOpenTab("informacion5");
									setColor("btt-tabs5");
								}}
							>
								MANEJO SOSTENIBLE
							</button>
						</ul>
					</div>
					<div className="container-info">
						<>
							{openTab === "informacion1" ? (
								<h2 className="titulo-info">Deforestación</h2>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion2" ? (
								<h2 className="titulo-info">Tala Ilegal</h2>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion3" ? (
								<h2 className="titulo-info">Árboles Nativos de Chile</h2>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion4" ? (
								<h2 className="titulo-info">Plantación de Árboles</h2>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion5" ? (
								<h2 className="titulo-info">
									Manejo Sostenible del Bosque Nativo en Chile{" "}
								</h2>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion1" ? (
								<>
									<p className="text-info">
										1 . Causas de la deforestación: Las principales causas de la
										deforestación en Chile incluyen la expansión de la
										agricultura, la ganadería, la silvicultura comercial, la
										minería, los incendios forestales y la urbanización. Estas
										actividades humanas han llevado a la pérdida de bosques y
										vegetación natural en diversas regiones del país.
									</p>
									<p className="text-info">
										2. Impacto ambiental: La deforestación tiene impactos
										ambientales negativos. La pérdida de bosques disminuye la
										biodiversidad ya que muchos ecosistemas y especies dependen
										de los bosques para su supervivencia. Además, los bosques
										desempeñan un papel crucial en la regulación del clima, la
										conservación del agua, la protección del suelo contra la
										erosión y la captura de carbono. La deforestación también
										puede aumentar el riesgo de inundaciones, aumentos graduales
										de la tierra y la pérdida de hábitats naturales.
									</p>
									<p className="text-info">
										3. Políticas y regulaciones: Chile cuenta con leyes y
										regulaciones destinadas a proteger los bosques y prevenir la
										deforestación. La Ley de Bosque Nativo y el Sistema Nacional
										de Áreas Silvestres Protegidas del Estado son algunos de los
										mecanismos legales utilizados para conservar los bosques y
										regular su uso. Sin embargo, la implementación y el
										cumplimiento de estas regulaciones puede ser un desafío.
									</p>
									<p className="text-info">
										4. Iniciativas de conservación y restauración: En respuesta
										a la deforestación, se han desarrollado diversas iniciativas
										de conservación y restauración en Chile. Estos programas
										buscan proteger áreas naturales, promover la reforestación y
										restaurar ecosistemas degradados. También se fomenta la
										educación ambiental y la conciencia sobre la importancia de
										los bosques.
									</p>
									<p className="text-info">
										La protección y gestión sostenible de los bosques son
										fundamentales para garantizar la salud del medio ambiente y
										el bienestar de las comunidades locales.
									</p>
								</>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion2" ? (
								<p className="text-info">gente</p>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion3" ? (
								<p className="text-info">del yutu</p>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion4" ? (
								<p className="text-info">como</p>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion5" ? (
								<p className="text-info">estamos?</p>
							) : (
								<></>
							)}
						</>
					</div>
					<img className="imagen-info" src={imagenFondo} alt="Imagen-Info" />
				</div>
			</div>
		</>
	);
}

export default Informacion;
