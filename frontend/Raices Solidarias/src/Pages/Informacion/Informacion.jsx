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
									    Las principales causas de la
										deforestación en Chile incluyen la expansión de la
										agricultura, la ganadería, la silvicultura comercial, la
										minería, los incendios forestales y la urbanización. Estas
										actividades humanas han llevado a la pérdida de bosques y
										vegetación natural en diversas regiones del país.
									</p>
									<p className="text-info">
										La deforestación tiene impactos
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
										
									</p>
									<p className="text-info">
										
									</p>
									<p className="text-info">
										
									</p>
								</>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion2" ? (
								<p className="text-info">A pesar de los esfuerzos del gobierno, la tala ilegal ha sido un problema importante en Chile durante varias décadas, causando una variedad de problemas ambientales, sociales y económicos. Según el Banco Mundial, la tala ilegal en los bosques nativos de Chile destruyó 11.368 hectáreas de tierra entre 2013 y 2019; y generó 1,2 millones de m3 de madera extraída ilegalmente, lo que provocó deforestación, pérdida de biodiversidad, degradación ambiental y aumento de la violencia. Las regiones del sur del país, como La Araucanía y Biobío, se encuentran entre las más afectadas por las actividades de tala ilegal. En mayo de 2022, el gobierno declaró estado de emergencia en la región de La Araucanía y en las provincias de Arauco y Biobío dentro de la región del Biobío.</p>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion3" ? (
								<p className="text-info">Chile es hogar de una rica diversidad de árboles nativos que han evolucionado y prosperado en sus diversos ecosistemas a lo largo de milenios. Desde los imponentes alerces y araucarias en el sur hasta los cactos y algarrobos en el árido norte, la flora nativa chilena es única y variada. Estos árboles no solo son una parte integral de los paisajes chilenos, sino que también desempeñan un papel crucial en la conservación del suelo, la protección de la biodiversidad y la regulación del clima. Además, muchas de estas especies nativas tienen una profunda importancia cultural para las comunidades indígenas, que las han valorado y protegido a lo largo de generaciones como parte de su patrimonio y conexión con la tierra.</p>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion4" ? (
								<p className="text-info">La plantación de árboles es una actividad fundamental para la restauración y preservación de los ecosistemas en todo el mundo. Más allá de embellecer el paisaje, la siembra de árboles desempeña un papel crucial en la mitigación del cambio climático al absorber dióxido de carbono de la atmósfera, proporcionar hábitats para la vida silvestre y proteger el suelo contra la erosión. Además, la plantación de árboles contribuye a mejorar la calidad del aire y el agua, así como a promover la salud y el bienestar humano al crear espacios verdes para el recreo y la contemplación. Esta práctica no solo tiene beneficios ambientales tangibles, sino que también fomenta el sentido de responsabilidad ambiental y la conexión con la naturaleza en las comunidades locales y a nivel global.</p>
							) : (
								<></>
							)}
						</>
						<>
							{openTab === "informacion5" ? (
								<p className="text-info">El manejo sostenible del bosque nativo en Chile es una prioridad para la conservación de la biodiversidad y el mantenimiento de los servicios ecosistémicos. A través de prácticas de gestión forestal que equilibran la conservación con el uso racional de los recursos, se busca proteger la integridad de los bosques nativos y garantizar su capacidad para sostener la vida silvestre, regular el ciclo del agua y proporcionar otros beneficios ambientales clave. Esto implica adoptar enfoques participativos e integradores que involucren a comunidades locales, científicos, empresas y entidades gubernamentales en la toma de decisiones que promuevan la conservación a largo plazo</p>
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
