import "./Perfil.css";

import Header from "../../Components/Header/Header";
import { useState } from "react";

const Perfil = () => {

    const [formData, setFormData] = useState({
        nomeDeUsuario: "",
        email: "",
        senha: "",
        tipoUsuario: "Usuario", // Valor padrão
    });
    
    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };
    
    return (
        <div className="perfil">
            <div className="container">
            <Header/>
                <h2>Editar Perfil</h2>
                <form className="perfilEdit">
                <input type="text" placeholder="Nome de Usuário" required />
                <input type="text" placeholder="E-mail" required />
                <input type="password" placeholder="Nova Senha" />
                <h3>Tipo de Perfil</h3>
                <label>
                        <input
                            type="radio"
                            name="tipoUsuario"
                            value="Usuario"
                            checked={formData.tipoUsuario === "Usuario"}
                            onChange={handleChange}
                        />
                        Usuário
                    </label>
                    <label>
                        <input
                            type="radio"
                            name="tipoUsuario"
                            value="Administrador"
                            checked={formData.tipoUsuario === "Administrador"}
                            onChange={handleChange}
                        />
                        Administrador
                    </label>
                <button type="submit">Salvar Alterações</button>
                </form>
            </div>
        </div>
    );
};

export default Perfil;