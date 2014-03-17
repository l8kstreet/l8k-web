<%-- 
    Document   : registrar
    Created on : 12/03/2014, 02:54:10 PM
    Author     : jaquise
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>l8kstreet</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1"/>
        <link href="/l8kstreet/resources/css/html5/normalize.css" rel="stylesheet" type='text/css' />
        <link href="/l8kstreet/resources/css/login.css" rel="stylesheet" type='text/css' />
    </head>
    <body>
        <header>
            <figure id="logo" >
                <img src="/l8kstreet/resources/img/logo.png" />
            </figure>
            <p>l8kstreet</p>
        </header>

        <section>
            <div id="contenido">
                <h1>Regístrate</h1>

                <form id="frmRegistrar" action="/l8kstreet/faces/login/registrar" method="post" >                    
                    <input type="hidden" name="estado" value="A" />

                    <label for="txtNombre" >Nombre completo</label>
                    <input type="text" id="txtNombre" name="nombre" required="required" />

                    <label for="txtCorreo" >Dirección de correo electrónico</label>
                    <input type="email" id="txtCorreo" name="correo" required="required" />

                    <label for="txtUsuario" >Escoge tu nombre de usuario</label>
                    <input type="text" id="txtUsuario" name="usuario" required="required" />

                    <label for="txtContrasenha" >Crea una contraseña</label>
                    <input type="password" id="txtContrasenha" name="contrasenha" required="required" />

                    <label for="txtContrasenha" >Confirma tu contraseña</label>
                    <input type="password" id="txtConfirmar" required="required" />

                    <label for="txtFecha" >Fecha de Nacimiento</label>
                    <input type="date" id="txtFecha" name="fechaNacimiento" required="required" />

                    <label for="txtFecha" >Pais</label>
                    <select id="cboPais" name="pais" >
                        <option value="AF">Afganistán</option><option value="AL">Albania</option><option value="DE">Alemania</option><option value="AD">Andorra</option><option value="AO">Angola</option><option value="AI">Anguila</option><option value="AQ">Antártida</option><option value="AG">Antigua y Barbuda</option><option value="SA">Arabia Saudí</option><option value="DZ">Argelia</option><option value="AR">Argentina</option><option value="AM">Armenia</option><option value="AW">Aruba</option><option value="AU">Australia</option><option value="AT">Austria</option><option value="PS">Autoridad Palestina</option><option value="AZ">Azerbaiyán</option><option value="BD">Bangladesh</option><option value="BB">Barbados</option><option value="BY">Belarús</option><option value="BE">Bélgica</option><option value="BZ">Belice</option><option value="BJ">Benín</option><option value="BM">Bermudas</option><option value="BO">Bolivia</option><option value="BQ">Bonaire</option><option value="BA">Bosnia y Herzegovina</option><option value="BW">Botsuana</option><option value="BR">Brasil</option><option value="BN">Brunéi</option><option value="BG">Bulgaria</option><option value="BF">Burkina Faso</option><option value="BI">Burundi</option><option value="BT">Bután</option><option value="CV">Cabo Verde</option><option value="KH">Camboya</option><option value="CM">Camerún</option><option value="CA">Canadá</option><option value="TD">Chad</option><option value="CL">Chile</option><option value="CN">China</option><option value="CY">Chipre</option><option value="VA">Ciudad estado del Vaticano (Santa Sede)</option><option value="CO">Colombia</option><option value="KM">Comoras</option><option value="CD">Congo (RDC)</option><option value="KP">Corea del Norte</option><option value="KR">Corea del Sur</option><option value="CR">Costa Rica</option><option value="HR">Croacia (Hrvatska)</option><option value="CU">Cuba</option><option value="CW">Curazao</option><option value="DK">Dinamarca</option><option value="DM">Dominica</option><option value="EC">Ecuador</option><option value="EG">Egipto</option><option value="SV">El Salvador</option><option value="AE">Emiratos Árabes Unidos</option><option value="ER">Eritrea</option><option value="SK">Eslovaquia</option><option value="SI">Eslovenia</option><option value="ES">España</option><option value="US">Estados Unidos</option><option value="EE">Estonia</option><option value="ET">Etiopía</option><option value="MK">Ex-República Yugoslava de Macedonia</option><option value="PH">Filipinas</option><option value="FI">Finlandia</option><option value="FR">Francia</option><option value="GA">Gabón</option><option value="GM">Gambia</option><option value="GE">Georgia</option><option value="GS">Georgia del Sur e Islas Sandwich del Sur</option><option value="GH">Ghana</option><option value="GI">Gibraltar</option><option value="GD">Granada</option><option value="GR">Grecia</option><option value="GL">Groenlandia</option><option value="GP">Guadalupe</option><option value="GU">Guam</option><option value="GT">Guatemala</option><option value="GF">Guayana Francesa</option><option value="GG">Guernsey</option><option value="GN">Guinea</option><option value="GQ">Guinea Ecuatorial</option><option value="GW">Guinea-Bissau</option><option value="GY">Guyana</option><option value="HT">Haití</option><option value="HN">Honduras</option><option value="HK">Hong Kong RAE</option><option value="HU">Hungría</option><option value="IN">India</option><option value="ID">Indonesia</option><option value="IQ">Irak</option><option value="IR">Irán</option><option value="IE">Irlanda</option><option value="BV">Isla Bouvet</option><option value="CX">Isla Christmas</option><option value="IM">Isla de Man</option><option value="NF">Isla Norfolk</option><option value="IS">Islandia</option><option value="AX">Islas Åland</option><option value="KY">Islas Caimán</option><option value="CC">Islas Cocos</option><option value="CK">Islas Cook</option><option value="FO">Islas Feroe</option><option value="FJ">Islas Fiji</option><option value="HM">Islas Heard y McDonald</option><option value="FK">Islas Malvinas (Falkland Islands)</option><option value="MP">Islas Marianas del Norte</option><option value="MH">Islas Marshall</option><option value="UM">Islas menores alejadas de los Estados Unidos</option><option value="PN">Islas Pitcairn</option><option value="SB">Islas Salomón</option><option value="TC">Islas Turcas y Caicos</option><option value="VG">Islas Vírgenes Británicas</option><option value="VI">Islas Vírgenes, EE.UU.</option><option value="IL">Israel</option><option value="IT">Italia</option><option value="JM">Jamaica</option><option value="SJ">Jan Mayen</option><option value="JP">Japón</option><option value="JE">Jersey</option><option value="JO">Jordania</option><option value="KZ">Kazajistán</option><option value="KE">Kenia</option><option value="KG">Kirguistán</option><option value="KI">Kiribati</option><option value="KW">Kuwait</option><option value="LA">Laos</option><option value="BS">Las Bahamas</option><option value="LS">Lesoto</option><option value="LV">Letonia</option><option value="LB">Líbano</option><option value="LR">Liberia</option><option value="LY">Libia</option><option value="LI">Liechtenstein</option><option value="LT">Lituania</option><option value="LU">Luxemburgo</option><option value="MO">Macao RAE</option><option value="MG">Madagascar</option><option value="MY">Malasia</option><option value="MW">Malawi</option><option value="MV">Maldivas</option><option value="ML">Malí</option><option value="MT">Malta</option><option value="MA">Marruecos</option><option value="MQ">Martinica</option><option value="MU">Mauricio</option><option value="MR">Mauritania</option><option value="YT">Mayotte</option><option value="MX">México</option><option value="FM">Micronesia</option><option value="MD">Moldova</option><option value="MC">Mónaco</option><option value="MN">Mongolia</option><option value="ME">Montenegro</option><option value="MS">Montserrat</option><option value="MZ">Mozambique</option><option value="MM">Myanmar</option><option value="NA">Namibia</option><option value="NR">Nauru</option><option value="NP">Nepal</option><option value="NI">Nicaragua</option><option value="NE">Níger</option><option value="NG">Nigeria</option><option value="NU">Niue</option><option value="NO">Noruega</option><option value="NC">Nueva Caledonia</option><option value="NZ">Nueva Zelanda</option><option value="OM">Omán</option><option value="NL">Países Bajos</option><option value="PK">Pakistán</option><option value="PW">Palaos</option><option value="PA">Panamá</option><option value="PG">Papúa Nueva Guinea</option><option value="PY">Paraguay</option><option selected value="PE">Perú</option><option value="PF">Polinesia Francesa</option><option value="PL">Polonia</option><option value="PT">Portugal</option><option value="PR">Puerto Rico</option><option value="QA">Qatar</option><option value="BH">Reino de Baréin</option><option value="UK">Reino Unido</option><option value="CF">República Centroafricana</option><option value="CZ">República Checa</option><option value="CI">República de Côte d'Ivoire</option><option value="CG">República del Congo</option><option value="DO">República Dominicana</option><option value="RE">Reunión</option><option value="RW">Ruanda</option><option value="RO">Rumania</option><option value="RU">Rusia</option><option value="XS">Saba</option><option value="KN">Saint Kitts y Nevis</option><option value="WS">Samoa</option><option value="AS">Samoa Americana</option><option value="BL">San Bartolomé</option><option value="XE">San Eustaquio</option><option value="SM">San Marino</option><option value="MF">San Martín</option><option value="PM">San Pedro y Miquelón</option><option value="VC">San Vicente y las Granadinas</option><option value="SH">Santa Elena</option><option value="LC">Santa Lucía</option><option value="ST">Santo Tomé y Príncipe</option><option value="SN">Senegal</option><option value="RS">Serbia</option><option value="SC">Seychelles</option><option value="SL">Sierra Leona</option><option value="SG">Singapur</option><option value="SX">Sint Maarten</option><option value="SY">Siria</option><option value="SO">Somalia</option><option value="LK">Sri Lanka</option><option value="SZ">Suazilandia</option><option value="ZA">Sudáfrica</option><option value="SD">Sudán</option><option value="SE">Suecia</option><option value="CH">Suiza</option><option value="SR">Surinam</option><option value="TH">Tailandia</option><option value="TW">Taiwán</option><option value="TZ">Tanzania</option><option value="TJ">Tayikistán</option><option value="IO">Territorio Británico del Océano Índico</option><option value="TF">Tierras Australes y Antárticas Francesas</option><option value="TL">Timor-Leste</option><option value="TG">Togo</option><option value="TK">Tokelau</option><option value="TO">Tonga</option><option value="TT">Trinidad y Tobago</option><option value="TN">Túnez</option><option value="TM">Turkmenistán</option><option value="TR">Turquía</option><option value="TV">Tuvalu</option><option value="UA">Ucrania</option><option value="UG">Uganda</option><option value="UY">Uruguay</option><option value="UZ">Uzbekistán</option><option value="VU">Vanuatu</option><option value="VE">Venezuela</option><option value="VN">Vietnam</option><option value="WF">Wallis y Futuna</option><option value="YE">Yemen</option><option value="DJ">Yibuti</option><option value="ZM">Zambia</option><option value="ZW">Zimbabue</option>
                    </select>

                    <input type="submit" value="Crear cuenta" />
                    <a href="/l8kstreet/faces/login" >Cancelar</a>
                </form>
            </div>
        </section>

        <footer>

        </footer>
    </body>
</html>
